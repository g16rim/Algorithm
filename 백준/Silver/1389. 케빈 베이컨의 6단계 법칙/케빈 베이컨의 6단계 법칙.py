import sys
input = sys.stdin.readline

n, m = map(int, input().split())
f = [[0]*(n+1) for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    f[a][b] = 1
    f[b][a] = 1

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if i == j: continue
            if f[i][k] != 0 and f[k][j] != 0:
                if f[i][j] == 0:
                    f[i][j] = f[i][k]+f[k][j]
                else: 
                    f[i][j] = min(f[i][j], f[i][k]+f[k][j])

temp = sum(f[1])
result = 1
for n in range(2, n+1):
    if temp > sum(f[n]):
        temp = sum(f[n])
        result = n

print(result)