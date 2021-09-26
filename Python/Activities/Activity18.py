#import pandas
import pandas

#read thee csv file 
dataframe = pandas.read_csv("sample.csv")

#Print data
print("Full Data: ")
print(dataframe)

#print the values in username column 
print("-------------------")
print("Usernames: ")
print(dataframe["Usernames"])

#print the username and password of 2nd row 
print("-------------------")
print("Username: ", dataframe["Usernames"][1], "|", "Password: ", dataframe["Passwords"][1])

#sort the username column in ascending order 
print("-------------------")
print("Data sorted in ascending order of Username: ")
print(dataframe.sort_values('Usernames'))

#sort the passowrds in descending order
print("-------------------")
print("Data sorted in descending order of Passwords: ")
print(dataframe.sort_values('Passwords',ascending=False))
