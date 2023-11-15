T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    Sum = 0

    for i in range(1, n+1):
        if i%2 == 0:
            Sum -= i
        else:
            Sum += i

    print('#', test_case, ' ', Sum, sep='')