def fibonacci(number):
    if number <=1:
        return number
    else:
        return (fibonacci(number-1) + fibonacci(number-2))

reqSeqNum = int (input("Enter a number: "))

if reqSeqNum <=0:
    print("Please enter a positive number")
else:
    print("Fibonacci Sequence: ")
    for i in range(reqSeqNum):
        print(fibonacci(i))