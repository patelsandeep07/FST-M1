fruit_shop = {
    "guava" : 50,
    "apple" : 100,
    "orange" : 40,
    "banana" : 30
}

userInput = input("Hello, What are you lokking for?").lower()

if (userInput in fruit_shop):
    print("Yes, fruit is available")
else:
    print("No, this is not available")

