def can_balance(s: str, m: int) -> bool:
    if len(s) <= 0:
        return False
    
    counter = 0

    for c in s:
        if c == "<":
            counter += 1
        if c == ">":
            counter -= 1
            if counter < 0:
                if m > 0:
                    m -= 1
                    counter += 1
                elif m <= 0:
                    break
    
    if m > 0 and counter != 0:
        return (counter - m) == 0
    
    return counter == 0

def balanced_or_not(arr: list[str], changes: list[int]) -> list[int]:
    return [1 if can_balance(a, c) else 0 for a, c in zip(arr, changes)]


if __name__ == "__main__":

    exp = ["<><>", "<<>>", "<>>", "<<><", "<>>", "<<><>>>>", "<<>", "<><>", "<>>>", ""]
    changes = [0, 0, 1, 2, 0, 1, 1, 0, 2, 0]

    # expected_outputs = [1, 1, 1, 1, 0, 0, 1, 1, 1, 0]
    print(balanced_or_not(exp, changes))