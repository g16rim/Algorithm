# 0이 2개 이상 연속으로 있는 부분 몇 개
# 1이 2개 이상 연속으로 있는 부분 몇 개
s = input()
result = [0] * 2

for i in range(1, len(s)):
    if s[i-1] != s[i]:
        if s[i-1] == '0':
            result[0] += 1
        else:
            result[1] += 1
    if i == (len(s)-1): 
        if s[i-1] == s[i]:
            if s[i-1] == '0':
                result[0] += 1
            else:
                result[1] += 1
        else: # 맨 마지막 자리 하나만 다를 경우
            if s[i] == '0':
                result[0] += 1
            else:
                result[1] += 1

print(min(result))