import re

for i in range(5):
    fileName = 'test' + str(i+1) +'.txt'    
    file = open(fileName)    
    text = file.read()
    pattern = re.compile(r"(\s)([0,1]\d|2[0-3])(:[0-5]\d){1,2}")
    matches = pattern.finditer(text)
    for j in matches:
        text = re.sub(pattern, " (TBD)", text)
    print(text + '\n')
    file.close()
