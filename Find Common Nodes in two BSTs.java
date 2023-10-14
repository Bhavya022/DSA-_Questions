class Solution
{
    //Function to find the nodes that are common in both BST.
	public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
        //code here 
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Node> s1 = new Stack<Node> ();  
        Stack<Node> s2 = new Stack<Node> (); 
        
        while(true)
        {
            if(root1!=null)
            {
                s1.push(root1);  
                root1 = root1.left;  
            }
            else if(root2!=null)
            {
                s2.push(root2);  
                root2 = root2.left;
            }
            //compare the peek values- 3 more nested if else
            else if (!s1.isEmpty() && !s2.isEmpty())
            {
                root1 = s1.peek();  
                root2 = s2.peek(); 
                
                if (root1.data == root2.data)  
                {
                     res.add(root1.data);
                    s1.pop();  
                    s2.pop();  
      
                    root1 = root1.right;  
                    root2 = root2.right;  
                
                }
                else if (root1.data < root2.data)  
                // pop smaller and move right(as in order)- since asc, we can get higher nodes to compare
                {
                    s1.pop();  
                    root1 = root1.right;  
                    root2 = null;  //settin null here cause we need nodes from root1
                }
                else if (root1.data > root2.data)  
                {
                    s2.pop();  
                    root2 = root2.right; 
                    root1 = null;  //settin null here cause we need nodes from root2
                }
            
            }
            else //means one of the stack has become empty
            break;
        }
        return res;
    
    }
}
