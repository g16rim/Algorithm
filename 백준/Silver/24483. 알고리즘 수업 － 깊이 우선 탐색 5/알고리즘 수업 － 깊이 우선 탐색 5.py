import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

n, m, r = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)
for i in range(n+1):
    graph[i].sort()
visited = [-1] * (n+1)
t = 1

def dfs(r, depth):
    global t
    visited[r] = t * depth 
    for node in graph[r]:
        if visited[node] != -1:
            continue
        t += 1
        dfs(node, depth+1)
        
dfs(r, 0)
result = 0
for i in visited:
    if i == -1:
        continue
    result += i
print(result)