import pygame
from pygame.locals import *
from sys import exit
from random import *
pygame.init()
screen = pygame.display.set_mode((640, 480), 0, 32)
 
while True:
    for event in pygame.event.get():
        if event.type == QUIT:
            exit()
    screen.lock()
    rectangle_pos = (150, 150)
    rectangle_pos2 = (250, 350)
    rectangle_size = (100, 100)
    screen.fill((255,255,255))
    pygame.draw.rect(screen, (100, 100, 150), Rect(rectangle_pos, rectangle_size), 3)
    pygame.draw.rect(screen, (100, 100, 150), Rect(rectangle_pos2, rectangle_size))
    screen.unlock()
    pygame.display.update()