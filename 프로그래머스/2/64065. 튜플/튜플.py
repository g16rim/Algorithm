from collections import Counter

def solution(s):
    elements = [] # 등장하는 모든 원소
    answer = []
    prev = 0
    for char in s:
        if char in '{},\"':
            if prev != 0:
                elements.append(prev)
            prev = 0
            continue
        prev = prev * 10 + int(char)
        
    for key, value in Counter(elements).most_common():
        # 등장 횟수(value) 순으로 내림차순
        answer.append(key)
        
    return answer