year = int(input())
bool = False

if year % 400 == 0:
   bool = True

if year % 4 == 0:
    if year % 100 != 0:
        bool = True

if bool == True:
    print(1)
else:
    print(0) 