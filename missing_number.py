"""
A full binary search tree is a binary search tree where all the levels are full.
Such a tree of k levels contains 2^k -1  nodes.
Let's suppose that the tree contains different integers from the interval [1, 2^k],
that is one number is missing.

Your task is to write a code to find this missing number in O(k) steps.

The tree is given by a tuple, where the first member of the tuple is
the number being in the root and
the second number of the tuple is an array, where array[i] is a list:
- if i+1 is the missing number then this list is empty
- if i+1 is a leaf then the list is [0, 0]
- if i+1 is an inner node then  the list is [left_child, right_child].

In your code you may suppose that the input array represents a non-empty,
valid full binary search tree.
"""

A = (3, [[0, 0], [], [1, 4], [0, 0]])
B = (4, [[0, 0], [1, 3], [0, 0], [2, 6], [0, 0], [5, 7], [0, 0], []])
C = (8, [[0, 0], [1, 3], [0, 0], [2, 6], [0, 0], [5, 7], [0, 0], [4, 13], [], [0, 0], [10, 12], [0, 0]
, [11, 15], [0, 0], [14, 16], [0, 0]])

def missing_number(input):
    root = input[0]
    tree = input[1]
    current = root
    leaf = [0,0]

    while tree[current-1] != leaf:
        if root % 2 != 0: #if the root is odd, go to left subtree
            root = tree[current-1][0] #update new root
            current = root
        else:
            root = tree[current-1][1] #else, explore right subtree
            current = root
    return root + 1, root -1 #tuple containing possible missing numbers

def right_missing_number(array, roots): #determines the correct root to return by checking the indice returns an empty []
    low = roots[1]
    high = roots[0]
    tree = array[1]

    if tree[low -1] == []:
        return low
    else:
        return high

print(right_missing_number(A, missing_number(A)))
print(right_missing_number(B, missing_number(B)))
print(right_missing_number(C, missing_number(C)))
