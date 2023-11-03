def solution(want, number, discount):
    answer, temp_want = 0, []
    # temp_want: 원하는 물품을 개수 별로 넣은 뒤 정렬해 준 변수
    # zip: iterable한 객체를 인자로 받아 같이 순회한다.
    for w, num in zip(want, number):
        temp_want += [w] * num
    temp_want = sorted(temp_want)
    
    # temp_want 길이만큼만 보기
    for i in range(len(discount[:-len(temp_want)+1])):
        answer += int(temp_want == sorted(discount[i:i+len(temp_want)]))
        
    return answer