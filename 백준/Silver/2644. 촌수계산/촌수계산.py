n = int(input())
a, b = map(int, input().split())
m = int(input())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
result = []

for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)
    

def dfs(v, cnt):
    visited[v] = 1
    
    if v == b: # 도착
        result.append(cnt)
        
    for i in graph[v]:
        if visited[i] == 0:
            dfs(i, cnt+1)
            
dfs(a, 0)
if len(result) == 0: print(-1)
else: print(*result)

# 방문 처리! - 안 하면 recursive error