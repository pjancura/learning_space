with open("/Users/Paul/Desktop/programmingPractice/TriC_CodingBootcamp/uCertify/Python/lesson_8/my_text_file.txt") as f:
    for line in f:
        print(line)

with open("/Users/Paul/Desktop/programmingPractice/TriC_CodingBootcamp/uCertify/Python/lesson_8/my_text_file.txt", "r+") as f:
    content = f.read()

    print(content)


with open("new_text.txt", "w") as f:
    new_content = f.write(input())

with open("new_text.txt","r") as f:
    for line in f:
        print(line)
