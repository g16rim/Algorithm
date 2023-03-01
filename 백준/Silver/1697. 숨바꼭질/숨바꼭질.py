import sys
from collections import deque
input = sys.stdin.readline

def bfs(n, k):
    visited = [False] * 100001
    q = deque()
    q.append((n, 0))
    while q:
        x, cnt = q.popleft()
        
        if x == k:
            print(cnt)
            return
        
        if 2*x <= 100000 and visited[2*x] == False:
            visited[2*x] = True
            q.append((2*x, cnt+1))
        if x+1 <= 100000 and visited[x+1] == False:
            visited[x+1] = True
            q.append((x+1, cnt+1))
        if x-1 >= 0 and visited[x-1] == False:
            visited[x-1] = True
            q.append((x-1, cnt+1))

n, k = map(int, input().split())
bfs(n, k)