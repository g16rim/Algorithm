T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    tri = []
    for i in range(1, N + 1):
        if i == 1:
            tri.append([1])
        elif i == 2:
            tri.append([1, 1])
        else:
            temp = [1]
            for j in range(1, i-1):
                temp.append(tri[i-2][j-1]+tri[i-2][j])
            temp.append(1)
            tri.append(temp)            
            
    print('#', end='')
    print(test_case)
    for i in range(N):
        print(*tri[i])