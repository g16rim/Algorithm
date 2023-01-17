# import math # 소수점 버림 함수

x, y = map(int, input().split())
# z = math.trunc(y / x * 100)
z = y * 100 // x

# 예외 설정, 한 번이라도 졌으면 100 안 됨
# if z >= 99:
#     print(-1)

start = 1
end = 1000000000
result = -1

while start <= end:
    mid = (start + end) // 2
    # if math.trunc((y+mid) / (x+mid) * 100) > z: # 승률이 올랐다면
    if ((y+mid) * 100 // (x+mid)) > z:
        end = mid-1
        result = mid
    else:
        start = mid+1
    
print(result)