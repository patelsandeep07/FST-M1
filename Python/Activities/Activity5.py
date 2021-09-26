while True:
    number = int(input("Input a number: "))
    for i in range(1,11):
        print(number, 'x' , i , '=' , number*i )
    repeat = input("Do you want to continue Yes/No: ").lower()

    if (repeat == "yes"):
        pass
    elif(repeat == "no"):
        raise SystemExit
    else:
        print("You have entered an invalid option, Exiting Now")
        raise SystemExit
        
