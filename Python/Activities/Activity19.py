#import pandas 
import pandas
from pandas import ExcelWriter

#Create a dictionary to create the dataframe 
data = {
	'FirstName':["Satvik", "Avinash", "Lahri"],
	'LastName':["Shah", "Kati", "Rath"],
	'Email':["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
	'PhoneNumber':["4537829158", "4892184058", "4528727830"]
}

#create the dataframe
dataframe = pandas.DataFrame(data)

#print the dataframe
print(dataframe)

#wirte the datframe to excel
writer = ExcelWriter('sample.xlsx')
dataframe.to_excel(writer,'Sheet1',index=False)

#commit data to excel file
writer.save()

