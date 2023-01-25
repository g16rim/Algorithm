n = int(input())
dp = list(map(int, input().split()))

for i in range(1, n):
    if dp[i-1]+dp[i] > dp[i]:
        dp[i] = dp[i-1] + dp[i]
        
print(max(dp))