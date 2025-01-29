def longest_palindrome_substring(s):
    if len(s) == 0:
        return ""
    if len(s) == 1:
        return s
    
    mod_s = "#".join(f"^{s}$")
    len_mod_s = len(mod_s)
    center = 0
    right = 0
    p_data = [0] * len_mod_s

    for i in range(1, len_mod_s - 1):

        if right > i:
            p_data[i] = min(right - i, p_data[2 * center - i])

        while mod_s[i - 1 - p_data[i]] == mod_s[i + 1 + p_data[i]]:
            p_data[i] += 1

        if i + p_data[i] > right:
            center = i
            right = i + p_data[i]

    max_len, center_index = max((value, index) for index, value in enumerate(p_data))
    
    return s[(center_index - max_len) // 2: (max_len + center_index) // 2]

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