/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.math.*;
public class Codec {
    
    private ArrayList<String> arr;    
    String[] arr_build;
    HashMap<BigInteger, Integer> map;
        
    private void preorder(TreeNode node, BigInteger idx){

        arr.add(idx+"."+String.valueOf(node.val));
        if(node.left!=null) preorder(node.left, idx.multiply(new BigInteger("2")));
        if(node.right!=null) preorder(node.right, idx.multiply(new BigInteger("2")).add(new BigInteger("1")));
        
    }

    private TreeNode build(BigInteger idx){
        
        if(!map.containsKey(idx)) return null;
        TreeNode a = new TreeNode(map.get(idx));
        a.left = build(idx.multiply(new BigInteger("2")));
        a.right = build(idx.multiply(new BigInteger("2")).add(new BigInteger("1")));
        return a;
    }
    
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        arr = new ArrayList<String>();
        preorder(root, new BigInteger("1"));
        return arr.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data == "") return null;
        map = new HashMap<BigInteger, Integer>();
        data = data.replace("[", "");
        data = data.replace("]", "");
        arr_build = data.split(", ");
        System.out.println(data);
        
        for(String buff: arr_build){
            BigInteger ee = new BigInteger(buff.substring(0, buff.indexOf(".")));
            System.out.println(ee);
            map.put(ee, Integer.valueOf(buff.substring(buff.indexOf(".")+1)));
        }
        
        return build(new BigInteger("1"));
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));