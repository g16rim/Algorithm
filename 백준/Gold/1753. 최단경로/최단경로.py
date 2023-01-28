import sys
input = sys.stdin.readline
import heapq

V, E = map(int, input().split())
K = int(input())
graph = [[] for _ in range(V+1)]
for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))
    
distance = [1e9] * (V+1)

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    
    while q:
        temp, node = heapq.heappop(q)
        if distance[node] < temp:
            continue
        for i in graph[node]:
            cost = temp + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
                
dijkstra(K)

for i in range(1, V+1):
    if distance[i] == 1e9:
        print('INF')
    else:
        print(distance[i])