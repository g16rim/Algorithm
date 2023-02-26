import sys
input = sys.stdin.readline

def f(n, mat):
    if n == 2:
        li = []
        for i in range(2):
            for j in range(2):
                li.append(mat[i][j])
        li.sort()
        return li[2]
    else:
        temp = [[] for _ in range(n//2)]
        for i in range(0, n, 2):
            for j in range(0, n, 2):
                li = [mat[i][j], mat[i][j+1], mat[i+1][j], mat[i+1][j+1]]
                li.sort()
                temp[i//2].append(li[2])
        return f(n//2, temp)

n = int(input())
mat = [list(map(int, input().split())) for _ in range(n)]

print(f(n, mat))