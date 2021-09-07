import re
 
fin = open("lab3.json", 'r')
fout = open("lab3.yaml", 'w')

stack = []
stack_1 = []

def get_main_parts(str):
     str = str.strip()
     str = re.split("\s|\"\:", str)
     str[0] = str[0].strip("\"")
     for k in range(0, len(str)):
         str[k] = str[k].strip("\,")
     return str

def append_tab(key):
    for j in range(0, len(stack)):
        fout.write('   ')
    stack.append(key)
    fout.write(key + ':')
    
def value_o_key(key):
    s = 0
    e = 0
    print(key)
    for i in range(0, len(key)):
        start = re.search(r"\[|(^\")|\d", key[i])
        if (start) and (s == 0):
            s = i
        end = re.search(r"(\"$)|\d|\]", key[i])
        if (end):
            e = i
    for i in range(s, e+1):
        key[i] = key[i].strip("\[|\]")
        key[i] = key[i].strip("\"")
        if i == e:
            fout.write(key[i])
        else:
            fout.write(key[i])

def close_tag(key):
    for j in range(0, len(stack)):
        fout.write('   ')
    fout.write(">\n")

def close_tag_without_space(key):
    fout.write(">\n")

    
for line in fin:
    m = get_main_parts(line)
    print(m)
    if (len(m) > 2):
        if (m[2] == '{')  or (m[1] == '{'):
            append_tab(m[0])
            fout.write("\n")
        elif (m[2] == '[') or (m[1] == '['):
            stack_1.append(m[0])
        else:
            append_tab(m[0])
            value_o_key(m)
            close_tag_without_space(stack.pop())
    if (len(m) == 2):
        if (m[1] == '{'):
            append_tab(m[0])
        if (m[0] == '{'):
            if (len(stack_1) != 0):
                k = stack_1.pop()
                stack_1.append(k)
                append_tab(k)
                fout.write("\n")
        if (m[1] == '['):
            if (len(stack) != 0):
                stack_1.append(m[0])
    
        if ((m[0] == '}') or (m[1] == '}')):
            if (len(stack) != 0):
                close_tag(stack.pop())
                
    
        if (m[0] == ']') or (m[1] == ']'):
            if (len(stack_1) != 0):
                stack_1.pop()

    if (len(m) == 1):
        if (m[0] == '}'):
            break

fin.close()
fin.close()
