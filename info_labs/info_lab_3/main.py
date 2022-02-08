import re
x=input()
match = ":<{/"
print("Your string is " + x)
print("Smile is " + match)
m = re.findall(match,x)
print("Your smile has been matched " + str(len(m)))