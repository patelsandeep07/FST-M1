# import pandas
import pandas

#Create a dictionary to hold data
data = {
  "Usernames": ["Admin", "Charles", "Deku"],
  "Passwords": ["Password", "Charl13", "AllMight"]
}

#create dataframe
dataframe = pandas.DataFrame(data)

#print dataframe 
print(dataframe)

#Write dataframe to csv file 
dataframe.to_csv("sample.csv",index=False)

