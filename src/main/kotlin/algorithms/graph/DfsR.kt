package algorithms.graph


/**
 * Recursive depth first search
 * Finds all the nodes reachable from [root]
 *
 * @param root: the root to explore
 * @param getAdjacent: provide adjacent nodes of [T]
 *
 * @param visited: nodes reachable from [root]
 */
fun <T> dfsR(
    root: T,
    visited: HashSet<T>,
    getAdjacent: (T) -> Set<T>,
) {
    val adjacent = getAdjacent(root)
    if (adjacent.isEmpty()) return
    for (n in adjacent)
        if (!visited.contains(n)) {
            visited.add(n)
            dfsR(n, visited, getAdjacent)
        }
}