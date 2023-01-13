from collections import deque

def dfs(i):
    visited[i] = 1
    print(i, end=' ')
    for j in range(len(graph[i])):
        nextNode = graph[i][j]
        if visited[nextNode] == 0:
            dfs(nextNode)
            
def bfs(i):
    q = deque([i])
    while q:
        node = q.popleft()
        print(node, end=' ')
        visited[node] = 1
        for j in range(len(graph[node])):
            nextNode = graph[node][j]
            if visited[nextNode] == 0:
                q.append(nextNode)
                visited[nextNode] = 1

n, m, v = map(int, input().split())
graph = [[] for _ in range(n+1)]

for i in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)
for i in graph:
    i.sort()

visited = [0 for _ in range(n+1)]
dfs(v)
print()
visited = [0 for _ in range(n+1)]
bfs(v)