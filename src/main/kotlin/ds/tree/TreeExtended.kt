package ds.tree

interface TreeExtended<K, V> : Tree<K, V> {

    fun size(): Int

    fun index(key: K): Int

    fun min(): V?

    fun deleteMin()

    fun max(): V?

    fun deleteMax()

    fun floor(key: K): V?

    fun ceil(key: K): V?

    fun keys(): Iterable<K>
}