import sys
import heapq
input = sys.stdin.readline

n = int(input())
m = int(input())

city = [[] for _ in range(n+1)]
for _ in range(m):
    a, b, cost = map(int, input().split())
    city[a].append((b, cost))
    
start, end = map(int, input().split())
    
distance = [1e9] * (n+1)

def dijkstra(start, end):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if now == end:
            print(dist)
            return
        if distance[now] < dist:
            continue
        for i in city[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
                
dijkstra(start, end)