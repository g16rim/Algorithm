from collections import deque

def bfs(x, y):
    q = deque([(x, y)])
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and bc[nx][ny] == 1:
                q.append([nx, ny])
                bc[nx][ny] = 0
                
    return 1

t = int(input())
result = []
while t:
    m, n, k = map(int, input().split())
    bc = [[0]*m for _ in range(n)] # bㅐ chu...
    
    for _ in range(k):
        b, a = map(int, input().split())
        bc[a][b] = 1
        
    worm = 0
    for i in range(n):
        for j in range(m):
            if bc[i][j] == 1:
                worm += bfs(i, j)
    
    result.append(worm)
    t -= 1

for i in result:
    print(i)