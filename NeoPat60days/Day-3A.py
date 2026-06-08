import sys

def solve():
    input_data = sys.stdin.read().split()
    if not imput_data:
        return
    
    n = int(intput_data[0])
    elements = list(map(int,input_data[1:n+1]))
    k = int(input_data[n+1])
    
    if n ==0:
        return
    
    k = k%n
    if k == 0:
        print(*(elements))
        return
    
    pivot = n - k
    rotated = elements[pivot:]+elements[:pivot]
    print(*rotated)
    
    if __name__ == "__main__":
        solve()      
