def solution(elements):
    answer = set(elements)
    for count in range(2, len(elements) + 1):
        for i in range(len(elements)):
            answer.add(sum(elements[:count]))
            elements.append(elements[0])
            elements.remove(elements[0])
    return len(answer)

# 중복 값이 들어가지 않는 set 자료형 사용
# count: 연속 부분 수열의 길이