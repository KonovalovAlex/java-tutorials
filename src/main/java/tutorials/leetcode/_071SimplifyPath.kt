package tutorials.leetcode


class _SimplifyPath {
    fun simplifyPath(path: String): String {
        val stk: ArrayDeque<String> = ArrayDeque()
        for (s in path.split("/").dropLastWhile { it.isEmpty() }.toTypedArray()) {
            if ("" == s || "." == s) {
                continue
            }
            if (".." == s) {
                stk.removeLast()
            } else {
                stk.addLast(s)
            }
        }
        return "/" + java.lang.String.join("/", stk)
    }
}