def solution(citations): 
    citations.sort(reverse=True)
    for h in range(citations[0], 0, -1):
        up = 0
        down = 0
        for citation in citations:
            if citation >= h:
                up += 1
            else:
                down += 1
        if up >= h and down <= h:
            return h
    return 0 # [0, 0, 0, 0, 0, 0] 0