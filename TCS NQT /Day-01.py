# Date - 16/07/26

# Answer - 1

r = int(input())
c = int(input())

matrix = [list(map(int, input().split())) for _ in range(r)]

max_row = max(sum(row) for row in matrix)

max_col = max(sum(matrix[i][j] for i in range(r)) for j in range(c))

print(max_row + max_col)

# Answer - 2

v = int(input())
w = int(input())

if 20 <= v <= 10**9 and 50 <= w <= 10**9 and w % 2 == 0 and v < w:
    fw = (w - 2 * v) // 2
    tw = v - fw
    
    if tw >= 0 and fw >= 0:
        print(f"TW= {tw} FW= {fw}")
    else:
        print("INVALID INPUT")
else:
    print("INVALID INPUT")

# Answer - 3

a = input().strip()
b = input().strip()

c = ""
for char in a:
    if char not in b:
        c += char

print(c)
