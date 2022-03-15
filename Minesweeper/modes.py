from tkinter.messagebox import Message
from view import display
from view import ask_for_user_input

EASY = "EASY"
MEDIUM = "MEDIUM"
HARD = "HARD"
CUSTOM = "CUSTOM"
MODES = (EASY, MEDIUM, HARD, CUSTOM)

def select_mode():
    while True:
        display("*** MODE SELECTION ***")
        display(prepare_modes_message())
        choice = ask_for_user_input("Select your game mode: ")
        if(is_valid(choice)):
            return process(choice)

def prepare_modes_message():
    capitalized = [mode.capitalize() for mode in MODES]
    modes = ", ".join(capitalized)
    return f"Available modes: {modes}"


def is_valid(choice):
    choice = choice.upper()
    return choice in MODES

def process(choice):
    return choice.upper()