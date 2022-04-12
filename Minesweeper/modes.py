from view import display
from view import ask_for_user_input
from properties import MODES, GAME_MODES_HEADER, GAME_MODES_SELECTION, GAME_MODES_AVAILABLE

def select_mode():
    while True:
        display(GAME_MODES_HEADER)
        display(prepare_modes_message())
        choice = ask_for_user_input(GAME_MODES_SELECTION)
        if(is_valid(choice)):
            return process(choice)

def prepare_modes_message():
    capitalized = [mode.capitalize() for mode in MODES]
    modes = ", ".join(capitalized)
    return f"{GAME_MODES_AVAILABLE} {modes}"


def is_valid(choice):
    choice = choice.upper()
    return choice in MODES

def process(choice):
    return choice.upper()