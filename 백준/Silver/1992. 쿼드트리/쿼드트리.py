def rec(n, x, y):
    color = video[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if color != video[i][j]:
                color = -1
                break

    if color == 1:
        print(1, end="")
    elif color == 0:
        print(0, end="")
    else: # 재귀가 필요한 상황
        print("(", end="")
        n = n // 2 # 범위 반으로 줄이기
        rec(n, x, y)
        rec(n, x, y+n)
        rec(n, x+n, y)
        rec(n, x+n, y+n)
        print(")", end="")
        
n = int(input())
video = [list(map(int, input())) for _ in range(n)]
rec(n, 0, 0)