package tutorials.leetcode


fun main() {
    val threeNode = ThreeNode(1, ThreeNode(2, null, null), ThreeNode(4))
    val threeNode1 = ThreeNode(1, ThreeNode(2, null, null), ThreeNode(4))
    val sameTree = _SameTree()
    val result = sameTree.sameThree(threeNode, threeNode1)
    println(result)
}

internal class _SameTree {
    fun sameThree(left: ThreeNode?, right: ThreeNode?): Boolean {
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