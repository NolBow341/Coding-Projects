"""Perform fixed-rate mortgage calculations."""

from argparse import ArgumentParser
import math
import sys

def get_min_payment(principal,an_interest_rate,term=30,payments=12):
    """gets minimum payment by using a formula

    Args:
        principal (float):  principal amount of mortgage
        an_interest_rate (float): annual interest rate
        term (int): term of mortgage in years. Defaults to 30.
        payments (int): number of payments per year. Defaults to 12.

    Returns:
        int: minimum mortgage payment
    """


    
    p = principal
    n = term * payments
    r = an_interest_rate / payments
    min_pay = p * (r * (1 + r) ** n) / ((1 + r)**n - 1)
    
    return math.ceil(min_pay)
    
def interest_due(balance,an_interest_rate,payments=12):
    """ Calculates amount of interest due 

    Args:
        balance (float): balance of mortgage 
        an_interest_rate (float): annual interest rate
        payments (int): amount of payments per year

    Returns:
        float: amount of interest due 
    """
    
    b = balance
    r = an_interest_rate / payments
    return b * r


def remaining_payments(balance,an_interest_rate,target_pay,payments=12):
    """_summary_

    Args:
        balance (float): balance of mortgage
        an_interest_rate (float): annual interest rate 
        target_pay (float): target payment amount
        payments (int): number of payments per year

    Returns:
        int: number of payments needed to pay mortgage
    """
    
    counter = 0
    
    while balance > 0:
        interest = interest_due(balance, an_interest_rate,payments)
        
        principal_bal = target_pay - interest
        
        balance -= principal_bal
        
        counter += 1
    return counter

def main(principal,an_interest_rate,term=30,payments=12,target_pay=None):
    """ Displays mortgage information

    Args:
        principal (float): principal amount of mortgage
        an_interest_rate (float): annual interest rate
        term (int): term of mortgage in years. Defaults to 30.
        payments (int): number of payments per year. Defaults to 12.
        target_pay (float): target payment amount.Defaults to None.
    """
    
    
    
    min_pay = get_min_payment(principal,an_interest_rate,term=30,payments=12)
    print(f"Minimum Mortgage Payment: ${min_pay}")
    
    if target_pay is None:
        target_pay = min_pay
    
    elif target_pay < min_pay:
        print("""Your target payment is less than the minimum""" 
              """payment for this mortgage""")
    else:
        total_pay = remaining_payments(principal,an_interest_rate,target_pay,payments=12)
        print(f"""if you make payments of ${target_pay},you will pay off the
               mortgage in {total_pay} payments.""")
        


def parse_args(arglist):
    """Parse and validate command-line arguments.
    
    This function expects the following required arguments, in this order:
    
        mortgage_amount (float): total amount of a mortgage
        annual_interest_rate (float): the annual interest rate as a value
            between 0 and 1 (e.g., 0.035 == 3.5%)
        
    This function also allows the following optional arguments:
    
        -y / --years (int): the term of the mortgage in years (default is 30)
        -n / --num_annual_payments (int): the number of annual payments
            (default is 12)
        -p / --target_payment (float): the amount the user wants to pay per
            payment (default is the minimum payment)
    
    Args:
        arglist (list of str): list of command-line arguments.
    
    Returns:
        namespace: the parsed arguments (see argparse documentation for
        more information)
    
    Raises:
        ValueError: encountered an invalid argument.
    """
    # set up argument parser
    parser = ArgumentParser()
    parser.add_argument("mortgage_amount", type=float,
                        help="the total amount of the mortgage")
    parser.add_argument("annual_interest_rate", type=float,
                        help="the annual interest rate, as a float"
                             " between 0 and 1")
    parser.add_argument("-y", "--years", type=int, default=30,
                        help="the term of the mortgage in years (default: 30)")
    parser.add_argument("-n", "--num_annual_payments", type=int, default=12,
                        help="the number of payments per year (default: 12)")
    parser.add_argument("-p", "--target_payment", type=float,
                        help="the amount you want to pay per payment"
                        " (default: the minimum payment)")
    # parse and validate arguments
    args = parser.parse_args()
    if args.mortgage_amount < 0:
        raise ValueError("mortgage amount must be positive")
    if not 0 <= args.annual_interest_rate <= 1:
        raise ValueError("annual interest rate must be between 0 and 1")
    if args.years < 1:
        raise ValueError("years must be positive")
    if args.num_annual_payments < 0:
        raise ValueError("number of payments per year must be positive")
    if args.target_payment and args.target_payment < 0:
        raise ValueError("target payment must be positive")
    
    return args


if __name__ == "__main__":
    try:
        args = parse_args(sys.argv[1:])
    except ValueError as e:
        sys.exit(str(e))
    main(args.mortgage_amount, args.annual_interest_rate, args.years,
         args.num_annual_payments, args.target_payment)
