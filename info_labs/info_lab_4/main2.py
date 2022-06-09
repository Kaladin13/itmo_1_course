

from gettext import find


file = "schedule.xml"
output = "out.json"


def task_1():
    with open(file, 'r') as f:
        k = 1
        l = 0
        with open(output, 'w') as o:
            o.write('{\n')
            for a in f.readlines():
                s = a.replace('\t', '')
                if s.find("schedule") > 0:
                    continue
                if s.count('<') == 1:
                    if s.find("lessons") > 0:
                        if s.find("</") < 0:
                            o.write(' ' * 4 * k + s.replace('<', '"').replace('>', '" : [') + '\n')
                            k+=1
                        else:
                            o.write(' ' * 4 * (k-1) + "]\n")
                            k-=1
                    elif s.find("lesson") > 0:
                        if s.find("</") < 0:
                            l+=1
                            o.write(' ' * 4 * k + "{" + '\n')
                            k+=1
                        else:
                            if l == 2:
                                o.write(' ' * 4 * (k) + "}" + '\n')
                            else: 
                                o.write(' ' * 4 * (k) + "}," + '\n')
                            # k-=1
                    elif s.find("</") < 0:
                        o.write(' ' * 4 * k + s.replace('<', '"').replace('>', '" : {') + '\n')
                        k += 1
                    else:
                        o.write(' ' * 4 * k + '},' + '\n')
                        # k -= 1
                elif s.count('<') == 2:
                    if s.find("place") > 0 or s.find("teacher") > 0:
                        o.write(' ' * 4 * k + s[:s.find("</")].replace('<', '"').replace('>', '" : "') + '"' +  '\n')
                        k-=1
                    else:
                        o.write(' ' * 4 * k + s[:s.find("</")].replace('<', '"').replace('>', '" : "') + '",' +  '\n')
            o.write('}')
        
task_1()