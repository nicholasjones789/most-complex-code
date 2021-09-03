# Author: Nick Jones
# Email: jonesnt6@miamioh.edu
# Section: C
# Date: 3/14/2021
'''
Purpose: calculate the price of a ticket based on age
input: the age of person buying ticket
output: the price of the ticket
'''
#initialization
age = int(input("Enter your age: "))

#if statement scenarios 
if (age <= 50 and age >= 20):
    print("Ticket price is $20")
elif ((age < 20 and age >= 10) or age > 50):
    print("Ticket price is $12")
if (age < 10):
    print("You're not eligible to buy a ticket.")
