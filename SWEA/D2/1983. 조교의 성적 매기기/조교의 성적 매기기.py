T = int(input())
grades = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']
for test_case in range(1, T + 1):
    n, k = map(int, input().split())
    scores = []
    for _ in range(n):
        scores.append(list(map(int, input().split())))

    result = []
    # 총점 계산
    for i in range(n):
        total = scores[i][0]*0.35 + scores[i][1]*0.45 + scores[i][2]*0.2
        result.append([i+1, total])
    result.sort(key = lambda x:x[1], reverse=True)

    for i in range(n):
        if result[i][0] == k:
            print('#', test_case, sep='', end=' ')
            print(grades[i//(n//10)])