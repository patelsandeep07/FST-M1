# User name
user1 = input("What is player1 name? ")
user2 = input("What is Player2 name? ")
while True:
# Get the user choices
    user1_answer = input(user1 + ", choose Rock,Paper or Scissors? ").lower()
    user2_answer = input(user2 + ", choose Rock,Paper or Scissors? ").lower()

    if user1_answer == user2_answer:
        print("It's a tie!")
    elif user1_answer == 'rock':
        if user2_answer == 'scissors':
            print("Rock Wins!")
        else:
            print("Paper Wins!")
    elif user1_answer == 'paper':
        if user2_answer == "rock":
            print("Paper Win!")
        else:
            print("Scissors win!")
    elif user1_answer == 'scissors':
        if user2_answer == "paper":
            print("Scissor Win!")
        else:
            print("Rock win!")
    else:
        print("Invalid input! you have not entered rock, paper or scissors, try again.")

# user input to play again
    repeat = input("Do you want to play again Yes/No: ").lower()

    if (repeat == "yes"):
        pass
    elif(repeat == "no"):
        raise SystemExit
    else:
        print("You entered an invalid option. Exiting Now")
        raise SystemExit