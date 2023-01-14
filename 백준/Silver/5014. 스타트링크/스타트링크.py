from collections import deque

f, s, g, u, d = map(int, input().split())
visited = [False] * (f+1)
result = []

def bfs(n, c):
    q = deque([(n, c)])
    visited[n] = True

    while q:
        node, cnt = q.popleft()
        if node == g:
            result.append(cnt)
            return
        # visited[node] = True
        if node+u <= f and visited[node+u] == False:
            visited[node+u] = True
            q.append((node+u, cnt+1))
        if node-d > 0 and visited[node-d] == False:
            visited[node-d] = True
            q.append((node-d, cnt+1))
    
bfs(s, 0)
if len(result) == 0:
    print('use the stairs')
else:
    print(*result)