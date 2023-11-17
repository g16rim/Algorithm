T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    num = 1

    # 약수 구하기
    for i in range(2, int(n ** (1/2)) + 1):
        if n % i == 0:
            num = i

    num += (n // num)
    print('#' + str(test_case) + ' ' + str(num - 2))