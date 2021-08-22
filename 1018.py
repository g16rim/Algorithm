def checkWB(list):
    count = 0
    WB = ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B']
    for i in range(8):
        if list[i] != WB[i]:
            count += 1
    return count

def checkBW(list):
    count = 0
    BW = ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W']
    for i in range(8):
        if list[i] != BW[i]:
            count += 1
    return count

N, M = map(int, input().split())
# 선언과 동시에 2차원 배열 입력받기
board = [input() for _ in range(N)]
result = 64

# 시작 위치 찾는 이중 for문
for i in range(N + 1 - 8):
    for j in range(M + 1 - 8):
        temp = 0
        if board[i][j] == 'W':
            for k in range(i, i + 7, 2):
                temp += checkWB(board[k][j:j+8])
                temp += checkBW(board[k + 1][j:j+8])
        else:
            for k in range(i, i + 7, 2):
                temp += checkBW(board[k][j:j+8])
                temp += checkWB(board[k + 1][j:j+8])
        
        if result > temp:
            result = temp

print(result)