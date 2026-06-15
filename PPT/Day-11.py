# Date - 15/06/26

# Answer - 1

import sys

def solve():
    s = sys.stdin.readline().strip()
    if not s:
        return
    
    char_counts = {}
    for char in s:
        char_counts[char] = char_counts.get(char, 0) + 1
        
    non_repeating = []
    for i, char in enumerate(s):
        if char_counts[char] == 1:
            non_repeating.append((i, char))
            
    if len(non_repeating) >= 2:
        print(f"{non_repeating[0][0]} - {non_repeating[0][1]}")
        print(f"{non_repeating[1][0]} - {non_repeating[1][1]}")
    else:
        print("-1")
        
if __name__ == "__main__":
    solve()


# Answer - 2

import sys

def solve():
    s = sys.stdin.readline().strip('\r\n')
    if not s:
        return
    
    vowels = "aeiouAEIOU"
    modified_string = ""
    count = 0
    
    for char in s:
        if char in vowels:
            count += 1
        else:
            modified_string += char
            
    print(modified_string)
    print(count)
    
if __name__ == "__main__":
    solve()
