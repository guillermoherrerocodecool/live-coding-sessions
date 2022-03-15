def alter(letters):
    letters.append("a")
    print(f"letters inside the function: {letters}")

letters = ["a"]
alter(letters)
print(f"letters outside the function {letters}")
# string, integer, float, bool