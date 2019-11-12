//Iterative Solution using two stacks
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer>  result = new ArrayList<Integer>();
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        Stack<TreeNode> subtreeStack = new Stack<TreeNode>();
        TreeNode curr = root;
        if(curr==null)
            return result;
        else{
               
            do{
                
                if(subtreeStack.search(curr)==-1){
                    subtreeStack.push(curr);
                }
                
                while(curr.right!=null && treeStack.search(curr.right)==-1){
                    curr = curr.right;
                    subtreeStack.push(curr);
                                       
                }
                treeStack.push(subtreeStack.pop());
                //System.out.println("Pushed "+treeStack.peek().val+" to treeStack");
                if(curr.left==null){
                    
                    if(!subtreeStack.empty())
                        curr = subtreeStack.peek();
                    else
                        break;
                }
                else{
                    curr = curr.left;
                }
                
            }while(!subtreeStack.empty() || curr!=null);
            
            while(!treeStack.empty()){
                result.add(treeStack.pop().val);
            }
            
            return result;
        }
    }
}


//Simple Recursive solution

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer>  result = new ArrayList<Integer>();
        if(root==null)
            return result;
        else{
            if(root.left!=null)
                result.addAll(inorderTraversal(root.left));
            result.add(root.val);

            if(root.right!=null)
                result.addAll(inorderTraversal(root.right));

            return result;
        }
    }
}
