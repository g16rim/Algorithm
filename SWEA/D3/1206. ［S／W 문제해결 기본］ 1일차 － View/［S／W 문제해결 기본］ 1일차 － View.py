for test_case in range(1, 11):
    n = int(input())
    a = list(map(int, input().split()))
    result = [0] * (len(a))

    for i in range(2, len(a)-2):
        result[i] = a[i] - max(max(a[i-2], a[i-1]), max(a[i+1], a[i+2]))
        if result[i] < 0:
            result[i] = 0

    print('#' + str(test_case) + ' ' + str(sum(result)))