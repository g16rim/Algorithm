n = int(input())
# SK

# SK CY

# SK CY SK
# SKSKSK

# SK CY SK CY
# SKSKSK CY

# SK CY SK CY SK
# SKSKSK CY SK
# SK CYCYCY SK

# SK CY SK CY SK CY
# SKSKSK CY SK CY
# SK CYCYCY SK CY
# SK CY SKSKSK CY
dp = []
dp.append('SK')
dp.append('CY')
dp.append('SK')
dp.append('CY')
for i in range(4, n):
    dp.append(dp[i-2])
    
print(dp[n-1])