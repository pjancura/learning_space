def longestPalSubstr(string):
    # if len(string) <= 1:

    modifiedString = "#".join("^{}$".format(string))        # add the "^" and "$" to make it easier to add the unique char, this will allow you to turn any palindromes into an odd length
    n = len(modifiedString)
    P = [0] * n         # holds the result data
    C = 0
    R = 0
    print(f"\nmodified_string: {modifiedString}")
    for i in range (1,n-1):                     # starts at index 1 and ends 1 index before the end to exclude the "^" and "$"
        # print(f"P: {P}, C: {C}, R: {R}, i: {i}")
        if i < R:                           # this looks for the mirror indexes???
            P[i] = min(R-i, P[2*C-i])
        
        # Attempt to expand palindrome centered at i
        expand_right = modifiedString[i + 1 + P[i]]
        expand_left = modifiedString[i - 1 - P[i]]
        while expand_right == expand_left:
            # print(f"ex_l: {expand_left}, ex_r: {expand_right}")
            P[i] += 1
            expand_right = modifiedString[i + 1 + P[i]]
            expand_left = modifiedString[i - 1 - P[i]]
        
        # If palindrome centered at i expand past R,
        # adjust center based on expanded palindrome.
        # this is the updating part of the loop
        # print(f"i + P[i]: {i + P[i]}")
        if i + P[i] > R:
            C, R = i, i + P[i]
    
    # Find the maximum element in P.
    # print(P)
    # enumerated_P = ((i, n) for n, i in enumerate(P))
    # for n, i in enumerated_P:
    #     print(n, i, end=", ", sep=" ")
    # print()
    # max_tuple = max((n, i) for i, n in enumerate(P))
    # print(f"max_tuple: {max_tuple}")
    max_len, center_index = max((n, i) for i, n in enumerate(P))                # compares the max_len first then the center_index for the max(), n is the value, i is the index
    # print(f"max_len: {max_len}, center_index: {center_index}")
    return string[(center_index  - max_len)//2:(center_index  + max_len)//2], max_len    # operate on the original string and modify the mapped data to reflect the exclusion of the unique char "#"

# Test
# print(longestPalSubstr("abccba")) # Output: "abccba"


if __name__ == "__main__":
    s_arr = [
        "a",                # "a", 1
        "racecar",          # "racecar", 7
        "babad",            # "aba", 3
        "abcd",             # "d", 0
        "abccba",           # "abccba", 6
        "",                 # "", 0
        "a!b!a"             # "a!b!a", 5
    ]

    for s in s_arr:
        print(longestPalSubstr(s))