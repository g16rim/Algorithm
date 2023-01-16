n = int(input())
req = list(map(int, input().split()))
m = int(input())

start = 0
end = max(req) # 예산 요청 중 가장 큰 값

# binary search
result = 0
while start <= end:
    budget = 0
    mid = (start + end) // 2
    
    for x in req: 
        if x <= mid: # 가능 예산(mid) 보다 작으면 원래 요청 값으로 더하기
            budget += x
        else: budget += mid # 더 크면 가능 예산 더하기
            
    if budget <= m: # 총 예산이 m보다 작으면
        result = mid # result값 넣어놓고
        start = mid + 1 # start값 조정(가능 예산을 더 올려도 되기 때문에)
    else:
        end = mid - 1;
        
print(result)