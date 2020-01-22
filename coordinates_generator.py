# this script generates a file "input_coords_all.txt which contains the input coordinates."

import pygame
from pygame.locals import *
from sys import exit
from random import *
pygame.init()
# screen = pygame.display.set_mode((1280, 960), 0, 32)


# DIMENSIONS
screen = pygame.display.set_mode((0,0),pygame.RESIZABLE)
factor_horizontal = 120
factor_vertical = 10
field_x = 0 + factor_horizontal
field_y = 0 + factor_vertical
field_length = 900 
field_width = 600 
center_x = 570
center_y = 310
circle_radius = 80
goal_post_length = (2*circle_radius)-20
width_small_d = 50
width_big_d = 150

# STYLING
screen_color = (0,0,0)
field_color = (4,255,100)
field_border_color = (255,255,255)
host_bot_color = (255,255,0)
opp_bot_color = (255,0,0)
goal_post_color = (101,67,33)

host_cord = {}
opp_cord = {}

temp_switch_logic = 0
count = 0
while True:
    for event in pygame.event.get():
        if event.type == QUIT:
            print(host_cord)
            print(temp_switch_logic)
            print(opp_cord)
            exit()

    # FIELD STYLING
    screen.lock()
    
    rectangle_main_border = (field_x-10, field_y-10)
    rectangle_main_border_size = (field_length+20, field_width+20)    
    
    rectangle_main = (field_x, field_y)
    rectangle_main_size = (field_length, field_width)

    screen.fill(screen_color)

    pygame.draw.rect(screen, field_border_color, Rect(rectangle_main_border, rectangle_main_border_size))
    pygame.draw.rect(screen, field_color, Rect(rectangle_main, rectangle_main_size))
    
    # center line vertical
    pygame.draw.line(screen, field_border_color, (center_x,field_y), (center_x, field_y + field_width),1)

    # center circle
    pygame.draw.circle(screen, field_border_color, (center_x,310), circle_radius,1)

    # center line horizontal
    # pygame.draw.line(screen, field_border_color, (field_x,center_y), (field_x + field_length, center_y),1)


    # LEFT Side

    # goalpost
    pygame.draw.line(screen, goal_post_color, (field_x-20,center_y-(goal_post_length//2)), (field_x-20, center_y+(goal_post_length//2)),19)
    # smallD
    pygame.draw.rect(screen, field_border_color, Rect((field_x-1,center_y-(circle_radius)), (width_small_d,2*circle_radius)),1)
    # bigD
    pygame.draw.rect(screen, field_border_color, Rect((field_x-1,center_y-((5/8) * (field_width//2))), (width_big_d,(10/8)*(field_width//2))),1)



    # RIGHT side

    # goalpost
    pygame.draw.line(screen, goal_post_color, (field_x +field_length+19,center_y-(goal_post_length//2)), (field_x +field_length+19, center_y+(goal_post_length//2)),19)
    # smallD
    pygame.draw.rect(screen, field_border_color, Rect((field_x + field_length -(width_small_d - 1),center_y-(circle_radius)), (width_small_d,2*circle_radius)),1)
    # bigD
    pygame.draw.rect(screen, field_border_color, Rect((field_x + field_length -(width_big_d - 1),center_y-((5/8) * (field_width//2))), (width_big_d,(10/8)*(field_width//2))),1)

    screen.unlock()    
    
    # SETUP FOR TEXT
    font = pygame.font.Font('freesansbold.ttf', 10)

    if event.type == pygame.MOUSEBUTTONDOWN and len(host_cord)<7:
        temp = pygame.mouse.get_pos()
        if temp not in host_cord.keys():
            host_cord[pygame.mouse.get_pos()] = len(host_cord)
             
    if event.type == pygame.MOUSEBUTTONDOWN and len(host_cord)==7 and len(opp_cord)<6:
        temp = pygame.mouse.get_pos()
        if temp not in opp_cord.keys():
            opp_cord[pygame.mouse.get_pos()] = len(opp_cord)
                    
    if len(list(host_cord.keys())[:-1]) <= 6:
        for cord in host_cord.keys():
            temp = tuple(cord)    
            pygame.draw.circle(screen, host_bot_color, temp, 10)

            text = font.render(str(host_cord[temp]+1)+str(temp), True, (0,0,0))
            textRect = text.get_rect()
            textRect.center = temp
            screen.blit(text, textRect)

    
    if len(list(opp_cord.keys())) <= 6:
        for cord in opp_cord.keys():
            temp = tuple(cord)    
            pygame.draw.circle(screen, opp_bot_color, temp, 10)
            text = font.render(str(opp_cord[temp]+1)+str(temp), True, (0,0,0))
            textRect = text.get_rect()
            textRect.center = temp
            screen.blit(text, textRect)

    if len(host_cord)>6 and len(opp_cord)==6:
        if count<1:
            host_cord_list = [0 for i in range(6)]
            for i in host_cord.keys():
                if host_cord[i]<=5:
                    host_cord_list[host_cord[i]] = i
            print(host_cord_list)
            file1 = open("input.txt","w")
            text_to_write = ""
            for i in range(len(host_cord_list)):
                text_to_write += str(i+1) +" "+" ".join(list(map(str,host_cord_list[i])))+"\n"
            
            opp_cord_list = [0 for i in range(6)]
            for i in opp_cord.keys():
                if opp_cord[i]<=5:
                    opp_cord_list[opp_cord[i]] = i
            print(opp_cord_list)

            for i in range(len(opp_cord_list)):
                text_to_write += str(i+11) +" "+" ".join(list(map(str,opp_cord_list[i])))+"\n"
            
            file1.write(text_to_write)
            file1.close()
            rect_save = pygame.Rect(field_x,field_y,field_length,field_width)
            sub = screen.subsurface(rect_save)
            pygame.image.save(sub,"screenshot.jpg")
        count +=1   
    pygame.display.update()
pygame.quit()
quit()