#function to calculate sum
def calSum(numbers):
    sum = 0 
    for number in numbers:
        sum+=number
    return sum

#Given list 
myList = [38,45,37,29]

#cal the num function
result = calSum(myList)

#Print result
print("The sum of all the elements is: " + str(result))