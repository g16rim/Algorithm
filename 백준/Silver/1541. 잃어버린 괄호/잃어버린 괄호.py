import sys
input = sys.stdin.readline

minus = input().split('-')
result = 0

for i in range(len(minus)):
    plus = minus[i].split('+')
    temp = 0
    for p in plus:
        temp += int(p)
    if i == 0: # 처음은 무조건 +
        result = temp
    else:
        result -= temp
    
print(result)