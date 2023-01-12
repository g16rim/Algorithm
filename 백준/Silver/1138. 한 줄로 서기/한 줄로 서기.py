n = int(input())
p = list(map(int, input().split()))
result = [0] * n

for i in range(n):
    for j in range(n):
        if p[i] == 0 and result[j] == 0: #다 지나치고 자리가 비어있을 때
            result[j] = i+1
            break 
        elif result[j] == 0: #키 큰 사람 지나침
            p[i] -= 1
        #나보다 작은 사람 지나침
            
print(*result)