n = int(input())
Sum, result, start_index, end_index = 1, 1, 1, 1

while end_index != n:
    if Sum == n:
        result += 1
        end_index += 1
        Sum += end_index
    elif Sum < n:
        end_index += 1
        Sum += end_index
    else:
        Sum -= start_index
        start_index += 1

print(result)