def solution(n, words):
    answer = []

    size = len(words)
    for i in range(1, size):
        if words[i-1][-1] != words[i][0]: # 끝말잇기 조건 탈락
            answer.append(i % n + 1)
            answer.append(i // n + 1)
            return answer
        for j in range(i): # 중복 탈락
            if words[i] == words[j]:
                print(i, j)
                answer.append(i % n + 1)
                answer.append(i // n + 1)
                return answer

    return [0, 0]