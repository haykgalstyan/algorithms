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
    val visited = HashMap<T, T>()
    val queue: Queue<T> = ArrayDeque()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val n = queue.poll()
        if (!visited.contains(n)) {
            visited.put(n, )

            if (n == dst) return visited

            for (nn in getAdjacent(n)) queue.offer(nn)
        }
    }
    return visited
}
//https://stackoverflow.com/questions/8379785/how-does-a-breadth-first-search-work-when-looking-for-shortest-path