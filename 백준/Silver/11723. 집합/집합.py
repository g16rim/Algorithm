import sys

M = int(sys.stdin.readline())
mySet = set()

for _ in range(M):
    command = sys.stdin.readline().strip().split()

    if len(command) == 1:
        if command[0] == 'all':
            mySet = set([i for i in range(1, 21)])
        else:
            mySet = set()
    else:
        func, x = command[0], int(command[1])
        if func == 'add':
            mySet.add(x)
        elif func == 'remove':
            mySet.discard(x) # 삭제할 요소가 없으면 무시
            # remove()는 에러 발생
        elif func == 'check':
            if x in mySet:
                print(1)
            else:
                print(0)
        elif func == 'toggle':
            if x in mySet:
                mySet.discard(x)
            else:
                mySet.add(x)