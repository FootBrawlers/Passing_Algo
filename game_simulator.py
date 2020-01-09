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

while True:
    for event in pygame.event.get():
        if event.type == QUIT:
            print(host_cord)
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
    if event.type == pygame.MOUSEBUTTONDOWN and len(host_cord)<7:
        temp = pygame.mouse.get_pos()
        if temp not in host_cord.keys():
            host_cord[pygame.mouse.get_pos()] = len(host_cord)
             
    if event.type == pygame.MOUSEBUTTONDOWN and len(host_cord)==7 and len(opp_cord)<6:
        temp = pygame.mouse.get_pos()
        if temp not in opp_cord.keys():
            opp_cord[pygame.mouse.get_pos()] = len(opp_cord)
            
    screen.lock()
    if len(list(host_cord.keys())[:-1]) <= 6:
        for cord in host_cord.keys():
            temp = tuple(cord)    
            pygame.draw.circle(screen, host_bot_color, temp, 10)
    
    if len(opp_cord) <= 6:
        for cord in opp_cord.keys():
            temp = tuple(cord)    
            pygame.draw.circle(screen, opp_bot_color, temp, 10)
    
    screen.unlock()
    pygame.display.update()

pygame.quit()

quit()
