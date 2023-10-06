def string_compare(str_1, str_2):
    len_str_1 = len(str_1)
    len_str_2 = len(str_2)
    set_str_1 = set(str_1)
    #print(set_str_1)
    set_str_2 = set(str_2)
    str_intersect = set_str_1 & set_str_2
    len_str_intersect = len(str_intersect)

    print(len_str_1)
    print(len_str_intersect)
    perc_intersect = round(((len_str_intersect / len_str_1) + (len_str_intersect / len_str_2)) / 2 * 100,2)
    print(perc_intersect)
    if perc_intersect > 0:
        print(f"{str_1} and {str_2} are {perc_intersect}% the same")
    else:
        print("These strings have nothing in common")

s_1 = "Pytho"
s_2 = "Pythos"

print("_________________________")
string_compare(s_1,s_2)
