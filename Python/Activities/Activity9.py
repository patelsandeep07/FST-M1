#Given ist
listOne = [12,45,34,56,34]
listTwo = [14,53,54,43,76]

#Print the list 
print("first list is: ", listOne)
print("second list is: ", listTwo)

#New list
listThree = []

#odd number from list1
for num in listOne:
    if(num%2 != 0 ):
       listThree.append(num)

#even number from list2
for num in listTwo:
    if(num%2 == 0 ):
       listThree.append(num)

print("Third list is: ", listThree)
