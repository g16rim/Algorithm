from collections import Counter

def solution(k, tangerine):
    answer = 0
    counts = []
    for key, value in Counter(tangerine).most_common():
        # Counter().most_common()
        # [key, value] 형태로 빈도 수 내림차순으로 정렬
        counts.append(value)
    temp = 0
    for i in range(len(counts)):
        temp += counts[i]
        answer += 1
        if temp >= k:
            return answer