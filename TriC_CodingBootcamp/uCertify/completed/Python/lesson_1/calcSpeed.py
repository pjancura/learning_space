# original units
km = 150
hrs = 2

# modified units
miles = km / 1.6
meters = km * 1000
secs = hrs * 3600

print("---------------------------------")
print("Distance in miles: " + str(miles))
print("Distance in meters: " + str(meters))
print("km/hr: " + str(km / hrs))
print("miles/hr: " + str(miles / hrs))
print("m/sec: " + str(meters / secs))
print("---------------------------------") 