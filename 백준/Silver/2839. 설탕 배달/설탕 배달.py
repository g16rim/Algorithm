n = int(input())
result = 0

# 5의 배수 최대 -> 3의 배수 
five = n // 5
three = (n - five * 5) // 3

# print(five, three)

while n > 0:
    if n - (five * 5 + three * 3) == 0:
        result = five + three
        break
    elif five <= 0 and (three * 3 > n or (three + 1) * 3 > n):
        result = -1
        break
    else:
        five = five - 1
        if five < 0:
            five = 0
        three = (n - five * 5) // 3
    
print(result)