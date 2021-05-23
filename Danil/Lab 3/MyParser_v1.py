def Parse():

    opr = open("lab3.xml", 'r', encoding="utf-8")
    opw = open("Res3.yaml", 'w', encoding="utf-8")

    listXml = opr.readlines()
    countTab = 0;

    for text in listXml:

        if "</" in text:
            countTab -= 1

        elif "<" in text:
            f = text.find("<")
            l = text.find(">")

            opw.write( countTab * '    ' + text[f+1:l] + ":" + '\n')
            countTab += 1

        else:
            opw.write( countTab * '     ' + text)


    opr.close()
    opw.close()

def ParserWithRe():
    import xmlplain

    with open("lab3.xml", "r", encoding="utf8") as inf:
        root = xmlplain.xml_to_obj(inf, strip_space=True, fold_dict=True)
    with open("Rec3.yaml", "w", encoding="utf8") as outf:
        xmlplain.obj_to_yaml(root, outf)

import time

timeMy = time.time()
for i in range(10):
    Parse()
timeMy = time.time() - timeMy

timeAlien = time.time()
for i in range(10):
    ParserWithRe()
timeAlien = time.time() - timeAlien

print("Парсер без готовых библиотек: " + str(timeMy) + '\n' +
        "Парсер с готовыми библиотеками: " + str(timeAlien) + '\n' +
            "Парсер без готовых библиотек быстрее." if timeAlien > timeMy
                else "Парсер с готовыми библиотеками быстрее.")
