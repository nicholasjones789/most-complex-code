# Author: Nick Jones
# Email: jonesnt6@miamioh.edu
# Section: C
# Date: 3/5/2021
'''
Purpose: do basic addition, subtraction, multiplication, and division with
two numbers
input: the two numbers they choose
output: the problem they chose as well as the answer
'''
#introduction
print("Select operation.")
print("      1.Add")
print("      2.Subtract")
print("      3.Multiply")
print("      4.Divide")
option = int(input("Enter your choice (1/2/3/4): "))

#declaration of numbers
first_num = int(input("Enter the first number: "))
second_num = int(input("Enter the second number: "))
add = first_num + second_num
subtract = first_num - second_num
multiply = first_num * second_num
divide = first_num / second_num

#if statements
if (option == 1):
    print(first_num, " + ", second_num, " = ", add)
if (option == 2):
    print(first_num, " - ", second_num, " = ", subtract)
if (option == 3):
    print(first_num, " * ", second_num, " = ", multiply)
if (option == 4):
    print(first_num, " / ", second_num, " = ", divide)








