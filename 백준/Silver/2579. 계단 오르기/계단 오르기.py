n = int(input())
st = []
dp = [0] * n
for _ in range(n):
    st.append(int(input()))

if n == 1:
    print(st[0])
    exit()
elif n == 2:
    print(st[0]+st[1])
    exit()

dp[0] = st[0]
dp[1] = st[0] + st[1]
dp[2] += max(st[0], st[1]) + st[2]
for i in range(3, n):
    dp[i] = max(dp[i-2]+st[i], dp[i-3]+st[i-1]+st[i])

print(dp[n-1])

# dp 문제 -> 인덱스를 잘 고려할 필요가 있다