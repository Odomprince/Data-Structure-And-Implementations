
public class DoublyList {
	
	
	 //head of list
	  static Node head; 
	   
	    //Doubly Linked list Node
	    class Node {
	        String data;
	        Node prev;
	        Node next;
	 
	        // Constructor to create a new node
	        // next and prev is by default to its starting  null
	        Node(String string) { data = string; }
	    }
	    
	    public static void main(String[] args) 
	    { 
	      DoublyList dll = new DoublyList();
	      dll.append("Odom Prince Gyening");
	      
	      dll.push("Odom Nana Gyening");
	      
	      dll.InsertAfter(head, "Odom Chief Gyening");
	      
	      dll.InsertAfter(DoublyList.head.next, "Odom Nina Gyening");
	      
	      dll.push("Nobody");
	      
	    System.out.println("Created family tree is: "); 
	    dll.printlist(DoublyList.head);
	     
	      
	    }
	    
	    /*Tells where the next iteration will be*/

	    public void push(String newData)
	    {
	        Node new_Node = new Node(newData);
	 
	        new_Node.next = head;
	        new_Node.prev = null;
	 
	        if (head != null)
	            head.prev = new_Node;
	        head = new_Node;
	    }
	    
	    /*Insertions iteration*/
	    
	    public void InsertAfter(Node prev_Node, String new_data)
	    {
	        if (prev_Node == null) {
	            System.out.println("The given previous node cannot be NULL ");
	            return;
	        }
	        Node new_node = new Node(new_data);
	        new_node.next = prev_Node.next;
	 
	        prev_Node.next = new_node;
	 
	      
	        new_node.prev = prev_Node;
	        if (new_node.next != null)
	            new_node.next.prev = new_node;
	    }
	    
	    void append(String string)
	    {
	        Node new_node = new Node(string);
	 
	        Node last = head; 
	 
	        new_node.next = null;
	 
	        if (head == null) {
	            new_node.prev = null;
	            head = new_node;
	            return;
	        }
	 
	        while (last.next != null)
	            last = last.next;
	 
	        last.next = new_node;
	 
	        new_node.prev = last;
	    } 
	    
	    
	    /*Delete method*/
	    static Node deleteNode(Node del)
	    {
	        // base case
	        if (head == null || del == null)
	            return null;
	 
	        // If node to be deleted is head node
	        if (head == del)
	            head = del.next;
	 
	        // Change next only if node to be 
	        // deleted is NOT the last node
	        if (del.next != null)
	            del.next.prev = del.prev;
	 
	        // Change prev only if node to be 
	        // deleted is NOT the first node
	        if (del.prev != null)
	            del.prev.next = del.next;
	 
	        del = null;
	 
	        return head;
	    }
	    /*Delete iteration*/
	    
	    static void deleteNodeAtGivenPos(int n)
	    {
	        /* if list in NULL or 
	            an invalid statement is given */
	        if (head == null || n <= 0)
	            return;
	 
	        Node current = head;
	        int i;
	 
	        /*
	        * traverse up to the node at 
	          position 'n' at the beginning
	        */
	        for (i = 1; current != null && i < n; i++)
	        {
	            current = current.next;
	        }
	         
	        // if 'n' is greater than the number of nodes in the doubly linked list
	        if (current == null)
	            return;
	 
	        // delete the node related to by 'current'
	        deleteNode(current);
	    }
	    
	    public void printlist(Node node)
	    {
	      
	        Node last = null;
	        while (node != null) {
	            System.out.print(node.data + " > ");
	            last = node;
	            node = node.next;
	        }
	      
	    }
	
	

}
