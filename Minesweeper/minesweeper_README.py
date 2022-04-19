# happens within one map
# just one player
# mines are randomly located on the map
    # hidden from the player
    # 'click' on the field, a box is uncovered and a number is shown
    # the number represents how many adjecent mines are around that box
# mines need to be uncovered (setting a flag)
# the user has three options:
    # 1. "uncover" one box (if there is a bomb, it explodes, YOU DIE)
    # 2. "plant flag" over one box (i suspect there is a bomb, and if i accidencally "uncover" that box, it doesn't work)
    # ????3. "uncertain", I think there could be a bomb here

# I win when:
    # all of the flags are placed over mine
    # all boxes have been "uncovered"

# MODES: easy, medium, hard
    # each mode, adds a random number of mine within a predefined range on a random spot of the field

# KEYWORDS: mine, field, uncover, flag, uncertain

# 8 x 8 fields: 10 mines
# 16 x 16 fields: 40 mines
# 30 x 16 fields: 99 mines
# custom

# GAME LOGIC:

# game loop (the game ends when the player wins or loses)
    # win: when all boxes are uncovered, except the mines 
        # alternative win: all mines have a flag on top, no need to uncover all the rest
    # lose: when a mine is uncovered
# game loop step:
    # display the current state of the field
    # receive user input (move, coordinate)
    # apply changes
    # repeat