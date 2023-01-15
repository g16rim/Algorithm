import bisect

n = int(input())
numCard = list(map(int, input().split()))
m = int(input())
check = list(map(int, input().split()))
numCard.sort()

for i in range(m):
    leftIdx = bisect.bisect_left(numCard, check[i])
    rightIdx = bisect.bisect_right(numCard, check[i])
    if rightIdx - leftIdx == 1: check[i] = 1
    else: check[i] = 0
        
print(*check)