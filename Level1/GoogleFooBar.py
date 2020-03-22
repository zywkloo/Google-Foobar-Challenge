def solution(x):
        # Your code here
	retStr=''
	for i in range (len(x)):
		if 'a' <= x[i] <= 'z':
			retStr += chr(ord('a') + 25 - ord(x[i]) + ord('a') )
		else :
			retStr += x[i]
    
	print(retStr)
	# return retStr
# print(solution("wrw blf hvv ozhg mrtsg'h vkrhlwv?"))
