import sys

m = int(input())
S = set()

for _ in range(m):
    # comm = list(input().split())
    comm = sys.stdin.readline().strip().split()
    
    if len(comm) == 1:
        if comm[0] == 'all': # all
            S = set([i for i in range(1, 21)])
        else: # empty
            S = set()
    else:
        func, x = comm[0], int(comm[1])
        if func == 'add':
            S.add(x)
        elif func == 'remove':
            S.discard(x) # 삭제할 요소가 없으면 무시
            # remove()는 에러 발생
        elif func == 'check':
            if x in S:
                print(1)
            else:
                print(0)
        elif func == 'toggle':
            if x in S:
                S.discard(x)
            else:
                S.add(x)