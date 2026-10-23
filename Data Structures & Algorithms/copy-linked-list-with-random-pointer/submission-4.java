/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Node curr = head;
        HashMap<Node, Node> org = new HashMap<>();
        while(curr != null){
            org.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        org.forEach((node, copy)-> {
            Node random = org.get(node.random);
            Node next = org.get(node.next);
            copy.next = next;
            copy.random = random;
        });
        return org.get(head);
    }
}
