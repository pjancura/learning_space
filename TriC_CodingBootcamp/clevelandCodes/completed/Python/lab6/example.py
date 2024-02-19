import csv
from datetime import date,time,datetime

today = date.today()
starttime = datetime.now()
print(f"Starttime: {starttime:%X}")

line_count,males,females = 1,0,0

try:
    with open("MOCK_DATA.csv","r")as f:
        reader = csv.reader(f)
        for line in reader:
            #print(line)
            if line_count > 1:
                ind = line[0]
                fname = line[1]
                lname = line[2]
                email = line[3]
                gender = line[4]
                ip = line[5]
                #print(ip)
                if gender == "Male":
                    males +=1
                else:
                    females +=1
                #print(f"{ind},{fname},{lname},{email},{gender},{ip}")
        
            line_count+=1
        print("_______________")
        print("Males: ",males)
        print("Females: ",females)
        print("_______________")

        endtime = datetime.now()
        print(f"Endtime: {endtime:%X}")
except FileNotFoundError:
    print("couldn't find the file")


try:
    with open("result_count.txt","w") as f:
        print("write begins")
        f.write(f"There are {line_count} lines of data.\n There are {males} males in the data.\n There are {females} females in the data.")
except:
    print("Failure to write")
finally:
    print("write finished")

try:
    with open("result_count.txt","a") as f:
        print("append begins")
        f.write(f"There are {line_count} lines of data.\n There are {males} males in the data.\n There are {females} females in the data.\n")
except:
    print("Failure to append")
finally:
    print("append finished")
