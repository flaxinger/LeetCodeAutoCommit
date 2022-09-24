/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        return _pathSum(root, targetSum).map{it.toList()}.toList()
    }
    
    fun _pathSum(root: TreeNode?, target: Int): MutableList<MutableList<Int>> {
        if(root == null) return mutableListOf()
        root?.run {
          if(root.left == null &&
              root.right == null &&
              root.`val` == target){
            return mutableListOf(mutableListOf(root.`val`))
          }          
        }
        
        val next = target - root!!.`val`
        val res = mutableListOf<MutableList<Int>>()
        root?.run{
          root.left?.run{
            res.addAll(_pathSum(root.left, next))
          }
          root.right?.run{
            res.addAll(_pathSum(root.right, next))
          }
        }
        for(r in res){
          r.add(0, root.`val`)
        }
        return res
    }
}