from collections import deque

com = int(input())
n = int(input())
graph = [[] for _ in range(com+1)]
for i in range(n):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

q = deque()
q.append(1)
virus = [0 for _ in range(com+1)]
while q:
    x = q.popleft()
    virus[x] = 1
    for i in range(len(graph[x])):
        if virus[graph[x][i]] == 1: continue
        q.append(graph[x][i])
        
print(sum(virus)-1)