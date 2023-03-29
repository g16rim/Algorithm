def solution(n):
    answer = 0
    for i in range(1, n//2+1):
        temp = i
        for j in range(i+1, n):
            if temp > n:
                break
            temp += j
            if temp == n:
                answer += 1
                break
    answer += 1
    return answer