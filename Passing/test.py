# this script generates a file "input_coords_all.txt which contains the input coordinates."

import pygame
from pygame.locals import *
from sys import exit
from random import *
import math as mt

pygame.init()
# screen = pygame.display.set_mode((1280, 960), 0, 32)


# DIMENSIONS
screen = pygame.display.set_mode((0, 0), pygame.RESIZABLE)
factor_horizontal = 120
factor_vertical = 10
field_x = 0 + factor_horizontal
field_y = 0 + factor_vertical
field_length = 900
field_width = 600
center_x = 570
center_y = 310
circle_radius = 80
goal_post_length = (2 * circle_radius) - 20
width_small_d = 50
width_big_d = 150

# STYLING
screen_color = (0, 0, 0)
field_color = (4, 255, 100)
field_border_color = (255, 255, 255)
host_bot_color = (255, 255, 0)
opp_bot_color = (255, 0, 0)
goal_post_color = (101, 67, 33)

host_cord = {}
opp_cord = {}

temp_switch_logic = 0
count = 0
count1=0
upd=0
bot = 0


def generate():
    bot = 0
    while True:
        for event in pygame.event.get():
            if event.type == QUIT:
                print(host_cord)
                print(temp_switch_logic)
                print(opp_cord)
                exit()

        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_RETURN:
                host_cord_list = [0 for i in range(6)]
                for i in host_cord.keys():
                    if host_cord[i] <= 5:
                        host_cord_list[host_cord[i]] = i
                print(host_cord_list)
                file1 = open("input.txt", "w")
                text_to_write = ""
                for i in range(len(host_cord_list)):
                    text_to_write += str(i + 1) + " " + " ".join(list(map(str, host_cord_list[i]))) + "\n"

                opp_cord_list = [0 for i in range(6)]
                for i in opp_cord.keys():
                    if opp_cord[i] <= 5:
                        opp_cord_list[opp_cord[i]] = i
                print(opp_cord_list)

                for i in range(len(opp_cord_list)):
                    text_to_write += str(i + 11) + " " + " ".join(list(map(str, opp_cord_list[i]))) + "\n"

                file1.write(text_to_write)
                file1.close()
                rect_save = pygame.Rect(field_x, field_y, field_length, field_width)
                sub = screen.subsurface(rect_save)
                pygame.image.save(sub, "screenshot.jpg")
                return 0

        # FIELD STYLING
        screen.lock()

        rectangle_main_border = (field_x - 10, field_y - 10)
        rectangle_main_border_size = (field_length + 20, field_width + 20)

        rectangle_main = (field_x, field_y)
        rectangle_main_size = (field_length, field_width)

        screen.fill(screen_color)

        pygame.draw.rect(screen, field_border_color, Rect(rectangle_main_border, rectangle_main_border_size))
        pygame.draw.rect(screen, field_color, Rect(rectangle_main, rectangle_main_size))

        # center line vertical
        pygame.draw.line(screen, field_border_color, (center_x, field_y), (center_x, field_y + field_width), 1)

        # center circle
        pygame.draw.circle(screen, field_border_color, (center_x, 310), circle_radius, 1)
        #pygame.draw.circle(screen, field_border_color, (center_x+100, 400), circle_radius, 1)

        # center line horizontal
        # pygame.draw.line(screen, field_border_color, (field_x,center_y), (field_x + field_length, center_y),1)

        # LEFT Side

        # goalpost
        pygame.draw.line(screen, goal_post_color, (field_x - 20, center_y - (goal_post_length // 2)),
                         (field_x - 20, center_y + (goal_post_length // 2)), 19)
        # smallD
        pygame.draw.rect(screen, field_border_color,
                         Rect((field_x - 1, center_y - (circle_radius)), (width_small_d, 2 * circle_radius)), 1)
        # bigD
        pygame.draw.rect(screen, field_border_color, Rect((field_x - 1, center_y - ((5 / 8) * (field_width // 2))),
                                                          (width_big_d, (10 / 8) * (field_width // 2))), 1)

        # RIGHT side

        # goalpost
        pygame.draw.line(screen, goal_post_color, (field_x + field_length + 19, center_y - (goal_post_length // 2)),
                         (field_x + field_length + 19, center_y + (goal_post_length // 2)), 19)
        # smallD
        pygame.draw.rect(screen, field_border_color,
                         Rect((field_x + field_length - (width_small_d - 1), center_y - (circle_radius)),
                              (width_small_d, 2 * circle_radius)), 1)
        # bigD
        pygame.draw.rect(screen, field_border_color,
                         Rect((field_x + field_length - (width_big_d - 1), center_y - ((5 / 8) * (field_width // 2))),
                              (width_big_d, (10 / 8) * (field_width // 2))), 1)

        screen.unlock()

        # SETUP FOR TEXT
        font = pygame.font.Font('freesansbold.ttf', 10)

        if event.type == pygame.MOUSEBUTTONDOWN and len(host_cord) < 6 and event.button == 1:
            temp = pygame.mouse.get_pos()
            if temp not in host_cord.keys():
                host_cord[pygame.mouse.get_pos()] = len(host_cord)

        if event.type == pygame.MOUSEBUTTONDOWN and len(opp_cord) < 6 and event.button == 3:
            temp = pygame.mouse.get_pos()
            if temp not in opp_cord.keys():
                opp_cord[pygame.mouse.get_pos()] = len(opp_cord)

        if len(list(host_cord.keys())[:-1]) <= 6:
            for cord in host_cord.keys():
                temp = tuple(cord)
                pygame.draw.circle(screen, host_bot_color, temp, 10)

                text = font.render(str(host_cord[temp] + 1) + str(temp), True, (0, 0, 0))
                textRect = text.get_rect()
                textRect.center = temp
                screen.blit(text, textRect)

        if len(list(opp_cord.keys())) <= 6:
            for cord in opp_cord.keys():
                temp = tuple(cord)
                pygame.draw.circle(screen, opp_bot_color, temp, 10)
                text = font.render(str(opp_cord[temp] + 1) + str(temp), True, (0, 0, 0))
                textRect = text.get_rect()
                textRect.center = temp
                screen.blit(text, textRect)
        pygame.display.update()


def show(p):
    host_cords1 = []
    opp_cords1 = []
    input_file = open("input.txt", "r")
    op = input_file.readlines()
    for i in range(len(op)):
        if i < 6:
            host_cords1.append(list(map(int, op[i].strip().split()[1:])))
        else:
            opp_cords1.append(list(map(int, op[i].strip().split()[1:])))
    input_file.close()

    for i in range(0, 6):
        temp1 = tuple(host_cords1[i])
        temp2 = tuple(opp_cords1[i])
        host_cord[temp1] = i
        opp_cord[temp2] = i

    temp_switch_logic = 0
    count = 0
    count1 = 0
    upd = 0
    bot = 0
    while True:
        for event in pygame.event.get():
            if event.type == QUIT:
                exit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_RETURN:
                    return 0

        # FIELD STYLING
        screen.lock()

        rectangle_main_border = (field_x - 10, field_y - 10)
        rectangle_main_border_size = (field_length + 20, field_width + 20)

        rectangle_main = (field_x, field_y)
        rectangle_main_size = (field_length, field_width)

        screen.fill(screen_color)

        pygame.draw.rect(screen, field_border_color, Rect(rectangle_main_border, rectangle_main_border_size))
        pygame.draw.rect(screen, field_color, Rect(rectangle_main, rectangle_main_size))

        # center line vertical
        pygame.draw.line(screen, field_border_color, (center_x, field_y), (center_x, field_y + field_width), 1)

        # center circle
        pygame.draw.circle(screen, field_border_color, (center_x, 310), circle_radius, 1)
        #pygame.draw.circle(screen, field_border_color, (center_x+100, 400), circle_radius, 1)

        # center line horizontal
        # pygame.draw.line(screen, field_border_color, (field_x,center_y), (field_x + field_length, center_y),1)

        # LEFT Side

        # goalpost
        pygame.draw.line(screen, goal_post_color, (field_x - 20, center_y - (goal_post_length // 2)),
                         (field_x - 20, center_y + (goal_post_length // 2)), 19)
        # smallD
        pygame.draw.rect(screen, field_border_color,
                         Rect((field_x - 1, center_y - (circle_radius)), (width_small_d, 2 * circle_radius)), 1)
        # bigD
        pygame.draw.rect(screen, field_border_color, Rect((field_x - 1, center_y - ((5 / 8) * (field_width // 2))),
                                                          (width_big_d, (10 / 8) * (field_width // 2))), 1)

        # RIGHT side

        # goalpost
        pygame.draw.line(screen, goal_post_color, (field_x + field_length + 19, center_y - (goal_post_length // 2)),
                         (field_x + field_length + 19, center_y + (goal_post_length // 2)), 19)
        # smallD
        pygame.draw.rect(screen, field_border_color,
                         Rect((field_x + field_length - (width_small_d - 1), center_y - (circle_radius)),
                              (width_small_d, 2 * circle_radius)), 1)
        # bigD
        pygame.draw.rect(screen, field_border_color,
                         Rect((field_x + field_length - (width_big_d - 1), center_y - ((5 / 8) * (field_width // 2))),
                              (width_big_d, (10 / 8) * (field_width // 2))), 1)

        #player circle
        f=open('input.txt')
        lines=f.readlines()
        x_i=int(lines[p-1][1:5])
        y_i=int(lines[p-1][6:])
        x_1=int(lines[0][1:5])
        y_1=int(lines[0][6:])

        pygame.draw.circle(screen, field_border_color, (x_i,y_i), 40, 1)

        #player arc
        
        dis=2*mt.sqrt((x_1-x_i)**2+(y_1-y_i)**2)
        rectangle=(x_1,y_1,dis,80)
        print((x_1, y_1, dis, 80))
        rect_try = pygame.Rect(x_1, y_1, dis, 80)
        arc= pygame.draw.arc(screen,field_border_color,rectangle,(mt.pi)/2,3*(mt.pi)/2,1)
        #arc= pygame.draw.arc(screen,field_border_color,rectangle,(mt.pi)/2,3*(mt.pi)/2,1)
        screen2 = pygame.transform.rotate(screen, 45)
        newarc=screen2.get_rect(center=arc.center)
        #pygame.draw.rect(screen,field_border_color,newrect)
        #pygame.draw.rect(screen,field_border_color,rect_try)
        #sizee = newrect.size
        #rectangle = (1*newrect.centerx,1*newrect.centery,dis,80)
        #print(rectangle)
        newarc = pygame.draw.arc(newarc)
       

        
        
        

        screen.unlock()
        # SETUP FOR TEXT
        font = pygame.font.Font('freesansbold.ttf', 10)
        for event in pygame.event.get():
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_0:
                    bot = 0
                if event.key == pygame.K_1:
                    bot = 1
                if event.key == pygame.K_2:
                    bot = 2
                if event.key == pygame.K_3:
                    bot = 3
                if event.key == pygame.K_4:
                    bot = 4
                if event.key == pygame.K_5:
                    bot = 5
                if event.key == pygame.K_6:
                    bot = 6

        if bot and event.type == pygame.MOUSEBUTTONDOWN and event.button == 1:
            temp = pygame.mouse.get_pos()
            if temp not in host_cord.keys():
                for cord in host_cord.keys():
                    if host_cord[cord] == bot - 1:
                        temp2 = cord
                host_cord[pygame.mouse.get_pos()] = bot - 1
                del host_cord[temp2]
                upd = count

        if bot and event.type == pygame.MOUSEBUTTONDOWN and event.button == 3:
            temp = pygame.mouse.get_pos()
            if temp not in opp_cord.keys():
                for cord in opp_cord.keys():
                    if opp_cord[cord] == bot - 1:
                        temp2 = cord
                opp_cord[pygame.mouse.get_pos()] = bot - 1
                del opp_cord[temp2]
                upd = count

        if len(list(host_cord.keys())[:-1]) <= 6:
            for cord in host_cord.keys():
                temp = tuple(cord)
                pygame.draw.circle(screen, host_bot_color, temp, 10)

                text = font.render(str(host_cord[temp] + 1) + str(temp), True, (0, 0, 0))
                textRect = text.get_rect()
                textRect.center = temp
                screen.blit(text, textRect)

        if len(list(opp_cord.keys())) <= 6:
            for cord in opp_cord.keys():
                temp = tuple(cord)
                pygame.draw.circle(screen, opp_bot_color, temp, 10)
                text = font.render(str(opp_cord[temp] + 1) + str(temp), True, (0, 0, 0))
                textRect = text.get_rect()
                textRect.center = temp
                screen.blit(text, textRect)

        if len(host_cord) == 6 and len(opp_cord) == 6:
            if upd == count or count1 < 1:
                host_cord_list = [0 for i in range(6)]
                for i in host_cord.keys():
                    if host_cord[i] <= 5:
                        host_cord_list[host_cord[i]] = i
                file1 = open("input.txt", "w")
                text_to_write = ""
                for i in range(len(host_cord_list)):
                    text_to_write += str(i + 1) + " " + " ".join(list(map(str, host_cord_list[i]))) + "\n"

                opp_cord_list = [0 for i in range(6)]
                for i in opp_cord.keys():
                    if opp_cord[i] <= 5:
                        opp_cord_list[opp_cord[i]] = i

                for i in range(len(opp_cord_list)):
                    text_to_write += str(i + 11) + " " + " ".join(list(map(str, opp_cord_list[i]))) + "\n"

                file1.write(text_to_write)
                file1.close()
                rect_save = pygame.Rect(field_x, field_y, field_length, field_width)
                sub = screen.subsurface(rect_save)
                pygame.image.save(sub, "screenshot.jpg")
                count1 += 1
        count += 1
        pygame.display.update()