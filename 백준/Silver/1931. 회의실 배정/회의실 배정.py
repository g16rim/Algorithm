n = int(input())
meeting = [list(map(int, input().split())) for _ in range(n)]
meeting.sort(key = lambda x : x[0])
meeting.sort(key = lambda x : x[1])
result = 1
endtime = meeting[0][1]
for i in range(1, n):
    if endtime <= meeting[i][0]:
        result += 1
        endtime = meeting[i][1]
print(result)