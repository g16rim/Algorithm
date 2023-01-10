n = int(input())
people = [list(map(int, input().split())) for _ in range(n)]

for i in range(n):
    rank = 1
    for j in range(n):
        if i == j: continue
        if people[i][0] < people[j][0] and people[i][1] < people[j][1]:
            rank += 1
    people[i].append(rank)
    
for i in range(n):
    print(people[i][2], end=' ')