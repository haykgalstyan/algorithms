package algorithms.graph

import java.util.*
import kotlin.collections.HashSet


/**
 * Iterative breadth first search
 * Finds all the nodes reachable from [root]
 *
 * @param root: the root to explore
 * @param getAdjacent: provide adjacent nodes of [T]
 *
 * @return nodes reachable from [root]
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