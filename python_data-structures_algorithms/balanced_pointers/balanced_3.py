def can_balance(s, fixes):
    if len(s) <= 0:
        return False
    
    pairs = {"<": ">", ">": "<"}

    stack = []

    for i in range(len(s)):
        if len(stack) < 1:
            stack.append(s[i])
        else:
            print(pairs[stack[len(stack) - 1]], s[i])
            if pairs[stack[len(stack) - 1]] == s[i]:
                stack.pop()
            else:
                stack.append(s[i])

    print(stack, fixes)
    if fixes >= len(stack):
        return True
    
    return False

def balanced_or_not(arr_s, arr_fixes):
    return [1 if can_balance(s, fixes) else 0 for s, fixes in zip(arr_s, arr_fixes)]


if __name__ == "__main__":

    exp = ["<><>", "<<>>", "<>>", "<<><", "<>>", "<<><>>>>", "<<>", "<><>", "<>>>", "", "<"]
    changes = [0, 0, 1, 2, 0, 1, 1, 0, 2, 0, 0]

    # expected_outputs = [1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0]
    print(balanced_or_not(exp, changes))