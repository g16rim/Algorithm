k, n = map(int, input().split())
line = []
for _ in range(k):
    line.append(int(input()))

start = 1
end = max(line) # 최소 길이가 아니라 최대 길이를 기준으로 잡아야 함
# 반례
# 2 4 
# 100
# 1 

while start <= end:
    mid = (start+end) // 2
    temp = 0
    
    for i in range(k):
        temp += line[i] // mid
        
    if temp < n:
        end = mid-1
    else:
        start = mid+1
        answer = mid
        
print(answer)