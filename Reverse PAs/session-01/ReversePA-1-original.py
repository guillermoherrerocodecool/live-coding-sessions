import random

def get_random_countries():
  lines = []
  f = open("Session-01/countries-and-capitals.txt")
  lines = f.readlines()
  valid_input = False
  while valid_input == False:
    chocaco = input("\033[1;34;48m-WORDLISTS-\n\033[1;36;48m[co]COUNTRIES\n[ca]CAPITALS\n\033[1;34;48mMake your choice: ")
    countries = []
    capitals = []
    if chocaco == "co":
      for country in lines:
        countries.append(country.split('|')[0].strip())
      return random.choice(countries)
    elif chocaco == "ca":
      for capital in lines:  
        capitals.append(capital.split('|')[-1].strip())
      return random.choice(capitals)
    else:
      print ("\033[1;31;48mYou have to choose between \"co\" and \"ca\" \033")


result = get_random_countries()
print(result)