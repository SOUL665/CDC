# Date - 16/06/26

# Answer - 1

import sys

def solve():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    n = int(input_data[0])
    ids = [int(x) for x in input_data[1:n+1]]
    
    for i in range (0, n - 1, 2):
        ids[i], ids[i+1] = ids[i+1], ids[i]
        
    output = ""
    for id_val in ids:
        output += str(id_val) + "->"
    output += "NULL"
    
    print(output)
    
if __name__ == "__main__":
    solve()


# Answer - 2

import sys

def solve():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    t = int(input_data[0])
    tasks = [int(x) for x in input_data[1:t+1]]
    p = int(input_data[t+1])
    
    tasks.pop(0)
    print(*(tasks))
    
    tasks.pop(-1)
    print(*(tasks))
    
    if 0 <= p < len(tasks):
        tasks.pop(p)
    print(*(tasks))
    
if __name__ == "__main__":
    solve()
