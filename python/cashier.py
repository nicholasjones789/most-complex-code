# Author: Nick Jones
# Email: jonesnt6@miamioh.edu
# Section: C
# Date: 2/26/2021
'''
Purpose: calculate the change given to the customer after they pay for their item
input: the price of the item as well as the amount given to cashier
output: the change given after the transaction
'''

#introduction
print("Change calculater")

#prompting user to enter price of item and money given
price = round(100 * float(input("Enter the price of the item bought: ")))
pay = round(100 * float(input("Enter the amount of money you give the cashier: ")))

#calculations
change = pay - price

#dollars
dollarCost = 100
numDollars = int(change / dollarCost)
change = change - (numDollars * dollarCost)

#quarters
quarterCost = 25
numQuarters = int(change / quarterCost)
change = change - (numQuarters * quarterCost)

#dimes
dimeCost = 10
numDimes = int(change / dimeCost)
change = change - (numDimes * dimeCost)

#nickels
nickelCost = 5
numNickels = int(change / nickelCost)
change = change - (numNickels * nickelCost)

#pennies
pennyCost = 1
numPennies = int(change / pennyCost)
change = change - (numPennies * pennyCost)

#final output
print("Your change:")
print("   dollars     ", numDollars)
print("   quarters    ", numQuarters)
print("   dimes       ", numDimes)
print("   nickels     ", numNickels)
print("   pennies     ", numPennies)
print("Thank you for your business")
