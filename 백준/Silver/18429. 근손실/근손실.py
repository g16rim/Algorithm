def bt(day):
    global answer, temp
    if day == n:
        answer += 1
        return
    for i in range(n):
        if visited[i] == 0 and temp+w[i]-k >= 500:
            temp += (w[i]-k)
            visited[i] = 1
            bt(day+1)
            visited[i] = 0
            temp -= (w[i]-k)


n, k = map(int, input().split()) # k : 하루에 줄어드는 중량
w = list(map(int, input().split()))
visited = [0] * n
temp = 500
answer = 0
bt(0)
print(answer)