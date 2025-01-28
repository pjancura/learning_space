def is_prime(n):
    """
    Check if a number is prime.
    """

    if n <= 1:
        return False
    
    for i in range(2, n // 2 + 1):
        if n % i == 0:
            return False
    return True

def print_prime_numbers(n):
    """
        Takes the number of prime numbers that you want to print as an argument
    """
    prime_list = []
    num = -1

    while len(prime_list) < n:
        num += 1
        if is_prime(num):
            prime_list.append(num)

    print(prime_list)


print_prime_numbers(10)
            