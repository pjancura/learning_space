def longest_palindrome_substring(string):
    mod_str = "#".join(f"^{string}$")
    len_mod = len(mod_str)
    P = [0] * len_mod
    C = 0
    R = 0

    for i in range(1, len_mod - 1):
        if i < R:
            P[i] = min(R - i, P[2 * C - i])

        while mod_str[i - 1 - P[i]] == mod_str[i + 1 + P[i]]:
            P[i] += 1

        if i + P[i] > R:
            C = i
            R = i + P[i]

    
    max_len, center_index = max((value, index) for index, value in enumerate(P))
    print(center_index, max_len, center_index - max_len)
    return string[(center_index - max_len) // 2 : (center_index + max_len) // 2], max_len

if __name__ == "__main__":
    s_arr = [
        "a",                # "a", 1
        "racecars",          # "racecar", 7
        "babad",            # "aba", 3
        "abcd",             # "d", 0
        "abccba",           # "abccba", 6
        "",                 # "", 0
        "a!b!a",            # "a!b!a", 5
        "bb"                # "bb", 2
    ]

    for s in s_arr:
        print(longest_palindrome_substring(s))