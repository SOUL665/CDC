# Date - 13/07/26
# Day 60

# Answer - 1

import collections 

def solve():
    import sys 
    input_data = list(map(int, sys.stdin.read().split()))
    
    board_size = 30
    jumps = {}
    
    for i in range(0, 16, 2):
        jumps[input_data[i]] = input_data[i+1]
        
    queue = collections.deque([(1, 0)])
    visited = {1}
    
    while queue:
        curr, dist = queue.popleft()
        
        if curr == board_size:
            print(f"Min Dice throws required is {dist}")
            return
            
        for dice in range(1, 7):
            next_pos = curr + dice
            if next_pos <= board_size:
                actual_pos = jumps.get(next_pos, next_pos)
                if actual_pos not in visited:
                    visited.add(actual_pos)
                    queue.append((actual_pos, dist + 1))
                
solve()


# Answer - 2

import sys 

def iterative_dfs(adj, start_node, n):
    visited = [False] * n
    stack = [start_node]
    result = []
     
    while stack:
        node = stack.pop()
        
        if not visited[node]:
            visited[node] = True
            result.append(str(node))
            
            for neighbor in reversed(sorted(adj[node])):
                if not visited[neighbor]:
                    stack.append(neighbor)
                    
    print(" ".join(result))
    
def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    n = int(input_data[0])
    e = int(input_data[1])
    
    adj = [[] for _ in range(n)]
    idx = 2
    for _ in range(e):
        u = int(input_data[idx])
        v = int(input_data[idx + 1])
        adj[u].append(v)
        idx += 2
        
    start_node = int(input_data[idx])
    
    iterative_dfs(adj, start_node, n)
    
if __name__ == "__main__":
    main()
