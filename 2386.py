# 완전 탐색, 문자열

while True:
    str = input() # 문자열 입력
    lst = list(str) # 배열로 변환
    result = 0

    if lst[0] == '#':
        break

    for i in range(2, len(lst)):
        if lst[0] == lst[i] or lst[0].upper() == lst[i]:
            result += 1
    print(lst[0], end = ' ')
    print(result)