from collections import deque

n = int(input())
q = deque()
for i in range(1, n+1):
    q.append(i)
toggle = 0

while q:
    if len(q) == 1:
        print(q[0])
        break
    if toggle == 0:
        q.popleft()
        toggle = 1
    else:
        q.append(q.popleft())
        toggle = 0