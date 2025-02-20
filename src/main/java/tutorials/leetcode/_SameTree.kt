package tutorials.leetcode

import tutorials.TreeNode


fun main() {
    val treeNode = TreeNode(
        1,
        TreeNode(2, null, null),
        TreeNode(4)
    )
    val treeNode1 = TreeNode(
        1,
        TreeNode(2, null, null),
        TreeNode(4)
    )
    val sameTree = _SameTree()
    val result = sameTree.sameThree(treeNode, treeNode1)
    println(result)
}

internal class _SameTree {
    fun sameThree(left: TreeNode?, right: TreeNode?): Boolean {
        if (left != null && right != null) {
            val isEqualValue = left.value == right.value

            return if (isEqualValue) {
                return sameThree(left.left, right.left) && sameThree(left.right, right.right)
            } else {
                false
            }

        } else if (left == null && right == null) {
            return true
        }
        return false
    }
}