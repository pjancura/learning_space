import random

cohort_15 = ["Paul","Eugene","Ira","Russell","Antonio","Loomis","Todd","Chandler","Amber"]



def team_randomizer(l):
    print(f"\n\n\n\n****************************************************")
    team_1 = []
    team_2 = []
    counter = 0            #maintains the length of what is left to assign to a team
    run_picker = True
    counter_2 = 0
    while run_picker:
        counter_2 += 1
        if counter < len(l):
            counter += 1       
        rand_i = random.randint(0,(len(l) - counter))
        popped = l.pop(rand_i)
        rand_i_2 = random.randint(1,2)
        if (len(l)) == (len(team_1) + len(team_2)):                 #this accounts for an odd numbered list
            team_1.append(popped)
            l.append("Tie breaker assigned to team_1")
        elif (rand_i_2 == 1) and (len(team_1) < (len(l)//2)):       #this makes sure that teams are equal in size
            team_1.append(popped)
            l.append("assigned to team_1")
        elif (rand_i_2 == 2) and (len(team_2) < (len(l)//2)):
            team_2.append(popped)
            l.append("assigned to team_2")
        else:
            l.insert(0,popped)
            counter -= 1
        if len(l) == len(team_1) + len(team_2):
            print(f"\nEnding team_randomizer()\nI ran {counter_2} times to assign the teams.")
            break
        if counter_2 == 100:
            print("\nI ran 100 times boss\n")
            run_picker = False
    return team_1, team_2


team_1, team_2 = team_randomizer(cohort_15)

print(f"\n********** TEAMS *********\n")
print(f"Here is Team 1: \n{team_1}\n")
print(f"Here is Team 2: \n{team_2}\n")
print(f"**********       **********\n")





#################   BELOW IS THE MESSY VERSION WITH ALL OF THE PRINT STATEMENTS    #######################

# def team_randomizer(l):
#     print(f"\n\n\n\n****************************************************\n\n\nHalf the length of the input list rounded down:\n{len(l)//2}\n")
#     team_1 = []
#     team_2 = []
#     counter = 0            #maintains the length of the initial list
#     run_picker = True
#     counter_2 = 0
#     while run_picker:
#         print(f"Length of Team_1: {len(team_1)}\nLength of Team_2: {len(team_2)}\nLength of input List: {len(l)}\nCounter: {counter}\n")
#         print(f"Input list: {l}\n")
#         counter_2 += 1
#         if counter < len(l):
#             counter += 1
#         print(f"Length of Team_1 and Team_2: {len(team_1) + len(team_2)}\nLength of input list: {len(l)-1}")
#         end_range = 0,(len(l) - counter)        
#         rand_i = random.randint(0,(len(l) - counter))
#         print(f"End_range_rand_i: {end_range}\nRandom Integer Generated: {rand_i}")
#         popped = l.pop(rand_i)
#         rand_i_2 = random.randint(1,2)
#         print(f"rand_i_2 = {rand_i_2}")
#         if (len(l)) == (len(team_1) + len(team_2)):
#             team_1.append(popped)
#             l.append("Tie breaker assigned to team_1")
#             print(f"On Team_1 tie breaker: {popped}")
#         elif (rand_i_2 == 1) and (len(team_1) < (len(l)//2)):
#             team_1.append(popped)
#             l.append("assigned to team_1")
#             print(f"On Team_1: {popped}")
#         elif (rand_i_2 == 2) and (len(team_2) < (len(l)//2)):
#             team_2.append(popped)
#             l.append("assigned to team_2")
#             print(f"On Team_2: {popped}")
#         else:
#             l.insert(0,popped)
#             counter -= 1
#             print(f"Popped inserted at index 0: {popped}")
#         if len(l) == len(team_1) + len(team_2):
#             print(f"\nEnding team_randomizer()\nI ran {counter} times to assign the teams.\n")
#             break
#         if counter_2 == 20:
#             print("\nI ran 20 times boss\n")
#             run_picker = False
#     return team_1, team_2
