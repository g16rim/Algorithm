def solve(x):
    if len(result) == m:
        print(*result)
        return
    for i in range(x, n+1):
        result.append(i)
        solve(i)
        result.pop()

n, m = map(int, input().split())
result = []
solve(1)