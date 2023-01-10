n = int(input())
p = list(map(int, input().split()))
result = 0

p.sort()
for i in range(n):
    result = result + (n-i) * p[i]

print(result)