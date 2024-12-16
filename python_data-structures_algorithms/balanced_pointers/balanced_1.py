def balancing(s: str, m: int) -> bool:
    if len(s) == 0:
        return False
    res = 0

    for c in s:
        if c == "<":
            res += 1
        elif c == ">":
            res -= 1
            if res < 0:
                if m > 0:
                    m -= 1
                    res += 1
                elif m <= 0:
                    break
        # print(res)

    # if m > 0 and res != 0:
    #     print("m > 0 and res != 0", s)
    #     while m != 0 or res != 0:
    #         if res > 0:
    #             m -= 1
    #             res -= 1
    #         else:
    #             m -= 1
    #             res += 1

    # print(res == 0)
    return (res - m) == 0


def balanced_or_not(arr: list[str], changes: int) -> list[int]:
    return [1 if balancing(a, m) else 0 for a, m in zip(arr, changes)]

if __name__ == "__main__":

    exp = ["<><>", "<<>>", "<>>", "<<><", "<>>", "<<><>>>>", "<<>", "<><>", "<>>>", ""]
    changes = [0, 0, 1, 2, 0, 1, 1, 0, 2, 0]

    # expected_outputs = [1, 1, 1, 1, 0, 0, 1, 1, 1, 0]
    print(balanced_or_not(exp, changes))
