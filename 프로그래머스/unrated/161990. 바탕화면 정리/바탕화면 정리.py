def solution(wallpaper):
    # 가장 위&&왼쪽에 있는 점 찾고,
    # 가장 아래&&오른쪽에 있는 점 찾기
    minX = -1
    minY = 100
    maxX = -1
    maxY = -1
    
    for i in range(len(wallpaper)):
        index = wallpaper[i].find('#') # find vs index: find는 찾지 못하면 -1, index는 error
        if index != -1: 
            maxX = i+1 # maxX: 계속 갱신
            if minX == -1:
                minX = i # minX: 제일 처음 발견되는 곳
            if index < minY: # minY: 제일 작은 index
                minY = index
            if wallpaper[i].rfind('#') >= maxY: # maxY: 제일 큰 j
                    maxY = wallpaper[i].rfind('#')+1
            
    return [minX, minY, maxX, maxY]