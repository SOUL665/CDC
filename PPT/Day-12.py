# Date - 15/06/26

# Answer - 1

import sys

def solve():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    n = int(input_data[0])
    arr = [int(x) for x in input_data[1:n+1]]
    insert_val = int(input_data[n+1])
    delete_val = int(input_data[n+2])
    search_val = int(input_data[n+3])
    
    inserted = False
    for i in range(len(arr)):
        if insert_val < arr[i]:
            arr.insert(i, insert_val)
            inserted = True
            break
    if not inserted:
        arr.append(insert_val)
            
    if delete_val in arr:
        arr.remove(delete_val)
            
    print("Updated array:", *arr)
        
    try:
        index = arr.index(search_val)
        print(f"Element {search_val} found at index {index}")
    except ValueError:
        print(f"Element {search_val} not found")
        
if __name__ == "__main__":
    solve()

# Answer - 2

import sys

def solve():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    n = int(input_data[0])
    arr = [int(x) for x in input_data[1:n+1]]
    k = int(input_data[n+1])
    
    found = False 
    
    def find_subsequences(index, current_path, current_sum):
        nonlocal found
        if current_sum == k:
            print(*(current_path))
            found = True
            return
        
        if current_sum > k or index == n:
            return
        
        for i in range (index, n):
            find_subsequences(i + 1, current_path + [arr[i]], current_sum + arr[i])
            
    find_subsequences(0, [], 0)
    
    if not found:
        print("No target sum")
        
if __name__ == "__main__":
    solve()
    
