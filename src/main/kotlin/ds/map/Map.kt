package ds.map

interface Map<K, V> {

    fun put(key: K, value: V)

    fun get(key: K): V

    fun contains(key: K): V

    fun delete(key: K): V

    fun isEmpty(): Boolean
}