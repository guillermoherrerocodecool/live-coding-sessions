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
    # 3. "uncertain", I think there could be a bomb here

# I win when:
    # all of the flags are placed over mine
    # all boxes have been "uncovered"

# MODES: easy, medium, hard
    # each mode, adds a random number of mine within a predefined range on a random spot of the field

# KEYWORDS: mine, field, uncover, flag, uncertain

# 8 x 8 fields: 10 mines
# 16 x 1fields: 40 mines
# 30 x 16 fields: 99mines
# custom