N = int(input())
arr = list(map(int, input().split()))
dp = []
dp.append(arr[0])

for i in range(1, N):
    temp = [arr[i]]
    for j in range(i):
        if arr[j] < arr[i]:
            temp.append(dp[j]+arr[i])
    dp.append(max(temp))
    
print(max(dp))