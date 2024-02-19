try:
    with open('input.txt', 'r') as myinputfile:
        for line in myinputfile:
            print(line)
except:
    print("file was not found")

print("the code continues despite not finding file")

#new errors
try:
    with open('input.txt', 'r') as myinputfile:
        for line in myinputfile:
            print(line)
except FileNotFoundError:
    print("Whoops! File does not exist.")
except ValueError:
    print("A value error occurred")



try:
    with open('input.txt', 'r') as myinputfile:
        for line in myinputfile:
            print(line)
except FileNotFoundError:
    print("Whoops! File does not exist.")
except ValueError:
    print("A value error occurred")
except Exception:
    print("Something unforeseen happened")

print("Execution will continue to here.")