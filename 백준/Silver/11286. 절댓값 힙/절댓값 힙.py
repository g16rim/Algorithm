import heapq
import sys
input = sys.stdin.readline

n = int(input())
arr = []
for i in range(n):
    x = int(input())
    if x != 0:
        if x < 0: # 음수
            heapq.heappush(arr, (-x, 0))
        else: # 양수
            heapq.heappush(arr, (x, 1))
    else:
        if len(arr) == 0:
            print(0)
        else:
            num, sign = heapq.heappop(arr)
            if sign == 0:
                print(-num)
            else:
                print(num)