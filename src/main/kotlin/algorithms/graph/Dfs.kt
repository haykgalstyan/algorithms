package algorithms.graph


import java.util.ArrayDeque


/**
 * Iterative depth first search
 * Finds all the nodes reachable from [root]
 *
 * @param root: the root to explore
 * @param getAdjacent: provide adjacent nodes of [T]
 *
 * @return nodes reachable from [root]
 */
fun <T> dfs(root: T & Any, getAdjacent: (T) -> List<T & Any>): Set<T> {
    val visited = HashSet<T>()
    val stack = ArrayDeque<T>()
    stack.push(root)

    while (stack.isNotEmpty()) {
        val n = stack.pop()
        if (!visited.contains(n)) {
            visited.add(n)
            for (nn in getAdjacent(n)) stack.push(nn)
        }
    }
    return visited
}