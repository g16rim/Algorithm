T = int(input())
for test_case in range(1, T + 1):
    L, U, X = map(int, input().split())
    result = ''

    if X <= L:
        result += str(L-X)
    elif L <= X <= U:
        result += '0'
    elif X >= U:
        result += '-1'

    print('#', test_case, sep='', end=' ')
    print(result)