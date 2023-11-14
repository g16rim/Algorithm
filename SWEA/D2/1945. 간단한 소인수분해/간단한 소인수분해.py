T = int(input())
a = [2, 3, 5, 7, 11]
for test_case in range(1, T + 1):
    n = int(input())
    result = []

    for i in a:
        temp = n
        count = 0

        while temp != 1:
            if temp % i != 0:
                break
            temp //= i
            count += 1

        result.append(count)

    print('#', test_case, sep='', end=' ')
    print(*result)