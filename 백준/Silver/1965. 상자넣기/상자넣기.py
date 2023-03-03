import sys
input = sys.stdin.readline

n = int(input())
box = list(map(int, input().split()))
dp = [1]*n

for i in range(1, n):
    for j in range(0, i):
        if box[i] > box[j]:
            dp[i] = max(dp[j] + 1, dp[i])
               
print(max(dp))