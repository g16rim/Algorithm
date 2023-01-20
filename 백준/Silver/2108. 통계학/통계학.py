import sys 
from collections import Counter

n = int(sys.stdin.readline())
data = []

for _ in range(n):
    num = int(sys.stdin.readline())
    data.append(num)
    
data.sort()
result = []

# 산술평균
result.append(round(sum(data) / n))

# 중앙값
result.append(data[n // 2])

# 최빈값(여러 개일 경우 두 번째로 작은 값)
# cnt = [data[0]]
# for i in range(1, n):
#     if data[i] == data[i-1]: continue
#     temp = data.count(cnt[0])
#     new = data.count(data[i])
#     if new > temp:
#         cnt = [data[i]]
#     elif new == temp:
#         cnt.append(data[i])
# if len(cnt) == 1:
#     result.append(cnt[0])
# else:
#     result.append(cnt[1])
mode = Counter(data).most_common()

if len(mode) == 1:
    result.append(mode[0][0])
elif mode[0][1] == mode[1][1]:
    result.append(mode[1][0])
else:
    result.append(mode[0][0])

# 범위
result.append(data[n-1] - data[0])

for r in result:
    print(r)