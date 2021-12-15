from timeit import Timer

import yaml
import xmltodict
import xmlplain
import re

file = "schedule.xml"
output = "out"


def task_1():
    with open(file, 'r') as f:
        k = 0
        with open(output, 'w') as o:
            for a in f.readlines():
                s = a.replace('\t', '')
                if s.count('<') == 1:
                    if s.find("</") < 0:
                        o.write(' ' * k + s.replace('<', '').replace('>', ": ") + '\n')
                        k += 1
                    else:
                        k -= 1
                elif s.count('<') == 2:
                    o.write(' ' * k + s[:s.find("</")].replace('<', '').replace('>', ": ") + '\n')
        with open(output, 'r') as ya:
            return yaml.safe_load(ya.read())


def task_2():
    with open(file, 'r') as f:
        s = f.read().replace('\t', '').replace('\n', '')
        with open(output, 'w') as ya:
            y = xmlplain.xml_to_obj(s, strip_space=True, fold_dict=True)
            xmlplain.obj_to_yaml(y, ya)
        with open(output, 'r') as ya:
            return yaml.safe_load(ya.read())


def task_3():
    with open(file, 'r') as f:
        k = 0
        match1 = r'/\w+'
        match2 = r'\w+'
        with open(output, 'w') as o:
            for a in f.readlines():
                s = a.replace('\t', '').replace('\n', '')
                n = re.findall(match1, s)
                if len(n) == 0:
                    o.write(' ' * k + s.replace('<', '').replace('>', ": ") + '\n')
                    k += 1
                else:
                    n = re.findall(match2, s)
                    if n == 1:
                        k -= 1
                    else:
                        o.write(' ' * k + s[:s.find("</")].replace('<', '').replace('>', ": ") + '\n')
        with open(output, 'r') as ya:
            return yaml.safe_load(ya.read())


def task_4():
    print(Timer('from __main__ import task_1; task_1()').timeit(100))
    print(Timer('from __main__ import task_2; task_2()').timeit(100))
    print(Timer('from __main__ import task_3; task_3()').timeit(100))


#task_1_yaml = task_1()
#print(task_1_yaml)
#task_2_yaml = task_2()
#print(task_2_yaml)
#task_3_yaml = task_3()
#print(task_3_yaml)
task_4()
