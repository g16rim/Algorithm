import sys
from collections import deque
input = sys.stdin.readline

def bfs(x, y):
    q = deque()
    q.append((x, y))
    map[x][y] = -1
    cnt = 1
    
    while q:
        x, y = q.popleft()
        
        dx = [-1, 1, 0, 0]
        dy = [0, 0, -1, 1]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < n and 0 <= ny < n and map[nx][ny] == 1:
                map[nx][ny] = -1 # 방문 처리
                cnt += 1 # q에 들어갈 때마다 cnt++
                q.append((nx, ny))
    return cnt
                
n = int(input())
map = [list(map(int, input().rstrip())) for _ in range(n)]
result = []

for i in range(n):
    for j in range(n):
        if map[i][j] == 1:
            result.append(bfs(i, j))
            
print(len(result))
result.sort()
for i in range(len(result)):
    print(result[i])