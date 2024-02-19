#!/usr/bin/env python3


'''
FORMAT SPECIFICATION MINILANGUAGE  --- LOOK IT UP
'''

#format_spec ::= [[fill]align][sign][\#][0][width][grouping_option][.precision][type]
#fill ::= 
#align ::= "<" | ">" | "=" | "^"
#sign ::= "+" | "-" | " "
#width ::= digit+
#grouping_option ::= "_" | ","
#precision ::= digit+
#type ::= "b" | "c" | "d" | "e" | "E" | "f" | "F" | "g" | "G" | "n" | "o" | "s" | "x" | "X" | "%"
'''
x = 7 # 2 = 0010
y = 5 # 3 = 0011
x_bin = bin(x)
y_bin = bin(y)
z = 0


print(x_bin)
print(y_bin)
z = x & y; # 2 = 0010
print ("Line 1 - Value of z is ", z)
z_bin = bin(z)
print(z_bin)
 
z = x | y; # 3 = 0011
print ("Line 2 - Value of z is ", z)
z_bin = bin(z)
print(z_bin)

z = x ^ y; # 1 = 0001
print ("Line 3 - Value of z is ", z)
z_bin = bin(z)
print(z_bin)

z = ~x; # -3 =  1101
print ("Line 4 - Value of z is ", z)
z_bin = bin(z)
print(z_bin)

z = x << 1; # 4 = 0100
print ("Line 5 - Value of z is ", z)
z_bin = bin(z)
print(z_bin)

z = x >> 1; # 1 = 0001
print ("Line 6 - Value of z is ", z)
z_bin = bin(z)
print(z_bin)
'''

s = "racecar"
s_list = [*s]     #this is called unpacking and creates a list (array) out of the string
print(s_list)
s_list.reverse()            #this creates the reversed list (array)
s_rev = ''.join(s_list)    #this joins the list (array) into a string that starts off empty
print(s)
print(s_rev)
if s.lower() == s_rev.lower():
    print("found a palindrome")
else:
    print("not a palindrome")