def fizz_buzz(num):
    arr = []
    for i in range(1, num + 1):
        s = ""
        if i % 3 == 0:
            s += "fizz"
        if i % 5 == 0:
            s += "buzz"
        if i % 3 != 0 and i % 5 != 0:
            arr.append(i)
            continue
        arr.append(s)
    print(arr)

def is_prime(num):
    flag = False
    if num > 1:
    # if num % 2 == 0 and num != 2:
    #     return flag
        for i in range(2, num // 2 + 1):
            if num % i == 0:
                flag = False
                break
        else:
            flag = True
    
    return flag


def is_palindrome(s):
    flag = False
    if len(s) % 2 == 0:    
        front_half = s[: len(s) // 2]
        back_half = s[:len(s) // 2 - 1:-1]
    else:
        front_half = s[: len(s) // 2]
        back_half = s[:(len(s) // 2):-1]

    # print(front_half, back_half)
    if front_half == back_half:
        flag = True

    return flag

def print_fibonacci(num):
    sequence = [0, 1, 1]
    if num <= 3:
        print(sequence)
    for i in range(3, num):
        first = sequence[i - 2]
        second = sequence[i - 1]
        new_int = first + second
        sequence.append(new_int)
    print(sequence)

def print_prime_factors(num):
    if num < 2:
        print("Invalid Input")
        return
    prime_arr = []
    curr_int = 2
    while num != 1:
        if is_prime(curr_int):
            if num % curr_int == 0:
                prime_arr.append(curr_int)
                num /= curr_int
            else:
                curr_int += 1
        else:
            curr_int += 1
    print(prime_arr)

def print_prime_numbers(num):
    primes = []
    if num < 2:
        print("Invalid Input")
        return primes
    for i in range(2, num + 1):
        flag = True
        for j in range(2, i // 2 + 1):
            if i % j == 0:
                flag = False
                break
        if flag:
            primes.append(i)
    print(primes)

def recursive_factorial(n):
    print(n)
    return_value = 1 if n <= 1 else n * recursive_factorial(n-1)
    print(f"-> factorial({n}) returns {return_value}")
    return return_value

if __name__ == "__main__":
    fizz_buzz(30)
    check_prime = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 , 20]
    for i in check_prime:
        print(i, is_prime(i))
    
    poss_palindromes = ['fghgf', 'ff', 'af', 'tttyyyttt', 'racecar', 'todayyadot', 'birthhtib']
    for s in poss_palindromes:
        print(s, is_palindrome(s))

    print_fibonacci(10)

    print_prime_factors(62)
    print_prime_factors(20)
    print_prime_factors(100)

    print_prime_numbers(101)

    print(recursive_factorial(4))



