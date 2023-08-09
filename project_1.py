# Project 1 Tuition Calculator 
# Nolan Bowen

#  used to display prompt to user

def ask_yn(prompt):
    while True:
     response = input(prompt).lower()
     if response in ["y","n"]:
         return response == "y"
     else: print("Please respond 'y' or 'n'.")
         
      
# determines whether or not the user needs to pay differential tuition

def get_differential_tuition():
   if ask_yn("Are you majoring in business,engineering, or computer science? "):
       return ask_yn("Are you a junior or senior? ")
   else:
       return False
    
# Calculates the students regular tuition

def calculate_tuition(resident,credits):
    if resident:
        if int(credits) >= 12:
            return 4944.50
        else:
            return 412.00 * credits
    else:
        if int(credits) >= 12:
            return 19345.00
        else:
                return 1613.00 * credits 
        
# Calculates differential tuition based on requirements

def calculate_dt(diff_tuition,credits):
    if diff_tuition:
        if int(credits) >= 12:
            return 1515.00
        elif int(credits) < 12:
            return (124.50) * credits
    else:
        return 0.00
# Calculates student fees

def calculate_fees(credits):
    if int(credits) >= 9:
        return 808.00
    else:
        return 371.00
    
# Prints the recipt containing tuition prices and added fees

def print_receipt(tuition, d_tuition, fees):
    total = tuition + d_tuition + fees
    print(f"Here are your estimated tuition and fees for fall semester: ")
    print(f"Tuition: ${tuition}")
    print(f"Differential tuition: ${d_tuition}")
    print(f"Fees: ${fees}")
    print(f"Total: ${total}")
    
# Main 
 
def main():
    resident = ask_yn("Are you a Maryland resident?(y/n) ")
    credits = int(input("How many credits are you planning to take? "))
    dif_tuition = get_differential_tuition()
    reg_tuition = calculate_tuition(resident,credits)
    dt = calculate_dt(dif_tuition,credits)
    fees = calculate_fees(credits)
    print_receipt(reg_tuition,dt,fees)
    
if __name__ == "__main__":
    main()