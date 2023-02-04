graph = [[0] * 20]
for i in range(1, 20):
    graph.append([0] + list(map(int, input().split())))
    
def bfs(x, y):
    # 현재 바둑돌 색깔
    win = graph[x][y]
    
    #  아래, 오른쪽 아래 대각선, 오른쪽, 오른쪽 위 대각선
    dx = [1, 1, 0, -1]
    dy = [0, 1, 1, 1]
    
    for i in range(4):
        # 오목인지 확인할 변수
        omok = 1
        # 다음 이동할 위치
        nx = x + dx[i]
        ny = y + dy[i]
        
        # 그래프 범위 안이고 색이 같으면
        while 0 < nx < 20 and 0 < ny < 20 and graph[nx][ny] == win:
            omok += 1
            
            if omok == 5:
                # 육목이 되는지
                # 오목 시작점 윗부분
                if 0 < x-dx[i] < 20 and 0 < y-dy[i] < 20 and graph[x-dx[i]][y-dy[i]] == win:
                    break
                # 오목 끝점 아랫부분
                if 0 < nx+dx[i] < 20 and 0 < ny+dy[i] < 20 and graph[nx+dx[i]][ny+dy[i]] == win:
                    break
                
                # 오목이면
                print(win)
                print(x, y)
                exit(0)
                
            # 원래 방향대로 이동
            nx += dx[i]
            ny += dy[i]
    
for i in range(1, 20):
    for j in range(1, 20):
        if graph[i][j] != 0:
            bfs(i, j)
            
print(0)