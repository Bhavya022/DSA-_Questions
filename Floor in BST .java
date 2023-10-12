class Solution {
    public static int floor(Node root, int key) {
        // Code here
         if (root == null)
            return -1; // Return -1 to indicate that there is no floor value for the key.

        if (root.data == key)
            return root.data;

        if (root.data > key)
            return floor(root.left, key);

        int floorValue = floor(root.right, key);

        // If a valid floor is found in the right subtree, return it.
        if (floorValue != -1)
            return floorValue;

        // Otherwise, return the root.data as the floor value.
        return root.data;
    }
}
