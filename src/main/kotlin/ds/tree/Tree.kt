package ds.tree

interface Tree<K, V> {

    fun insert(key: K, value: V)

    fun get(key: K): V?

    fun delete(key: K)

}