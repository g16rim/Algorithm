from collections import deque

n = int(input())
q = deque(enumerate(map(int, input().split())))
# 기존 인덱스 저장을 위해 list 대신 enumerate 사용
# [(0, 3), (1, 2), (2, 1), (3, -3), (4, -1)]
result = []

while q:
    idx, val = q.popleft() # pop할 때 왼쪽으로 1칸씩 이동
    result.append(idx + 1)
    
    if val > 0:
        q.rotate(-(val - 1))
    elif val < 0:
        q.rotate(-(val))
        
print(*result)

'''
deque([(0, 3), (1, 2), (2, 1), (3, -3), (4, -1)])
deque([(3, -3), (4, -1), (1, 2), (2, 1)])
deque([(4, -1), (1, 2), (2, 1)])
deque([(2, 1), (1, 2)])
deque([(1, 2)])

rotate(-1): 반시계방향으로 1칸 회전, 왼쪽으로 1칸씩 이동
rotate(1): 시계방향으로 1칸 회전, 오른쪽으로 1칸씩 이동

인덱스가 나아가는 방향과 큐과 회전하는 방향은 서로 반대이다.
'''