def longest_palindrome_substring(string):

    modified_string = "#".join(f"^{string}$")
    # print(modified_string)
    n = len(modified_string)
    P = [0] * n
    C = 0
    R = 0

    for i in range(1, n - 1):
        print(f"i {i}  R {R}  P[i] {P[i]} C {C}")
        if i < R:
            P[i] = min(R - i, P[2 * C - i])
            print(f"i {i}  R {R}  P[i] {P[i]}")
            print(P)

        while modified_string[i - 1 - P[i]] == modified_string[i + 1 + P[i]]:
            P[i] += 1

        # print(f"i {i} P[i] {P[i]} i + P[i]: {i + P[i]} C: {C} R: {R}")
        if i + P[i] > R:
            C = i
            R = i + P[i]
            # print(f" i + P[i]: {i + P[i]} C: {C} R: {R}")
    # print(P)
    max_len, center_index = max((value, index) for index, value in enumerate(P))

    return string[(center_index - max_len) // 2 : (center_index + max_len) // 2], max_len


if __name__ == "__main__":
    s_arr = [
        "a",                # "a", 1
        "racecars",          # "racecar", 7
        "babad",            # "aba", 3
        "abcd",             # "d", 0
        "abccba",           # "abccba", 6
        "",                 # "", 0
        "a!b!a"             # "a!b!a", 5
    ]

    for s in s_arr:
        print(longest_palindrome_substring(s))