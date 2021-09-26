#function to calculate sum
def calSum(num):
    if num:
        return num + calSum(num-1)
    else:
        return 0

#cal function 
sum = calSum(10)

#print result
print (sum)