numList = []
while True:
    num = int(input("Enter the nuumber: "))
    numList.append(num)
    repeat = input("If you want to stop then press y or press any other key: ").lower()
    if (repeat=="y"):
        break
# printing input number list
print("Given list is: ", numList)

#converting into tuple
numTuple = tuple(numList)

#printing tuple 
print("Given tuple is: ",numTuple)

#Print the num that is divisible by 5
for num in numTuple:
    if(num%5 == 0):
        print("Number in tuple  divisible by 5 is: ", num)

    
