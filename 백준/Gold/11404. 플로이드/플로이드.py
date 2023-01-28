import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
bus = [[1e9] *(n+1) for _ in range(n+1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    if bus[a][b] > c:
        bus[a][b] = c

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            bus[i][j] = min(bus[i][j], bus[i][k]+bus[k][j])
            
for i in range(1, n+1):
    for j in range(1, n+1):
        if bus[i][j] == 1e9 or i==j: 
            bus[i][j] = 0
        print(bus[i][j], end=' ')
    print()