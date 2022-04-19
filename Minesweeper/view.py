from properties import STATUS


def display(message):
    print(message)

def ask_for_user_input(message):
    return input(message)

def display_game(field):
    print("THIS IS THE AWESOME FIELD")
    display_coordinate_x(field)
    for item in field.items():
        coordinate = item[0]
        values = item[1]
        if coordinate[1] == 0:
            #display_coordinate_y(coordinate) || postpone
            print()
        display_one_box(values)
    print()

def display_coordinate_x(field):
    coordinates = list(field.keys())
    last_coordinate = coordinates[-1]
    last_number = last_coordinate[0] + 1
    print("  ")
    for number in range(last_number): 
        print(f"{number} ", end="")

def display_coordinate_y(coordinate): 
    print(f"{coordinate[0]} ", end="")


def display_one_box(values):
    print(f"{values[STATUS]} ", end="")


field = {
    (0,0) : {"mine": False, "status": "uncovered"},
    (1,1) : {"mine": True, "status": "flagged"}
}