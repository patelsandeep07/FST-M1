import pytest

#create fixture
@pytest.fixture
def num_list():

    #Create list
    list = [0,1,2,3,4,5,6,7,8,9,10]

    return list

#write test method
def test_sum(num_list):

    #initialize sum
    sum = 0

    #Add number in the list
    for n in num_list:
        sum += n

    #Assertion
    assert sum == 55 