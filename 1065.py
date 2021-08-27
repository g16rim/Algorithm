# 완전탐색
# 한수

N = int(input())
result = 0

if N < 100:
    result = N
elif N >= 100 and N < 1000:
    result += 99
    for num in range(100, N + 1):
        num_str = str(num)        
        if (int(num_str[0]) - int(num_str[1])) == (int(num_str[1]) - int(num_str[2])):
            result += 1
elif N == 1000:
    result = 144

print(result)