import time
import os

def buy(name, gold, price, holding):
  MAX_AMMOUNT = int(gold / price)
  name = name.upper()
  low_money = False
  invalid_input = False
  while True:
    os.system("clear")
    print("gold",gold,"land",land) 
    if low_money == True:
      print("\033[1;31;48mYou don't have enough Money!\033[0m")
    low_money = False
    if invalid_input == True:
      print("\033[1;31;48mInvalid input! \033[0m")
    invalid_input = False
    print(f"\033[1;32m-BUY {name}-\033[0m")
    print(f"The max ammount is {MAX_AMMOUNT}.")
    ammount = input(f"How much {name} do you want to buy?")
    if ammount.isnumeric():
      ammount = int(ammount)
      if ammount <= MAX_AMMOUNT:
        costs = ammount * price
        while True:
          confirm = input(f"Do you want to buy {ammount} {name} for {costs} gold?[y/n]").upper()
          if confirm == "Y":
            holding += ammount
            new_gold = gold - costs
            gold = new_gold
            print("Thanks for your purchase!")
            break
          elif confirm == "N":
            return
        time.sleep(1)
        return gold, holding
      else:
        low_money = True
    else:
      if ammount == "q":
        break
      else:
        invalid_input = True


if __name__ == "__main__":
  land = 1000
  gold = 10000
  price = 23 #random between 20 and 40 
  gold, land = buy("land", gold, price, land)
  print("gold",gold,"land",land) 