import csv
from datetime import date,time,datetime

today = date.today()
starttime = datetime.now()

print()
print()
print("_________Start_________")
print(f"DATE: {starttime:%x}")
print(f"Starttime: {starttime:%X}")


output_data = []
line_count = 1
total_payroll_amount = 0

try:
    with open("timesheet.csv","r") as f:
        reader = csv.reader(f)
        for row in reader:   #each row of the csv is read as a list
            #print(row)
            if line_count != 1:
                row[3] = round(float(row[3]) * float(row[4]),2)        #this is getting the 2nd item in each list, which is the hour_worked column
                #print(row[3])
                row.pop()
                output_data.append(row)
            # if line_count == 25:
            #     break
            line_count += 1
        #print(output_data)

except:
    print("unable to process")
else:
    print("done with reading data")


try:
    with open("wages_earned.csv","w") as f:
        fields = ["id",'first_name','last_name','wages']
        output_writer = csv.DictWriter(f, fieldnames=fields)
        output_writer.writeheader()
        for line in output_data:
            output_writer.writerow(
                {
                'id': line[0], 
                'first_name': line[1],
                'last_name': line[2],
                'wages': line[3]
                }
            )
except:
    print("didn't calc the wages for people")
else:
    print("done with writing") 


try:
    with open("wages_earned.csv","r") as f:
        reader = csv.reader(f)
        #for row in reader:
            #print(row)
except:
    print("unable to read wages_earned.csv")
else:
    print("done reading wages_earned.csv")

for i in output_data:
    total_payroll_amount += i[3]

endtime = datetime.now()

try:
    with open("payroll_summary.txt","w") as f:
        f.write(f"DATE: {starttime:%x}\n")
        f.write("______Totals_________\n")
        f.write(f"Lines input: {line_count}\n")
        f.write(f"Total Payroll Amount: {round(total_payroll_amount,2)}\n")
        f.write("\n")
        f.write(f"Starttime: {starttime:%X}\n")
        f.write(f"Endtime: {endtime:%X}\n")
except:
    print("failure to ouput payroll_summary.txt")
else:
    print(f"payroll_summary successfully output")






print("______Totals_________")
print(f"Lines input: {line_count}")
print(f"Total Payroll Amount: {round(total_payroll_amount,2)}")
print("__________fin___________")
print(f"Endtime: {endtime:%X}")
print()
print()

    
