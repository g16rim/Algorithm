def solution(n):
    answer = 0
    
    binary = bin(n)[2:]
    count = 0
    for b in binary:
        if b == '1':
            count += 1
    
    for i in range(n+1, 1000001):
        binary = bin(i)[2:]
        temp = 0
        for b in binary:
            if b == '1':
                temp += 1
        if temp == count:
            answer = i
            break
    
    return answer