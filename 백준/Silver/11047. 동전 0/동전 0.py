n, k = map(int, input().split())
coins = [int(input()) for _ in range(n)]
coins.reverse()
result = 0

for i in range(n):
    if coins[i] > k: continue
    result += k // coins[i]
    k %= coins[i]
    
print(result)