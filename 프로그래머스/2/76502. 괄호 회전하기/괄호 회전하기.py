from collections import deque

def solution(s):
    answer = 0
    d = deque(s)
    for _ in range(len(d)): # rotate
        stack = deque()
        for i in range(len(d)):       
            if d[i] in '[({':
                stack.append(d[i])
            elif d[i] in '])}':
                if not stack:
                    break
                last = stack.pop()
                if (last == '[' and d[i] != ']') or (last == '(' and d[i] != ')') or (last == '{' and d[i] != '}'): # 
                    break
            if i == len(d)-1 and not stack:
                answer += 1
        d.rotate(-1)
    return answer 