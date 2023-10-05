package algorithms.graph

import java.util.*
import java.util.ArrayDeque
import kotlin.collections.HashMap
import kotlin.collections.HashSet


/**
 * Breadth first search for shortest path from [root] to [dst]
 *
 * @param root: start node
 * @param dst: end node
 * @param getAdjacent: provide adjacent nodes of [T]
 *
 * @return shortest path from [root] to [dst]
 */
fun <T> bfs(
    root: T & Any,
    dst: T & Any,
    getAdjacent: (T) -> List<T & Any>
): Set<T> {
    val visited = HashSet<T>()
    val queue: Queue<T> = ArrayDeque()
    queue.offer(root)

    val path = HashMap<T, T>()

    while (queue.isNotEmpty()) {
        val n = queue.poll()
        if (!visited.contains(n)) {
            visited.add(n)

            if (n == dst) return visited

            for (nn in getAdjacent(n)) queue.offer(nn)
        }
    }
    return visited
}