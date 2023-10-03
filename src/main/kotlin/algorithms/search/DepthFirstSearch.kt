package algorithms.search

import java.util.ArrayDeque


/**
 * Recursive depth first search
 * Simpler than iterative versions, same complexity, but probably slower in practice.
 *
 * @param root: the root to explore
 * @param getAdjacent: Provide adjacent nodes of [T]
 * @param visited: already visited nodes, calm down and pass an empty [HashSet]
 * the resulting visited nodes will be in this hashmap.
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


/**
 * Iterative depth first search
 *
 * @param root: the root to explore
 * @param getAdjacent: Provide adjacent nodes of [T]
 *
 * @return nodes reachable from [root]
 *
 * Iterative version uses a stack for to-process nodes.
 * While the stack is not empty, the algorithm pops a node and
 * visits its adjacent nodes if they are not in a hashset of visited nodes.
 */
fun <T> dfsI(root: T & Any, getAdjacent: (T) -> List<T>): Set<T> {
    if (getAdjacent(root).isEmpty()) return emptySet()

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


/**
 * Iterative depth first search
 * This versions uses sets in the API.
 *
 * @param roots: A set of roots to explore
 * @param getAdjacent: Provide adjacent nodes of [T]
 *
 * @return set of nodes reachable from [roots]
 *
 * Iterative version uses a stack for to-process nodes.
 * While the stack is not empty, the algorithm pops a node and
 * visits its adjacent nodes if they are not in a hashset of visited nodes.
 *
 * Note:
 * In this version of [getAdjacent], if a [HashSet] is passed,
 * iteration over it would not have the best time complexity.
 */
fun <T> dfsISets(roots: Set<T>, getAdjacent: (T) -> Set<T & Any>): Set<T> {
    val visited = HashSet<T>()
    val stack = ArrayDeque(roots)
    while (stack.isNotEmpty()) {
        val n = stack.pop()
        if (!visited.contains(n)) {
            visited.add(n)
            for (nn in getAdjacent(n)) stack.push(nn)
        }
    }
    return visited
}