import sys
input = sys.stdin.readline

def bt(idx, sum):
    global result
    
    if idx == n:
        return
    
    sum += data[idx]
    
    if sum == s:
        result += 1
    
    bt(idx+1, sum)
    bt(idx+1, sum-data[idx])


n, s = map(int, input().split())
data = list(map(int, input().split()))
data.sort()
result = 0

bt(0, 0)
print(result)