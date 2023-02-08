n = int(input())
pt = []
for _ in range(n):
    x, y = map(int, input().split())
    pt.append((y, x))
pt.sort()

result = 0
for i in range(n):
    if i == (n-1):
        result += (pt[i][1] - pt[i-1][1])
        break
    if i == 0 or (pt[i+1][0] == pt[i][0] and pt[i][0] != pt[i-1][0]):
        result += (pt[i+1][1] - pt[i][1])
    elif (pt[i][0] == pt[i-1][0] and pt[i+1][0] != pt[i][0]):
        result += (pt[i][1] - pt[i-1][1])
    else:
        result += min(pt[i][1]-pt[i-1][1], pt[i+1][1]-pt[i][1])

print(result)