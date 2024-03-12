# i = 10

# for i in range(10):
#     pass
# print(i)

# a = "*****"
# a = a-a[2]
# print(a)

# x = "20"
# y = 3
# a = x * y
# print(a)

# def gen():
#     n = 1
#     print('This is the first statement')
#     yield n
#     n += 1
#     print('This is the second statement')
#     yield n
#     n += 1
#     print('This is the third statement')
#     yield n
# for i in gen():
#     print(type(i))
#     print(i)

# i = 10
# for i in range(10):
#     print(i)
# print(i)

# a = 1+2j
# print(a, "is a complex number?", isinstance(1+2j,complex))

# from math import pi as abc
# print (pi)

# double = lambda x: x * 2
# print(double(5))

# x = "20"
# y = "30"
# print(x>y)

# n = float(input("Enter the number: "))
# n_sqrt = n ** 0.5
# print('The square root of %0.3f is %0.3f'%(n, n_sqrt))

# list1 = [1,2,3]
# list2 = [4,5,6]
# list3 = list1 + list2
# print(list3)
# list4 = list3 * 3
# print(list4)

# def double(num):
#     """Function to double the value"""
#     return 2*num
# print(double.__doc__)

#print([(n1,n2) for n1 in ['a', 'b', 'c'] for n2 in ['c', 'b', 'd'] if n1==n2])

# for i in range(1,3):
#     print("*",end="")
# else:
#     print("*")

# print(.3423e2)
# print(3423e-2)

# st = [1,2,3,4]
# print(st)
# st = st[-3:-2]
# print(st)
# st = st[-1]

# print(st)

# s = 'abc'
# for i in range(len(s)):
#     s[i] = s[i].upper()
# print(s)

# list1 = [False for i in range(1,10)]
# print(list1)
# list2 = list1[-1:1:-1]
# print(list2)

def f(n):
    for i in range(1, n+1):
        yield I 
    return I

print(f(2))


# -*- coding: utf-8 -*-
# this file is released under public domain and you can use without limitations

# ----------------------------------------------------------------------------------------------------------------------
# this is the main application menu add/remove items as required
# ----------------------------------------------------------------------------------------------------------------------

response.menu = [
    (T('Home'), False, URL('default', 'index'), [])
]

# ----------------------------------------------------------------------------------------------------------------------
# provide shortcuts for development. you can remove everything below in production
# ----------------------------------------------------------------------------------------------------------------------
