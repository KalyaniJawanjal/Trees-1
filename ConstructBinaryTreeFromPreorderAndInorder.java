//time - O(n), n-inorder.length
//space - O(n)
class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0 || inorder.length!=preorder.length) return null;
        map = new HashMap<>();
        idx = 0;
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        if(start > end){return null;}

        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        root.left = helper(preorder, inorder, start, rootIdx-1);
        root.right = helper(preorder, inorder, rootIdx+1, end);

        return root;
    }
}