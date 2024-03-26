def balance(s : str, m : int) -> bool :
	c = 0
	for val in s:
		if val == "<":
			c+=1
		elif val == ">":
			c-=1
			if c<0:
				if m>0:
					m-=1
					c+=1
				elif m<=0:
					break
	return c==0
def balancedOrNot(exp : list[str], changes : list[int]):
	return [1 if balance(e,m) else 0 for e,m in zip(exp, changes)]


s="<>"
s="<><><<<>>><><"
s=""
s=">>"
s_arr = ["<>", "<><><<<>>><><", "", ">>"]
substitutions_arr = [0, 1, 1, 3]
for e, m in zip(s_arr, substitutions_arr):
	print(e, m)
print(balance(s, 2))
print(balancedOrNot(s_arr, substitutions_arr))