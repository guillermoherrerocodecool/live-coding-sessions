def shot_to_coordinates(shot): #takes string 'shot' (letter, number) like 'A1' and returns the coordinates as tuple of integers like (0, 0)
    number = int(shot[1])
    row = number - 1
    if shot[0] == "A":
        line = 0
    elif shot[0] == "B":
        line = 1
    elif shot[0] == "C":
        line = 2
    elif shot[0] == "D":
        line = 3
    elif shot[0] == "E":
        line = 4
    coordinates = line, row
    return coordinates

shot = "C2"
coordinates = shot_to_coordinates(shot)
print(f"The coordinates for {shot} are {coordinates}")