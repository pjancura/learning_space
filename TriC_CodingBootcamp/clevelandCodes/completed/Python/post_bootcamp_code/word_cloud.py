# this code will take a .txt file and output a dictionary
# the dictionary will have keywords of all the unique words in the .txt file
# the values will be an integer representing to total times a word appeared in the .txt file
# finally, the printed dictionary will be ordered from greatest value to least

import os

def create_word_cloud_from_text(input_file_path, output_folder_path, output_file_name):
    # Read the text file
    with open(input_file_path, 'r') as input_file:
        lines = input_file.readlines()

    # Create dictionary of key (unique words), values (the count)
    # turn lines into a single list
    word_list = []
    for line in lines:
        # some data cleaning
        words_to_remove = ["and", '\n', 'of', 'to', 'or', 'with', 'in', 'experience', 'the', 'development', 'a', 'years', 'for', 'software', 'as', 'strong', '&', 'on']
        unwanted_character = [('\n',''), ('(',''), (')',''), (',','')]
        # split each line into individual words
        split_line = line.split(" ")
        for word in split_line:
            cleaned_word = word
            # remove unwanted characters from words
            for char, replacement in unwanted_character:
                if char in word:
                    cleaned_word = word.replace(char, replacement)

            # remove unnecessary words
            if cleaned_word.lower() in words_to_remove or cleaned_word == '':
                pass
            else:
                word_list.append(cleaned_word.lower())
    
    # Turn word_list into a dictionary of unique keywords and increment the value by 1
    faux_word_cloud_dictionary = {}
    for word in word_list:
        if faux_word_cloud_dictionary.get(word):
            faux_word_cloud_dictionary[word] += 1
        else:
            faux_word_cloud_dictionary[word] = 1

    # Reorder dictionary so that the highest values are first
    ranked_dictionary = dict(reversed(sorted(faux_word_cloud_dictionary.items(), key=lambda x:x[1])))

    # Create the folder if it doesn't exist
    if not os.path.exists(output_folder_path):
        os.makedirs(output_folder_path)

    # Create the file path
    output_file_path = os.path.join(output_folder_path, f'{output_file_name}.txt')


    # Create faux word cloud document
    with open(output_file_path, 'w') as output:
        for key, value in ranked_dictionary.items():
            output.write(f'{key}: {value} \n')
        output.close()



    



# This is the file that will be read
file_to_read = "./input_texts/software_developer_qualifications.txt"
# this is the output folder name
output_folder = "output_texts"
# This is the output name of the file minus the file extension
file_to_write = "faux_word_cloud"

create_word_cloud_from_text(file_to_read, output_folder, file_to_write)
