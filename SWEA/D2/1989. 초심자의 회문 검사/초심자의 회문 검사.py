T = int(input())
for test_case in range(1, T + 1):
    word = list(input())
    i = 0
    j = len(word)-1

    while i < j:
        if word[i] != word[j]:
            print('#', test_case, ' ', 0, sep='')
            break

        if j-i == 1 or j-i == 2:
            print('#', test_case, ' ', 1, sep='')
            break

        i += 1
        j -= 1