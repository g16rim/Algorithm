def solution(people, limit):
    answer = 0
    people.sort(reverse=True)
    
    for p in people:
        if p + people[-1] <= limit:
            people.pop()
        answer += 1
    
    return answer