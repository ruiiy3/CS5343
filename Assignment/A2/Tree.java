class Node {
    int val;
    Node left;
    Node right;
    Node parent;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

public class Tree {

    public Node insert(Node head, int val) {
        Node n = new Node(val);
        if(head == null) {
            head = n;
            head.parent = head;
            return head;
        }
        Node cur = head;
        if(cur.val > val) {
            if(cur.left == null) {
                cur.left = n;
                n.parent = cur;
            }
            else
                insert(cur.left, val);
        }
        else {
            if(cur.right == null) {
                cur.right = n;
                n.parent = cur;
            }
            else
                insert(cur.right, val);
        }
        return head;


    }

    public Node delete(Node root, int val) {
        Node cur = root;

        while(cur != null) {
            if(cur.val == val) {
                if(cur.left == null && cur.right == null) {
                    if(cur.parent.right != null && cur.parent.right.val == val )
                        cur.parent.right = null;
                    //else if(cur.parent.left != null && cur.parent.left.val == val)
                    else
                        cur.parent.left = null;
                }

                else if(cur.right == null && cur.left != null) {
                    cur.parent.right = cur.left;
                }

                else if(cur.right != null){
                    int suc = successor(cur);
                    cur.val = suc;
                }
                break;
            }
            else if(cur.val > val)
                cur = cur.left;
            else
                cur = cur.right;

        }
        return root;
    }
    /*
    public int predecessor(Node n) {
        Node cur = n.left;
        while(cur.right != null)
            cur = cur.left;
        if(cur.left == null) {
            cur.parent.right = null;
        }
        else {
            cur.parent.right = cur.left;
        }
        return cur.val;

    } */

    //find the successor of the delete node, return the value of the successor
    public int successor(Node n) {
        //if its a successor, there is no left child
        //two possible, leaf node, or has right child
        Node cur = n.right;
        //if cur.right is a leaf node
        if(cur.left == null && cur.right == null) {
            n.right = null;
            return cur.val;
        }
        //find the smallest node
        while(cur.left != null)
            cur = cur.left;

        if(cur.right == null) {
            cur.parent.left = null;
        }
        else {
            cur.parent.left = cur.right;
        }
        return cur.val;
    }
    public void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        //System.out.println(root.val + " " + root.parent.val);
        inorder(root.right);
    }
    public static void main(String[] args) throws Exception {
        Tree bst = new Tree();
        Node root = null;
        int[] data = {40, 60, 20, 80, 50, 10, 30, 15, 5, 35, 25, 45, 55, 70, 90, 32, 33, 48, 46};

        for(int i = 0; i < data.length; i++) {
            root = bst.insert(root, data[i]);
        }
        //first loop
        bst.inorder(root);
        System.out.println(" ");

        //delete use successor
        bst.delete(root,40);
        bst.inorder(root);
        System.out.println(" ");

        //
        bst.delete(root,20);
        bst.inorder(root);
    }
}
