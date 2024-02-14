def balance(s, m) -> int:
    c = 0
    for val in s:
        if val == "<":
            c += 1
        elif val == ">":
            c -= 1
            if c < 0:
                if m > 0:
                    m -= 1
                    c += 1
                elif m <= 0:
                    break
    return c

def balancedOrNot(exp, changes):
    arr = []
    for e, m in zip(exp, changes):
        if balance(e,m) == 0:
            arr.append(1)
        else:
            arr.append(0)
    return arr

s_arr = ["<>", "<><><<<>>><><", "", ">>"]
subs_arr = [0, 1, 1, 3]
print(balancedOrNot(s_arr, subs_arr))
