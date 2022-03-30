while True:
  a = input("Provide a month (January, February, March, April, May, June, July, August, September, October, November, December): ")
  a = a.lower()
  if (
    a == "january" or a == "february" or a == "march" or a == "april"
    or a == "may" or a == "june" or a == "july" or a == "august"
    or a == "september" or a == "october" or a == "november" or a == "december"
  ):
    if a == "january":
      print("January has 31 days")
      print("It belongs to the first quarter of the year")
      break
    elif a == "february":
      print("February has 28 days")
      print("It belongs to the first quarter of the year")
      break
    elif a == "march":
      print("March has 31 days")
      print("It belongs to the first quarter of the year")
      break
    elif a == "april":
      print("April has 30 days")
      print("It belongs to the second quarter of the year")
      break
    elif a == "may":
      print("May has 31 days")
      print("It belongs to the second quarter of the year")
      break
    elif a == "june":
      print("June has 30 days")
      print("It belongs to the second quarter of the year")
      break
    elif a == "july":
      print("July has 31 days")
      print("It belongs to the third quarter of the year")
      break
    elif a == "august":
      print("August has 31 days")
      print("It belongs to the third quarter of the year")
      break
    elif a == "september":
      print("September has 30 days")
      print("It belongs to the third quarter of the year")
      break
    elif a == "october":
      print("October has 31 days")
      print("It belongs to the fourth quarter of the year")
      break
    elif a == "november":
      print("November has 30 days")
      print("It belongs to the fourth quarter of the year")
      break
    elif a == "december":
      print("December has 31 days")
      print("It belongs to the fourth quarter of the year")
      break
  else:
    print("Write a proper month (January, February, March, April, May, June, July, August, September, October, November, December)")