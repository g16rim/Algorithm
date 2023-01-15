data = []
for _ in range(9):
    data.append(int(input()))
for i in range(9):
    for j in range(9):
        if i == j: continue
        if sum(data)-data[i]-data[j] == 100:
            a = data[i]
            b = data[j]
data.sort()
for i in range(9):
    if a == data[i] or b == data[i]: continue
    print(data[i])