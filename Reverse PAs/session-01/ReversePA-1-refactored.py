import random

FILE_PATH = "Session-01/countries-and-capitals.txt"
INPUT_PROMPT = "\033[1;34;48m-WORDLISTS-\n\033[1;36;48m[co]COUNTRIES\n[ca]CAPITALS\n\033[1;34;48mMake your choice: "
INPUT_ERROR = "\033[1;31;48mYou have to choose between \"co\" and \"ca\" \033"
AVAILABLE_CHOICES = ["co", "ca"]

def get_mysterious_word():
    choice = get_user_input(AVAILABLE_CHOICES)
    mysterious_words = get_mysterious_words(FILE_PATH, choice)
    return random.choice(mysterious_words)


def get_user_input(available_choices):
    while True:
        choice = input(INPUT_PROMPT)
        if choice in available_choices:
            return choice
        print (INPUT_ERROR)


def get_mysterious_words(file_path, choice):
    with open(file_path) as file:
        lines = file.readlines()
        index = AVAILABLE_CHOICES.index(choice)
        mysterious_words = []
        for line in lines:
            mysterious_word = to_mysterious_word(line, index)
            mysterious_words.append(mysterious_word)
        return mysterious_words

def to_mysterious_word(line, index):
    mysterious_word = line.split('|')[index]
    return mysterious_word.strip()


result = get_mysterious_word()
print(result)