N = int(input())
num = [i for i in range(1, N+1)]
output = ''

for n in num:
   	st = str(n)
   	cnt = st.count('3') + st.count('6') + st.count('9')
   	
   	if cnt > 0:
   	    output += ('-'*cnt + ' ')
   	else:
   	    output += (st + ' ')

print(output)