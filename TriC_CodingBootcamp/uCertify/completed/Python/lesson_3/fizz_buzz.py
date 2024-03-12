for i in range(1,101):
    if not i % 3 and not i % 5:
        print("FizzBuzz")
        #continue
    elif not i % 3:
        print("Fizz")
        #continue
    elif not i % 5:
        print("Buzz")
        #continue
    else:
        print(i)
        #continue