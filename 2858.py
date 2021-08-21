# 완전 탐색
# 기숙사 바닥

R, B = map(int, input().split())
L = 1
W = 1

for W in range(1, R+B):
    if (R + B) % W == 0:
        L = int((R + B) / W)
        if ((L - 2) * (W - 2)) == B:
            L = max(L, W)
            W = min(L, W)
            break

print(L, end = ' ')
print(W) 