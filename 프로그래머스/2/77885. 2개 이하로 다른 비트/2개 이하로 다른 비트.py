def solution(numbers):
    answer = []
    
    def cal(n): # 최하위 0->1, 그 다음 비트 0으로 만들기
        last = (~n) & (n+1)
        return (n|last) & ~(last>>1)
    
    for num in numbers:
        if num%2 == 0:
            answer.append(num+1)
        else:
            answer.append(cal(num))
            
    return answer

# 1 최하위비트 구하는 식: n & -n
# n & ~n+1
# ~n & n+1
#   n = 0111
#  ~n = 1000
# n+1 = 1000
# ~n & n+1 = 1000 <- 가장 오른쪽에 있는 0의 위치 알려준다