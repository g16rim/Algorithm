from collections import deque

def bfs(x, y):
    temp = 1
    q = deque()
    q.append((x, y))
    pic[x][y] = 0
    
    while q:
        x, y = q.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < n and 0 <= ny < m:
                if pic[nx][ny] == 1:
                    pic[nx][ny] = 0
                    q.append((nx, ny))
                    temp += 1
                    
    return temp

n, m = map(int, input().split())
pic = [list(map(int, input().split())) for _ in range(n)]

cnt = 0
Max = 0

dx = [0, 0, 1, -1]
dy = [-1, 1, 0, 0]

for i in range(n):
    for j in range(m):
        if pic[i][j] == 1:
            cnt += 1
            Max = max(Max, bfs(i, j))
            
print(cnt)
print(Max)