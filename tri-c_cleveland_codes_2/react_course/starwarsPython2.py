import requests
import csv

url = "https://swapi.dev/api/planets/"

response = requests.get(url)
ct = 0
if response.status_code == 200:
    data = response.json()
    with open("swplanets.csv", "w", newline="") as fp_out:
        writer = csv.writer(fp_out)      
        for planet in data["results"]:
            name = planet["name"]
            diameter = planet["diameter"]
            climate = planet["climate"]
            population = planet["population"]
            print(f"Name: {name}")
            print(f"Diameter: {diameter}")
            print(f"Climate: {climate}")
            print(f"Population: {population}")
            print("\n")
            writer.writerow([name, diameter, climate, population])
            ct = ct + 1
    fp_out.close()
    print("CVS file is swplanets.csv")
    print(f"Count: {ct}")
else:
    print("Failed to retrieve data.")
