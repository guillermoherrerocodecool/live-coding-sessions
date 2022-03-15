import time
import os

def main():
    values = {
        "item" : "LAND",
        "gold" : 10000,
        "price" : generate_price(20, 40),
        "units" : 1000
    }
    values["gold"], values["units"] = buy(values["item"], values["gold"], values["price"], values["units"])
    print("gold", values["gold"], "land", values["units"])


def generate_price(start, end):
    return 23

def buy(item, gold, price, units):
  max_amount = int(gold / price)
  while True:
    display_status(item, gold, units, max_amount)
    amount = ask_user_for_amount_of(item, gold, units, max_amount)
    if amount == 0:
        return gold, units
    else:
        return process_transaction(amount, item, gold, price, units)
        

def display_status(item, gold, units, max_amount):
    os.system("clear")
    print("gold", gold, "land", units)
    print(f"\033[1;32m-BUY {item}-\033[0m")
    print(f"The max amount is {max_amount}.")


def ask_user_for_amount_of(item, gold, units, max_amount):
    while True:
        amount = input(f"How much {item} do you want to buy?")
        if not amount.isnumeric() or (amount.isnumeric() and int(amount) < 0):
            display_status(item, gold, units, max_amount)
            print("\033[1;31;48mInvalid input! \033[0m")
        elif int(amount) > max_amount:
            print("\033[1;31;48mYou don't have enough Money!\033[0m")
        else:
            return int(amount)


def process_transaction(amount, item, gold, price, units):
    costs = amount * price
    while True:
        confirm = input(f"Do you want to buy {amount} {item} for {costs} gold?[y/n]").upper()
        if confirm == "N":
            return gold, units
        if confirm == "Y":
            units += amount
            gold -= costs
            print("Thanks for your purchase!")
            time.sleep(1)
            return gold, units


if __name__ == "__main__":
    main()