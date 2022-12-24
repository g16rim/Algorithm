from collections import deque

m, n = map(int, input().split())
tomato = [list(map(int, input().split())) for _ in range(n)]
q = deque()

for i in range(n):
    for j in range(m):
        if tomato[i][j] == 1:
            q.append([i, j])

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
while q:
    x, y = q.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < m:
            if tomato[nx][ny] != 0: continue
            tomato[nx][ny] = tomato[x][y] + 1
            q.append([nx, ny])
        
flag = False
result = -1
for i in range(n):
    for j in range(m):
        if tomato[i][j] == 0:
            flag = True
            break
        result = max(result, tomato[i][j])
    if (flag): break

if (flag): print("-1")
else: print(result - 1)