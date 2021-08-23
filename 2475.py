# 검증수

number = list(map(int, input().split(' ')))
sum = 0

for i in range(5):
    sum += (number[i] * number[i])

print(sum % 10)