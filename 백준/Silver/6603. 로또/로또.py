import sys
input = sys.stdin.readline

def bt(idx, temp):
    if len(temp) == 6:
        print(*temp)
        return
    
    for i in range(idx, len(tc)):
        temp.append(tc[i])
        bt(i+1, temp)
        temp.pop()
        
        
while True:
    tc = list(map(int, input().split()))
    if tc[0] == 0:
        exit()
    del tc[0]
    bt(0, [])
    print()