import csv
with open('MOCK_DATA.csv', 'r') as f:
    mock_data_reader = csv.reader(f)

    line_count = 1 

    for row in mock_data_reader: 

        if line_count > 1: # skipping line 1 which is the header row 
            print(row) 
    
        line_count += 1

print()

with open('example.csv', 'w') as f:
    example_data_writer = csv.writer(f)

    example_data_writer.writerow(['name', 'age'])
    example_data_writer.writerow(['Steven', 25])

with open('example.csv','r') as f:
    data = csv.reader(f)
    for row in data:
        print(row)



with open('people.csv', 'w') as f:
    fields = ['name', 'age']
    people_writer = csv.DictWriter(f, fieldnames=fields)

    people_writer.writeheader() # writes the fields as the first row
    people_writer.writerow({'name': 'Santa Claus', 'age': 1000})

print()

with open('people.csv','r') as f:
    data = csv.reader(f)
    for row in data:
        print(row)