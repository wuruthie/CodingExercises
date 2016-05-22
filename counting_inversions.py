
count = 0
def merging(first_array, second_array):
	i = 0
	j = 0
	global count
	sorted_array = []

# while both arrays are non-empty
	while i < len(first_array) and j < len(second_array):
		if first_array[i] < second_array[j]:
				sorted_array.append(first_array[i])
				i = i + 1
		else:
				sorted_array.append(second_array[j])
				count += len(first_array[i:])
				j = j + 1

# when one array becomes empty

	if i == len(first_array):
		sorted_array.extend(second_array[j:])
	else:
		sorted_array.extend(first_array[i:])

	return sorted_array, count


"""
Here you can define functions you want to use
within function counting_inversions(array).
"""
def counting_inversions(array):
	"""
	Please put your code here.
	"""
	if len(array) is 1:
		return array, 0 #because no inversions
	#else...resursively sort
	middle = len(array) / 2
	left = counting_inversions(array[:middle])[0] #there's a lot of mess here. make it zero to ignore the inversions in between
	right = counting_inversions(array[middle:])[0]
	sortedlist = merging(left,right)
	return sortedlist




A = [2,1,5,3]
# print the num
print counting_inversions(A)
