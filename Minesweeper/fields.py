from properties import *
import random

field_parameters = {EASY: (8, 8, 10), MEDIUM : (16, 16, 40), HARD : (30, 16, 99)}

def generate_field(mode):
    parameters = field_parameters[mode]
    field = generate_empty_field(parameters)
    add_mines(field, parameters)

def generate_empty_field(parameters):
    field = {}
    for width in range(parameters[INDEX_WIDTH]):
        for height in range(parameters[INDEX_HEIGHT]):
            field[(width,height)] = {MINE : False, STATUS: COVERED}
    return field
    
def add_mines(field, parameters):
    width = parameters[INDEX_WIDTH]
    height = parameters[INDEX_HEIGHT]
    mines = parameters[INDEX_MINES]
    while mines > 0:
        coordinate = pick_random_coordinate(width, height)
        if(has_no_mine(field, coordinate)):
            field[coordinate][MINE] = True
            mines -= 1

def pick_random_coordinate(width, height):
    coordinate_width = random.randrange(0, width)
    coordinate_height = random.randrange(0, height)
    return (coordinate_width, coordinate_height)

def has_no_mine(field, coordinate):
    return not field[coordinate][MINE]