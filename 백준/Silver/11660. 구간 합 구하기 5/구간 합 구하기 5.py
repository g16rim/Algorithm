import sys
input = sys.stdin.readline

n, m = map(int, input().split())
a = [0]
Sum = [[0] * (n+1) for _ in range(n+1)]

for _ in range(n): # 원본 배열 만들기
    a_row = [0] + list(map(int, input().split()))
    a.append(a_row)

for i in range(1, n+1): # 합 배열 만들기
    for j in range(1, n+1):
        Sum[i][j] = Sum[i-1][j] + Sum[i][j-1] - Sum[i-1][j-1] + a[i][j]

for _ in range(m): # 구간 합 출력
    x1, y1, x2, y2 = map(int, input().split())
    print(Sum[x2][y2] - Sum[x1-1][y2] - Sum[x2][y1-1] + Sum[x1-1][y1-1])