import sys
input = sys.stdin.readline

n, k = map(int, input().split())
rank = [list(map(int, input().split())) for _ in range(n)]
rank.sort(key=lambda x : x[3], reverse=True)
rank.sort(key=lambda x : x[2], reverse=True)
rank.sort(key=lambda x : x[1], reverse=True)

temp = 1
rank[0].append(temp)
for i in range(1, n):
    if rank[i-1][1] > rank[i][1]:
        temp += 1
        rank[i].append(temp)
        continue
    
    if rank[i-1][2] > rank[i][2]:
        temp += 1
        rank[i].append(temp)
        continue
    
    if rank[i-1][3] > rank[i][3]:
        temp += 1
        rank[i].append(temp)
        continue
    
    rank[i].append(temp)
    
for i in range(len(rank)):
    if rank[i][0] == k:
        print(rank[i][4])