package algorithms.search

import ds.graph.Graph
import java.util.ArrayDeque


/**
 * Recursive depth first search
 */
fun <T> dfsR(root: T, getAdjacent: (T) -> Set<T>) {

}


/**
 * Iterative depth first search
 * @param roots: A set of roots to explore
 * @return a set of roots reachable from [roots]
 */
fun <T> dfs(roots: Set<T>, getAdjacent: (T) -> Set<T>): Set<T> {
    val visited = HashSet<T>()
    val stack = ArrayDeque(roots)
    while (stack.isNotEmpty()) {
        val n = stack.pop()
        if (!visited.contains(n)) {
            visited.add(n)
            for (nn in getAdjacent(n)) { // HashSet iteration is
                stack.push(nn)
            }
        }
    }
    return visited
}