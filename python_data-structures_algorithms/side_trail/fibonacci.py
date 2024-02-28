def allFib(n):
    memo_1 = [0] * n
    for i in range(0, n):
        print(str(i + 1) + ": " + str(fib(i, memo_1)))
        print("In Loop: " + str(memo_1))

def fib(n, memo):
    print(str(memo))
    if n <= 0:
        memo[n] = 0
        return 0
    elif n == 1:
        memo[n] = 1
        return 1
    elif memo[n] > 0:
        return memo[n]
    digit_1 = fib(n - 1, memo)
    digit_2 = fib(n - 2, memo)
    memo[n] = digit_1 + digit_2
    return memo[n]



if __name__ == "__main__":
    print("memo" in globals())
    allFib(10)