n = list(input())
n.sort(reverse = True)
answer = ''

# answer: 현재 있는 숫자로 만들 수 있는 가장 큰 값
for x in n:
    answer += x

# 30의 배수 조건: 0이 하나 이상, 모든 자릿 수의 합이 3의 배수

if '0' in n:
    # 0이 있고, 모든 자릿 수의 합은 3의 배수인 상황
    if int(answer) % 30 == 0: 
        print(answer)
    else: # 모든 자릿 수의 합이 3의 배수가 아님 -> 절대 30의 배수가 될 수 없음
        print(-1)
else: # 0이 없음
    print(-1)