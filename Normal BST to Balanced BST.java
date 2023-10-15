class GfG
{   
     ArrayList<Node> nodes = new ArrayList<>();

    void storeInorder(Node root) {
        if (root == null)
            return;

        storeInorder(root.left);
        nodes.add(root);
        storeInorder(root.right);
    }

    Node sortedArrayToBST(int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        Node node = nodes.get(mid);

        node.left = sortedArrayToBST(start, mid - 1);
        node.right = sortedArrayToBST(mid + 1, end);

        return node;
    }
    Node buildBalancedTree(Node root) 
    {
        //Add your code here. 
         // Step 1: Store the nodes in an ArrayList in sorted order (in-order traversal).
        storeInorder(root);

        // Step 2: Convert the sorted nodes into a balanced BST.
        int n = nodes.size();
        return sortedArrayToBST(0, n - 1);
    }
}
