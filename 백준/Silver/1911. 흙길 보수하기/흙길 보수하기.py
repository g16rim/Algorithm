n, l = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
arr.sort(key=lambda x:x[0])

temp = 0 # 마지막 널빤지 위치
result = 0

for start, end in arr:
    # 이전 널빤지가 다 덮고 있을 수도 있음
    if temp >= end:
        continue
    
    temp = max(start, temp)
    
    cnt = (end-(temp+1)) // l + 1 # 현재 웅덩이를 커버할 널빤지 개수
    result += cnt    
    temp += l * cnt
    
print(result)