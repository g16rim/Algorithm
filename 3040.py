# 완전탐색
# 백설 공주와 일곱 난쟁이

dwarf = []
for _ in range(9):
    dwarf.append(int(input()))
sum9 = sum(dwarf)

for i in range(7):
    for j in range(i + 1, 9):
        if (sum9 - 100) == (dwarf[i] + dwarf[j]):
            del dwarf[j]
            del dwarf[i]
            for n in range(len(dwarf)):
                print(dwarf[n]) 
            break
    if len(dwarf) == 7:
        break
            
           

