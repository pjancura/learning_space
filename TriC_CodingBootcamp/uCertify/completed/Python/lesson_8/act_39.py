import random

def random_number_generator(num_of_randoms):
    rand_list = []
    for num_of_randoms in range(num_of_randoms):
        #rand = random.random()
        #new_num = round((random.random() * 101), 0)   #this was my way ...more how i learned to do it in Javascript
        new_num = random.randint(0,1000)                #this is using the randint builtin from the random module
        rand_list.append(new_num)
    return rand_list


print(random_number_generator(4))
