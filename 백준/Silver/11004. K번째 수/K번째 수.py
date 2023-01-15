n, k = map(int, input().split())
data = list(map(int, input().split()))
data.sort()
print(data[k-1])