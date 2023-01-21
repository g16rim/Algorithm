n = int(input())
sol = list(map(int, input().split()))
sol.sort()

start = 0
end = n-1
Min = abs(sol[start] + sol[end])
result = [sol[start], sol[end]]

while start < end:
    temp = sol[start] + sol[end]
    
    if abs(temp) < Min:
        result = [sol[start], sol[end]]
        Min = abs(temp)
        if Min == 0: break
        
    if temp > 0:
        end -= 1
    else:
        start += 1
        
print(result[0], result[1])

# Min: 두 용액의 합의 0으로부터 거리(절대값)
# temp: 두 용액의 합
