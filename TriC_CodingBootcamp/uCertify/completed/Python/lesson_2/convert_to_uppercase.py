s = input("Type something short for me. ")
s_len = len(s)
s_index = (s_len // 2)

s_to_upper = s[s_index:s_len].upper()  #THE 2ND INDEX NUMBER IS EXCLUDED IN THE SLICE. THAT IS WHY YOU DON'T HAVE -1 FROM THE LENGTH
s_to_lower = s[0:(s_index)].lower()
print(s_to_lower + s_to_upper)

