def solution(s):
    answer = 0
    
    # 파이썬 stack - list 사용
    stack = [s[0]]
    
    for i in range(1, len(s)):
        if len(stack) > 0 and s[i] == stack[-1]: # 파이썬 stack top - list[-1]
            stack.pop() # 파이썬 stack pop - pop한 값 return도 해줌
        else:
            stack.append(s[i])
    
    if len(stack) == 0:
        answer = 1
    
    return answer