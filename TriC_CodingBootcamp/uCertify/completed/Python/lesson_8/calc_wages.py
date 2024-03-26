import csv

output_data = []

with open('input.csv','w') as f:
   fields = ['name','hours_worked']
   output_writer = csv.DictWriter(f, fieldnames=fields)
   output_writer.writeheader()
   output_writer.writerow(
      {
      'name': 'James Miller',
      'hours_worked': 36
      })
   output_writer.writerow(
      {
        'name':'Teresia Brown',
       'hours_worked':41
      })
   output_writer.writerow(
      {
       'name':'Mary Lane',
        'hours_worked':40
      }   
      )


with open('input.csv', 'r') as f:
    mock_data_reader = csv.reader(f)
    #output_data = []
    line_count = 1
    for row in mock_data_reader:   #each row of the csv is read as a list
      print(row)
      if line_count != 1:
        print("This is an even numbered row?",row)
        row[1] = int(row[1]) * 15         #this is getting the 2nd item in each list, which is the hour_worked column
        print(row[1])
        output_data.append(row)
      line_count += 1

print(output_data)

with open('output.csv', 'w') as f:
    fields = ['name', 'wages']
    output_writer = csv.DictWriter(f, fieldnames=fields)

    output_writer.writeheader()

    for line in output_data:
      output_writer.writerow(
        {
          'name': line[0],
          'wages': line[1]
        }
      )