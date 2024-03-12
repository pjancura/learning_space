#####   DESIGN
# we want to diagnose a user's state of dehydration based on a short questionaire
    # yes-or-no type questions
    # previous responses determine next questions
    # diagnosis at sever/some/no dehydration levels
# we want to retrieve and add dehydration diagnoses
    # display a list of patients and diagnoses
    # store new diagnoses in the list

# 2 main functions
    # run new diagnoses and store results
    # display a list of previous patients / diagnoses

# it will be text based and run within the Terminal

#####  practice with print()
#print(1)
#print("Welcome doctor! What would you like to do today?")

##### practice with input()
#name = input("What is your name:\n")
#print(name)

welcome_prompt = "Welcome doctor! What would you like to do today?\
\n - To list all patients, press 1\n - To run a new diagnosis, press 2\
\n - To quit, press q\n"

name_prompt = "\nWhat is the patient's name?\n"
appearance_prompt = "\nHow is the patient's general appearance?\n - 1: Normal Appearance\n\
 - 2: Irritable or lethargic\n"

skin_test_prompt = "\nDo the skin pinch test.\n - 1: Skin returned normally\n - 2: Skin returned slowly\n"
eye_test_prompt = "\nAssess the patient's eyes.\n - 1: Eyes look normal / slightly sunken\n - 2: Eyes look very sunken\n"

no_dehydration = "No dehydration."
some_dehydration = "Some dehydration."
severe_dehydration = "Severe dehydration."

patients_and_diagnoses = {}

def list_patients():
    print("Listing Patients and diagnoses")

def assess_skin(result_skin):
    if result_skin == "1":
        return some_dehydration
    elif result_skin == "2":
        return severe_dehydration
    else:
        print("\nInvalid input, please try again.\n")
        assess_skin(input(skin_test_prompt))

def assess_eyes(result_eyes):
    if result_eyes == "1":
        return no_dehydration
    elif result_eyes == "2":
        return severe_dehydration
    else:
        print("\nInvalid input, please try again.\n")
        assess_eyes(input(eye_test_prompt))

def assess_appearance():
    appearance = input(appearance_prompt)
    if appearance == "1":
        return assess_eyes(input(eye_test_prompt))
    elif appearance == "2":
        return assess_skin(input(skin_test_prompt))
    else:
        print("\nInvalid input, please try again.\n")
        assess_appearance()

def save_diagnosis(name, diagnosis):
    if name == "" or diagnosis == "":
        print("Could not save patient and diagnosis due to invalid input.")
    else:
        print(f"\n{name}'s Result: {diagnosis}\n")
        patients_and_diagnoses.update({name: diagnosis}) 


def start_new_diagnosis():
    name = input(name_prompt)
    diagnosis = assess_appearance()
    save_diagnosis(name, diagnosis)

def list_patients():
    print("\nList of a patients and dianoses:")
    for patient in patients_and_diagnoses:
        print(f"{patient}: {patients_and_diagnoses[patient]}")
    print("\n")


def main():
    diagnose = True
    while diagnose:
        selection = input(welcome_prompt)
        if selection == "1":
            # list all patients
            list_patients()
        elif selection == "2":
            # run a new diagnosis
            start_new_diagnosis()
        elif selection.lower() == "q":
            diagnose = False
        else:
            print("\nInvalid input. Please try again.\n")


main()


### practice unit test
def test_assess_skin():
    print(assess_skin("1") == some_dehydration)
    print(assess_skin("2") == severe_dehydration)
    print(assess_skin("q") == severe_dehydration or some_dehydration)
    return

#test_assess_skin()


### practice integration test
def test_assess_appearance():
    print(assess_appearance())

#test_assess_appearance()