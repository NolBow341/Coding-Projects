# Project 2
# Nolan Bowen
import os

def clear_screen():
    """ Clear the screen."""
    os.system('cls' if os.name == 'nt'
              else 'clear')
    
def read_catalog(filepath):
    catalog = {}
    file = open(filepath, "r", encoding = "UTF-8")
    for line in file:
        (i_d, description, price) = line.split(",")
        catalog[i_d] = (description, float(price))
    file.close()
    return catalog
def print_dictionary(catalog):
    for i_d,value in catalog.items():
        print(i_d, "-",value)
    
def get_user_choice(catalog, response):
    clear_screen()
    while True:
        print("Choose what to do next: ")
        print()
        print_dictionary(catalog)
        print()
        response = input("Your choice:")
        if response in catalog:
            return response
        else:
            print("Sorry,that's not one of the options")
            
def get_quantity():
    while True:
        quantity = input("How many would you like to buy? ")
        try:
            quantity = int(quantity)
            return quantity
        except ValueError:
            print("Please enter a whole number")

def human_readable_cart(catalog,shopping_cart):
    readable_cart = {}
    for i_d, quantity in shopping_cart.items():
        print(catalog)
        item = catalog[i_d]
        description = item[0]
        price = item[1]
        subtotal = price*quantity
        human_readable = (f"{description}({quantity}@ ${price} = ${subtotal}")
        readable_cart[i_d] = human_readable
        return readable_cart
    
def add_item_to_cart(catalog, shopping_cart):
    item = get_user_choice(catalog, "Select a product to purchase:")
    quantity = get_quantity()
    if quantity > 0:
        if item in shopping_cart:
            shopping_cart[item] += quantity
        else:
            shopping_cart[item] = quantity
            
def change_quantity(catalog, shopping_cart):
    if not shopping_cart:
        print('Your cart is currently empty')
        input("Press Enter to continue.")
    else:
        cart = human_readable_cart(catalog,shopping_cart)
        item = get_user_choice(cart, "Select the product whose quantity you want to change:")
        quantity = get_quantity()
        if quantity > 0:
            shopping_cart[item] = quantity
        else:
            del shopping_cart[item]

def get_total(catalog, shopping_cart):
    total = 0
    for item, quantity in shopping_cart.items():
        total += catalog[item][1]* quantity
        return total
    
def print_cart(catalog, shopping_cart):
    clear_screen()
    if shopping_cart:
        cart = human_readable_cart(catalog,shopping_cart)
        print_dictionary(cart)
        total = get_total(catalog,shopping_cart)
        print(f"Total: ${total}")
    else:
        print("Your cart is currently empty.")
        
def view_cart(catalog, shopping_cart):
    print_cart(catalog,shopping_cart)
    print()
    response = input("Press Enter to continue.")
    
def check_out(catalog,shopping_cart):
    print_cart(catalog,shopping_cart)
    print()
    print("Have a nice day!")
    
def menu(catalog):
    shopping_cart = {}
    options = {"a": "Add an item to your cart",
               "q": "Change the quantity of an item in your cart",
               "v": "View your cart",
               "c": "Check out"
               }
    while True:
        choice = get_user_choice(options, "Select an action:")
        if choice == "a":
            add_item_to_cart(catalog,shopping_cart)
        elif choice == "q":
            change_quantity(catalog,shopping_cart)
        elif choice == "v":
            view_cart(catalog,shopping_cart)
        elif choice == "c":
            check_out(catalog,shopping_cart)
            return
        
def main(filepath):
    catalog = read_catalog(filepath)
    menu(catalog)
    
    

if __name__ == "__main__":
     main("catalog.csv")