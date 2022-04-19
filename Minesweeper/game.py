from properties import *
from view import display_game

def play_game(field):
    while is_game_on(field):
        play_one_round(field)

def is_game_on(field):
    return not has_player_won(field) or has_player_lost(field)

def has_player_won(field):
    covered_or_flagged = 0
    mines = 0
    for value in field.values():
        if value[STATUS] == COVERED or value[STATUS] == FLAGGED:
            covered_or_flagged += 1
        if value[MINE]:
            mines += 1
    return covered_or_flagged == mines

def has_player_lost(field):
    for value in field.values():
        if value[STATUS] == UNCOVERED and value[MINE]:
            return True
    return False

def play_one_round(field):
    display_game(field) # temporarily completed
    user_input = get_user_input()
    apply_changes(user_input)

def get_user_input():
    pass

def apply_changes(user_input):
    pass