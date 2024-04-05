number = int(input("Type a number: "))

year = number // 365
weeks = (number - (year * 365)) // 7
days =  (number - (year * 365) - (weeks * 7))

print(year, weeks, days)

love = "I love python"
print(love[4])
print(love[-4])

sub_string_1 = love[0 : 4]
sub_string_2 = love[-4 : -1]

print(sub_string_1)
print(sub_string_2)
print(len(love))