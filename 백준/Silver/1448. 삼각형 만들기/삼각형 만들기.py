import sys
input = sys.stdin.readline

n = int(input())
st = [int(input()) for _ in range(n)]
st.sort(reverse=True)

for i in range(n-2):
    if st[i] < st[i+1]+st[i+2]:
        print(st[i]+st[i+1]+st[i+2])
        quit()
print(-1)