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


# STYLING
screen_color = (0,0,0)
field_color = (4,204,130)
field_border_color = (255,255,255)


while True:
    for event in pygame.event.get():
        if event.type == QUIT:
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
    pygame.draw.circle(screen, field_border_color, (center_x,310), 50,1)

    # center line horizontal
    pygame.draw.line(screen, field_border_color, (field_x,center_y), (field_x + field_length, center_y),1)


    screen.unlock()

    pygame.display.update()

pygame.quit()
quit()
