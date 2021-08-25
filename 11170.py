# 0의 개수

T = int(input())
for _ in range(T):
    N, M = map(int, input().split())
    result = 0
    for tc in range(N, M + 1):
        tc = str(tc)
        for i in range(len(tc)):
            if tc[i] == '0':
                result += 1
    print(result)