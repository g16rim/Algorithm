import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
# readline 개행 문자 rstrip 해야 됨
miro = [list(map(str, input().rstrip())) for _ in range(n)]
q = deque()
q.append([0, 0, 1])

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
while q:
    x, y, cnt = q.popleft()
    if x == (n-1) and y == (m-1):
        print(cnt)
        exit()
    
    # 새로운 곳 방문 안 했으면 q에 넣기
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if 0 <= nx < n and 0 <= ny < m and miro[nx][ny] == '1':
            # 방문처리
            miro[nx][ny] = 2
            q.append([nx, ny, cnt+1])