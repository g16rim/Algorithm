def solution(brown, yellow):
    blocks = brown + yellow
    width = 3
    height = 1
    
    while True:
        height = blocks // width
        remainder = blocks % width
        
        if remainder == 0 and width >= height and yellow == (width-2) * (height-2):
            return [width, height]
        
        width += 1
        
        