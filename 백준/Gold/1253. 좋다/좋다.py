n = int(input())
a = list(map(int, input().split()))
a.sort()
result = 0

for k in range(n):
    find = a[k]
    i = 0
    j = n-1
    while i < j:
        if a[i]+a[j] == find:
            if i != k and j != k:
                result += 1
                break
            elif i == k:
                i += 1
            else:
                j -= 1
        elif a[i]+a[j] < find:
            i += 1
        else:
            j -= 1

print(result)