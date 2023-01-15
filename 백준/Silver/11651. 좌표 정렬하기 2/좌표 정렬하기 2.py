n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
graph.sort(key = lambda x : (x[1], x[0]))
for i in range(n):
    print(graph[i][0], graph[i][1])