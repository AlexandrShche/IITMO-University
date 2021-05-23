
def Parse():

    opr = open("lab3.xml", 'r', encoding="utf-8")
    opw = open("Res3.yaml", 'w', encoding="utf-8")

    listXml = opr.readlines()
    countTab = 0;

    for text in listXml:
        ctext = text

        while len(ctext) != 0:
            if ctext[0] == ' ':
                ctext = ctext[1:]

            elif ctext[0] == '\n' or ctext[0] == '\t':
                ctext = ctext[1:]

            elif "</" in ctext[:2]:
                countTab -= 1
                l = ctext.find(">")
                ctext = ctext[l+1:]

            elif "<" in ctext[0]:
                f = ctext.find("<")
                l = ctext.find(">")

                opw.write( countTab * '    ' + ctext[f+1:l] + ":" + '\n')
                ctext = ctext[l+1:]
                countTab += 1

            else:
                if "<" in ctext:
                    f = ctext.find("<")

                    if ":"  in ctext[:f] or ctext[:f].isdigit():
                        opw.write( countTab * '     ' + "'" + ctext[:f] + "'" + '\n')
                        ctext = ctext[f:]
                    else:
                        opw.write( countTab * '     ' + ctext[:f] + '\n')
                        ctext = ctext[f:]
                else:
                    if ":" in ctext or ctext.isdigit():
                        opw.write( countTab * '     ' + "'" + ctext + "'")
                        ctext = ctext[len(ctext):]
                    else:
                        opw.write( countTab * '     ' + ctext)
                        ctext = ctext[len(ctext):]

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
