#takes string 'shot' (letter, number) like 'A1' and returns the coordinates as tuple of integers like (0, 0)
def translate_to_coordinates(shot):
    line = get_line(shot)
    row = get_row(shot)
    coordinates = line, row
    return coordinates
    
def get_line(shot):
    lines = {"A":0, "B":1, "C":2, "D":3, "E":4}
    #lines = ["A", "B", "C", "D", "E"] # Big O (complexity estimation) O(n)
    letter = shot[0]
    line = lines[letter]
    return line

def get_row(shot):
    number = int(shot[1])
    return number - 1

shot = "A1"
coordinates = translate_to_coordinates(shot)
print(f"The coordinates for {shot} are {coordinates}")