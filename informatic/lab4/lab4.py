import re

for i in range(1):
    fileName = 'test' + str(i+1) +'.txt'    
    file = open(fileName, encoding="utf-8")    
    text = file.read()
    pattern = re.compile((\s)([0,1]\d|2[0-3])(:[0-5]\d){1,2})
    matches = pattern.finditer(text)
    for j in matches:
        text = pattern.sub(matches[j], (TBD), text, j)
    print('\n' + text + '\n')
    file.close()
