package algorithms.search

import java.util.*
import kotlin.collections.HashSet


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
fun <T> bfs(root: T & Any, getAdjacent: (T) -> List<T & Any>): Set<T> {
    val visited = HashSet<T>()
    val queue: Queue<T> = ArrayDeque()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val n = queue.poll()
        if (!visited.contains(n)) {
            visited.add(n)
            for (nn in getAdjacent(n)) queue.offer(nn)
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
fun <T> bfsISets(roots: Set<T>, getAdjacent: (T) -> Set<T & Any>): Set<T> {
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