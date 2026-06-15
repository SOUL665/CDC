# Date = 11/06/26

# Answer - 1

class Node:
    def __init__(self , pages):
        self.pages = pages
        self.next = None
        
class PrintQueue:
    def __init__(self):
        self.head =  None
        self.tail = None
        
    def enqueue(self , pages):
        new_node = Node(pages)
        if not self.head:
            self.head = new_node
            self.tail = new_node
            
        else:
            self.tail.next = new_node
            self.tail = new_node
        print(f"Print job with {pages} pages is enqueued.")
        
        def dequeue(self):
            if not self.head:
                print("Queue is empty.")
            else:
                print(f"Processing print job: {self.head.pages} pages")
                self.head = self.head.next
                if not self.head:
                    self.tail = None
                    
        def dequeue(self):
            if  not self.head:
                print("Queue is empty.")
            else:
                print(f"Processing print job:{self.head.pages} pages")
                self.head = self.head.next
                if not self.head:
                    self.tail = None
        def display(self):
            if not self.head:
                print("Queue is empty.")
            else:
                temp = self.head
                print("Print jobs in the queue:", end="")
                while temp:
                    print(f"{temp.pages} pages", end="")
                    temp = temp.next
                print()
        
        def main():
            queue = PrintQueue
            
            try:
                while True:
                    option = int(input())
                    
                    if option == 1:
                        pages = int(input())
                        queue.enqueue(pages)
                        
                    elif option == 2:
                        queue.dequeue()
                        
                    elif option == 3:
                        queue.display()
                    
                    else:
                        print("Invalid option.")
                        
            except EOFError:
                pass
                    
        if __name__ == "__main__":
            main()
