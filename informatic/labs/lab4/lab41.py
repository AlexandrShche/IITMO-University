import re

pattern = re.compile(r"([^.,?!]{1,}(,)([^.?!]){1,})(!)")
file = open("RomeoAndJuliet.txt")
text = file.read()
for sentence in pattern.findall(text):
    print(sentence, '\n')
file.close()
