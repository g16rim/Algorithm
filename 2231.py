# 완전탐색
# 분해합 - Python

N = input() # N은 지금 str
answer = 0

for i in range(1, int(N) + 1): # i는 int
    temp = i
    iStr = str(i) # iStr은 str
    for j in range(0, len(iStr)):
        temp += int(iStr[j])
    if int(N) == temp:
        answer = i
        break

print(answer)