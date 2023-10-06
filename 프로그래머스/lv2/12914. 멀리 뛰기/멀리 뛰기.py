import math

def solution(n):
    answer = 1
    end = math.ceil(n / 2)
    one = n-2 # 1의 개수
    two = 1 # 2의 개수
    for i in range(n-1, end-1, -1):
        # / -> //로 수정해서 런타임 에러(오버플로우) 해결
        # / 연산 결과 float
        # // 연산 결과 int
        answer += math.factorial(one+two) // (math.factorial(one)*math.factorial(two))
        one -= 2
        two += 1
    return answer % 1234567

def factorial(n):
    ret = 1
    for i in range(1, n+1):
        ret *= i
    return ret

#     6개
#     1 1 1 1 1 1 * 1
#     2 1 1 1 1 * 5 5!/4!1!
#     2 2 1 1 * 6 4!/2!2!
#     2 2 2 * 1
   
#     7개
#     1 1 1 1 1 1 1 * 1
#     2 1 1 1 1 1 * 6 6!/5!1!
#     2 2 1 1 1 * 5!/3!2!
#     2 2 2 1 * 4!/1!3!