class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DetectLoop {
    
    // Function to detect loop using Floyd's Cycle Detection algorithm
    static boolean hasLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move by 1
            fast = fast.next.next;      // move by 2

            if (slow == fast) {
                return true;            // loop detected
            }
        }

        return false; // no loop
    }

    public static void main(String[] args) {
        // Create a linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create a loop for testing
        head.next.next.next.next.next = head.next.next; // 5 -> 3 (loop)

        if (hasLoop(head))
            System.out.println("Loop detected in the linked list");
        else
            System.out.println("No loop found in the linked list");
    }
}
