package ds.map


interface Map<K, V> {

    fun put(key: K, value: V)

    fun get(key: K): V?

    fun delete(key: K)

    fun contains(key: K): Boolean

    fun isEmpty(): Boolean
}