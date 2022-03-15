from modes import select_mode
from fields import generate_field
from game import play_game

def main():
    mode = select_mode() # done!
    field = generate_field(mode)
    play_game(field)
    
if __name__ == '__main__':
    main()