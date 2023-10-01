package ds.map.hashtable

import ds.map.Map

/**
 * Hashtable implementation
 *
 * Hash function requirements:
 * - Efficient computation
 * - Even distribution
 *
 * Hashcode requirements:
 * - Hash codes should be equal if objects are equal
 * - Highly desirable: hash codes not equal if objects not equal
 * Good hash codes try to involve all the data in hashing.
 *
 * Hashcodes can be negative:
 * Most ways of coming up with a hash code naturally end up with negative values,
 * so they are perfectly valid, however we need positive numbers for array indices.
 * In java/kotlin there is a remainder operator %, which is not the same as modulo,
 * and it does return negative result.
 * So separate conversion to positive is needed despite the usage of modulo.
 * But [Math.abs] will return a negative value in case of [Integer.MIN_VALUE],
 * which is a possibility, for example in case of "polygenelubricants".hashCode()
 * Another approach that is typically used for this is masking to remove the sign bit.
 * key.hashCode() & Integer.MAX_VALUE
 *
 * Modding the hashcode with the table size,
 * will produce a number between 0 and tableSize -1.
 *
 * Working hash function:
 * (key.hashCode() & Integer.MAX_VALUE) % tableSize
 * where tableSize is a power of 2 or a prime number.
 *
 */
class HashTable<K, V> : Map<K, V> {

    override fun put(key: K, value: V) {
        TODO("Not yet implemented")
    }

    override fun get(key: K): V? {
        TODO("Not yet implemented")
    }

    override fun delete(key: K) {
        TODO("Not yet implemented")
    }

    override fun contains(key: K): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }
}