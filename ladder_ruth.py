A = [True, True, False, False, True, False, True, True, True, True, False, True]
B = [True, True, True, True] #assume last step is true
C = [True, True, True]
def ladder(array):
    length = len(array) #calculate length of the array
    #initial problems: calculate paths for first three indices
    output = []
    output.append(0)

    if array[0] == True:
        output.append(1)
    else:
        output.append(0)

    if array[1] == True:
        output.append(output[1] + 1)
    else:
        output.append(0)

    if array[2] == True:
        output.append(output[2] + output[1] + 1)
    else:
        output.append(0)

    for i in range(3,length):
        if array[i] == False:
            output.append(0)
        else:
            output.append(output[i] + output[i-1] + output[i-2])
    print output
    return output[length]

print ladder(A)
print ladder(B)
print ladder(C)
