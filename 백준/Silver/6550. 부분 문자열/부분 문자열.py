import sys
input = sys.stdin.readline

while True:
    str = input().rstrip()
    if not str:
        break
    s, t = str.split()
    
    idx = 0
    answer = 'No'
    for i in range(len(t)):
        if s[idx] == t[i]:
            idx += 1
        if idx == len(s):
            answer = 'Yes'
            break
        
    print(answer)