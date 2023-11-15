T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    count = [0] * 10
    i = 1

    while sum(count) != 10:
        temp = n * i
        while temp > 0:
            count[temp % 10] = 1
            temp //= 10
        i += 1

    print('#', test_case, ' ', (i - 1) * n, sep='')