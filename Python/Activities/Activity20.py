#import pandas 
import pandas 

#Read data from excel 
dataframe = pandas.read_excel('sample.xlsx')

#print the datframe
print("------------------------")
print("Number of rows and columns: ", dataframe.shape)

#Print the data from email column 
print("------------------------")
print("Emails: ")
print(dataframe['Email'])

#Sort data for first name in acsending order
print("------------------------")
print("Sorted Data: ")
print(dataframe.sort_values('FirstName'))