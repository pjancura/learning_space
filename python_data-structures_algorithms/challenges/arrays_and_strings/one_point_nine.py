#  string rotation
#  given 2 strings see if the 2nd is a rotation of the first:
        #   waterbottle => erbottlewat



def is_rotation(s1, s2):
    # check if both strings are the same length => return false if not
    if len(s1) != len(s2) and len(s1) > 0:
        return False
    # check if rotation == 0
    if s1 == s2:
        return True
    # compare if a rotation of s1 == s2 through looping and creating new strings
    for i in range(1, len(s1)):
        rotated = s1[ i : len(s1) ] + s1[:i]
    # return true if a match is found
        if rotated == s2:
            return True
    return False
    # otherwise false


#                                   BOOK SOLUTION
def is_rotation_book(s1, s2):
    length = len(s1)
    if length == len(s2) and length > 0:
        s1_s1 = s1 + s1     # the rotation (s2) will be in somewhere of s1 + s1 so just check for if s2 is a substring of s1
        if s2 in s1_s1:
        # if s1_s1.find(s2) != -1:            # alternate to the above if statement
            return True
    return False
    







if __name__ == "__main__":

    originals = ["waterbottle", "paul", "theresa"]
    rotations = ["erbottlewat", "upal", "atheres"]

    for s1, s2 in zip(originals, rotations):
        print(is_rotation(s1, s2))

    for s1, s2 in zip(originals, rotations):
        print(is_rotation_book(s1, s2))
