T = int(input())
coins = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
for test_case in range(1, T + 1):
    n = int(input())
    result = []

    for coin in coins:
        result.append(n//coin)
        n -= (coin * (n//coin))

    print('#', test_case, sep='')
    print(*result)