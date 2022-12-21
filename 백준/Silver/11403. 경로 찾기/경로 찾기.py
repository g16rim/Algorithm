n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

# 플로이드 워셜 알고리즘, 모든 지점에서 다른 모든 지점까지의 경로를 구해야 하는 경우
for k in range(n): # 노드 개수만큼
    for i in range(n): 
        for j in range(n):
            if graph[i][j] == 1 or graph[i][k] + graph[k][j] == 2:
                graph[i][j] = 1
                
for i in range(n):
    for j in range(n):
        print(graph[i][j], end=' ')
    print()