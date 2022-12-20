''' 시간초과 ////////////////////////////////////////////
n = int(input())
cp = []
for _ in range(n):
    cp.append(list(map(int, input().split())))

result = [0 for _ in range(n - 2)]
for i in range(1, n - 1): # 건너뛸 자리
    for j in range(1, n):
        jump = False
        if i == j:
            jump = True
        if jump == False:
            result[i-1] += (abs(cp[j][0] - cp[j-1][0]) + abs(cp[j][1] - cp[j-1][1]))
        else: # 방금 건너뛰었을 때
            result[i-1] += (abs(cp[j][0] - cp[j-2][0]) + abs(cp[j][1] - cp[j-2][1]))
        
print(min(result))
'''

n = int(input())
cp = []
for _ in range(n):
    cp.append(list(map(int, input().split())))
    
maxDiff = 0
for i in range(1, n-1): # i번째를 지났을 때 앞뒤로 차이 구하기
    diff = abs(cp[i][0] - cp[i-1][0]) + abs(cp[i][1] - cp[i-1][1]) + abs(cp[i+1][0] - cp[i][0]) + abs(cp[i+1][1] - cp[i][1]) - abs(cp[i+1][0] - cp[i-1][0]) - abs(cp[i+1][1] - cp[i-1][1])
    maxDiff = max(diff, maxDiff)
    
sum = 0
for i in range(1, n): # 전체 다 건넜을 때
    sum += (abs(cp[i][0] - cp[i-1][0]) + abs(cp[i][1] - cp[i-1][1]))

print(sum - maxDiff)