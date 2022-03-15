def print_obscured(word):
    print(word)
    for letter in word:
        if letter != " " and letter != "-":
            word = word.replace(letter, "_ ")   
    print(word)

def play_one_round(word, correct_letters, incorrect_letters):
    show_one_round_header(word)
    letter = ask_user_for_letter()
    apply_logic(word, letter, correct_letters, incorrect_letters)

def show_one_round_header(word):
    print("Guess a letter: ")
    print_obscured(word)

def ask_user_for_letter():
    while True: 
        letter = input("Your letter: ").upper()
        if letter.isalpha() == False or len(letter) != 1:
            print("\nPlease try to type a single letter!")
        else:
            return letter

def apply_logic(word, letter, correct_letters, incorrect_letters):
    if letter in word:    
            correct_letters.add(letter)
    else:
        if letter in correct_letters or letter in incorrect_letters:
            print("You already used this letter. Try again!")
        else:
            print(f"The letter {letter} is not in your word.")
            incorrect_letters.add(letter)

original = "Reverse PA".upper()
correct_tries = set("E")
incorrect_tries = set("T")
play_one_round(original, correct_tries, incorrect_tries)