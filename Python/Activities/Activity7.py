numList = []
while True:
    num = int(input("Enter the nuumber: "))
    numList.append(num)
    repeat = input("If you want to stop then press y or press any other key: ").lower()
    if (repeat=="y"):
        break
# printing input number list
print(numList)

#logic for adding each number in list
sum = 0
for number in numList:
    sum+=number

print(sum)
