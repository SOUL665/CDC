# Date - 13/06/26

# Answer - 1

class BTreeNode:
    def __init__(self , leaf = False):
        self.leaf = leaf
        self.keys = []
        self.children = []
        
class BTree:
    def __init__(self , t):
        self.root = BTreeNode(True)
        self.t = t
        
    def insert(self , k):
        root = self.root
        if len(root.keys) == 2 * self.t - 1:
            temp = BTreeNode()
            self.root = temp
            temp.children.insert(0 , root)
            self.split_child(temp , 0)
            self.insert_non_full(temp , k)
        else:
            self.insert_non_full(root , k)
            
    def insert_non_full(self , x , k):
        i = len(x.keys) - 1
        if x.leaf:
            x.keys.append(0)
            while i >= 0 and k < x.keys[i]:
                x.keys[i + 1] = x.keys[i]
                i -= 1
            x.keys[i + 1] = k
        else:
            while i >= 0 and k < x.keys[i]:
                i -= 1
            i += 1
            if len(x.children[i].keys) == 2 * self.t - 1:
                self.split_child(x , i)
                if k > x.keys[i]:
                    i += 1
            self.insert_non_full(x.children[i] , k)

    def split_child(self , x, i):
        t = self.t
        y = x.children[i]
        z = BTreeNode(y.leaf)
        
        x.children.insert(i + 1, z)
        x.keys.insert(i , y.keys[t - 1])
        
        z.keys = y.keys[t:(2 * t - 1)]
        y.keys = y.keys[0:(t - 1)]
        
        if not y.leaf:
            z.children = y.children[t:(2 * t)]
            y.children = y.children[0:t]
            
    def get_inorder(self):
        res = []
        self._inorder(self.root , res)
        return res
        
    def _inorder(self, x, res):
        if x is not None:
            for i in range(len(x.keys)):
                if not x.leaf:
                    self._inorder(x.children[i], res)
                res.append(x.keys[i])
            if not x.leaf:
                self._inorder(x.children[len(x.keys)], res)
                        
if __name__ == '__main__':
    import sys
    input_data = sys.stdin.read().split()
    
    if input_data:
        insert_item = int(input_data[0])
        
        btree = BTree(2)
        initial = [5, 10, 20, 25, 50]
        
        for val in initial:
            btree.insert(val)
            
        before = btree.get_inorder()
        print("The values already in B Tree are: \n" + " ".join(map(str, before)))
        
        btree.insert(insert_item)
        
        after = btree.get_inorder()
        print(f"After {insert_item} is inserted, the in-order traversal of B Tree are: \n" + " ".join(map(str, after)))


# Answer - 2

import sys

def get_inorder(index, n ,arr, inorder_list):
    if index >= n:
        return
    get_inorder(2 * index + 1, n, arr , inorder_list)
    inorder_list.append(arr[index])
    get_inorder(2 * index + 2, n, arr, inorder_list)
    
def solve():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    n = int(input_data[0])
    arr = list(map(int, input_data[1:n+1]))
    
    inorder_list = []
    get_inorder(0, n, arr, inorder_list)
    
    for val in arr:
        idx = inorder_list.index(val) 
        
        predecessor = inorder_list[idx - 1] if idx > 0 else 0
        successor = inorder_list[idx + 1] if idx < n - 1 else 0
        print(f"{val} : {predecessor}, {successor}")

if __name__ == "__main__":
    solve()
