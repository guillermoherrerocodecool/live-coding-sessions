def difficulty_level(a):
    print(a)
    hidden_guess = a
    for i in hidden_guess:
        if i != " " and i != "-":
            hidden_guess = hidden_guess.replace(i,"_ ")   
    print(hidden_guess)

word = "Reverse PA"
difficulty_level(word)

def easy(word_to_guess1):
    print("Guess a letter: ")
    difficulty_level(word_to_guess1)
    hidden_guess = word_to_guess1
    invalid_letter_input = True
    used_letter = []
    while invalid_letter_input:
        
        letter = input("Your letter:").upper()
        if letter.isalpha() == False or len(letter) != 1:
            invalid_letter_input == True
            print()
            print("Please try to type a single letter!")
            
        
        else: # user provides a valid
            invalid_letter_input = False
            
            
            for i in word_to_guess1:
                if letter == i:
                    hidden_guess = hidden_guess.replace(i,letter)
                print(hidden_guess)
            
                if letter != i:
                #d1_lives = d1_lives - 1
                    
                    print(f"The letter {letter} is not in your word.")
                
                    used_letter = used_letter.append(letter)

            
                if letter not in word_to_guess1 and letter in used_letter:
                    invalid_letter_input == False
                    print("You already used this letter. Try again!")

easy(word)