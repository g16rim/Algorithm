n = int(input())
m = int(input())
a = list(map(int, input().split()))
a.sort()
result = 0
i = 0
j = n-1

while i < j:
    if a[i]+a[j] == m:
        result += 1
        i += 1
        j -= 1
    elif a[i]+a[j] < m:
        i += 1
    else:
        j -= 1

print(result)