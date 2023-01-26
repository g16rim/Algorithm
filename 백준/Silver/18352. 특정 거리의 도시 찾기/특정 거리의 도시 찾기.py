from collections import deque
import sys

n, m, k, x = map(int, input().split())
city = [[] for _ in range(n+1)]
distance = [-1] * (n+1)

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    city[a].append(b)

def dijkstra(start):
    q = deque()
    q.append(start)
    distance[start] = 0
    
    while q:
        now = q.popleft()
        if distance[now] > k:
            break
        for i in city[now]:
            if distance[i] == -1:
                distance[i] = distance[now] + 1
                q.append(i)
                
dijkstra(x)

result = []
for i in range(1, n+1):
    if distance[i] == k:
        result.append(i)
        
if len(result) == 0:
    print(-1)
else:
    for r in result:
        print(r)