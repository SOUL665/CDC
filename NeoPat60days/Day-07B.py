# Fundamentals

# Answer - 1

import sys 

def solve():
    line = sys.stdin.readline()
    if not line:
        return
    n = int(line.strip())
    
    for i in range(n , 0 , -1):
        stars = "*" * i
        spaces = " " * (n-i)
        print(stars + spaces + spaces + stars.strip())
        
    for i in range(1, n+1):
        stars = "*" * i
        spaces = " " * (n-i)
        print(stars + spaces + spaces + stars.strip())
        
if __name__ == "__main__":
    solve()


# Answer - 2

import sys

def solve():
    data = sys.stdin.read().split()
    if not data: return
    n = int(data[0])
    
    for i in range(1, n+1):
        row = " ".join(["*"]*i)
        leading = " " * (n-i)
        if i < n:
            gap = " " * ((n-i)*2)
            print(leading + row + gap + row)
        else:
            print(row + " " + row)
if __name__ == "__main__":
    solve()
