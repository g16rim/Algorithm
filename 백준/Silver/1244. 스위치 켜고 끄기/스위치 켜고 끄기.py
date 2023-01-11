n = int(input())
switch = [0] + list(map(int, input().split()))
tc = int(input())
cond = [list(map(int, input().split())) for _ in range(tc)]

for i in range(tc):
    temp = cond[i][1]
    if cond[i][0] == 1: # 남자
        for j in range(temp, len(switch), temp):
            if switch[j] == 0: switch[j] = 1
            else: switch[j] = 0
    else: # 여자
        if switch[temp] == 0: switch[temp] = 1
        else: switch[temp] = 0
        for j in range(temp + 1, len(switch)):
            diff = j - temp
            if (temp-diff) == 0: break
            if switch[temp+diff] != switch[temp-diff]: break
            if switch[temp+diff] == 0: 
                switch[temp+diff] = 1
                switch[temp-diff] = 1
            elif switch[temp+diff] == 1: 
                switch[temp+diff] = 0
                switch[temp-diff] = 0
                
# switch = switch[1:len(switch)]
# print(*switch)
for i in range(1, len(switch)):
    print(switch[i], end=' ')
    if i % 20 == 0: print()