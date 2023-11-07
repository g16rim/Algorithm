N = int(input())
arr = list(map(int, input().split()))
dp = [1]*N

for i in range(1, N):
    temp = [1]
    for j in range(i-1, -1, -1):
        if arr[j] > arr[i]:
            temp.append(dp[j]+1)
    dp[i] = (max(temp))
       
print(max(dp))