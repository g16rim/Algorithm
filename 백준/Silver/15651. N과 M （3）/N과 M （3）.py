import sys
input = sys.stdin.readline

def bt(level):
    if level == m:
        print(*result)
        return
    for i in range(1, n+1):
        result.append(i)
        bt(level+1)
        result.pop()

n, m = map(int, input().split())
result = []
bt(0)