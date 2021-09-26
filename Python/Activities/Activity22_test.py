import pytest

#addition test
def test_addition():

    #initialize two number
    num1 = 10
    num2 = 15

    #Add them
    sum = num1 + num2

    #Assertion
    assert sum == 25

#Substation test
def test_substartion():

    #Initialize 2 numbers
    num1 = 50
    num2 = 35

    #Substact them 
    sub = num1 - num2 

    #Assertion
    assert sub == 15

#Multiplication test 
@pytest.mark.activity
def test_multiplication():

    #initialize 2 numbers 
    num1 = 20
    num2 = 5

    #Multiply them 
    multi = num1 * num2

    #Assertion 
    assert multi == 100

#Divison test 
@pytest.mark.activity
def test_divison():

    #initialize 2 numbers 
    num1 = 100
    num2 = 5

    #Division them 
    div = num1 / num2

    #Assertion 
    assert div == 20
