p, m = map(int, input().split())
people = []
for _ in range(p):
    l, n = input().split()
    people.append([int(l), n])
rooms = []

for l, n in people:
    flag = False
    for i in range(len(rooms)):
        if len(rooms[i][1]) == m:
            continue
        
        if rooms[i][0]-10 <= l <= rooms[i][0]+10:
            flag = True
            rooms[i][1].append([l, n])
            break
            
    if not flag:
        rooms.append([l, [[l, n]]])

for i in range(len(rooms)):
    if len(rooms[i][1]) == m:
        print('Started!')
        tmp_ids = sorted(rooms[i][1], key=lambda x: x[1])
        for j in range(m):
            print(*tmp_ids[j])
    else:
        print('Waiting!')
        tmp_ids = sorted(rooms[i][1], key=lambda x: x[1])
        for j in range(len(tmp_ids)):
            print(*tmp_ids[j])