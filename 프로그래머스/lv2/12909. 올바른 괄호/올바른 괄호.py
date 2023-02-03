def solution(s):
    answer = True
        
    st = []
    for i in range(len(s)):
        if s[i] == '(':
            st.append('(')
        else:
            if len(st) == 0:
                answer = False
                break
            st.pop()
            
    if len(st) > 0:
        answer = False

    return answer