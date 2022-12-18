n = int(input()) 
result = [1 for _ in range(10)]

# n = 1
# 0 10 0~9
# 1 9 1~9
# 2 8 2~9
# 3 7 3~9
# 4 6
# 5 5
# 6 4
# 7 3
# 8 2
# 9 1

# n = 3
# 0 55 (n = 1일 때 result[0]~[9] 합)
# 1 45 (n = 1일 때 result[1]~[9] 합)
# 2 36
# 3 28
# 4 21
# 5 15
# 6 10
# 7 6
# 8 3
# 9 1

for i in range(n-1):
    for j in range(10):
        temp = 0
        for k in range(j+1, 10):
            temp += result[k]
        result[j] += temp
            
print(sum(result) % 10007)
