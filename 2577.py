# 숫자의 개수

A = int(input())
B = int(input())
C = int(input())
number = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

mult = list(map(int, str(A * B * C)))
result = [0] * 10

for i in range(len(mult)):
    for n in range(10):
        if mult[i] == n:
            result[n] += 1
            break

print(*result, sep = '\n')    