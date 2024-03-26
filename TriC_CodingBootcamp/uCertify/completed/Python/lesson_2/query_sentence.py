s = input("Sentence: ")
s2 = input("What would you like me to look for in the previous sentence? ")


# sanitize our inputs
sentence = s.lower().strip()
query = s2.lower().strip()

#count the occurrences
tally = sentence.count(query)
print(len(s))

print(f"There are {tally} occurrence(s) of {query} in your sentence.")