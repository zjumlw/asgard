package com.will.asgard.loki.model.interview.jdk.collection.hashmap.jdk7;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static sun.misc.VM.isBooted;

/**
 * @Description JDK7 HashMap 实现
 * @Author maolingwei
 * @Date 2020-06-25 10:48 下午
 * @Version 1.0
 */
class HashMap<K, V> extends AbstractMap<K,V>
        implements Map<K,V>, Cloneable, Serializable {

    // 默认初始化容量16
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    // 最大容量2的30次方
    static final int MAXIMUM_CAPACITY = 1 << 30;

    // 默认负载因子0.75
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    // 当数组表还没有扩容的时候，一个共享的空表对象
    static final Entry<?,?>[] EMPTY_TABLE = {};

    // threshold最大值
    static final int ALTERNATIVE_HASHING_THRESHOLD_DEFAULT = Integer.MAX_VALUE;

    static class Entry<K, V> implements Map.Entry<K,V> {
        final K key;
        V value;
        Entry<K, V> next;
        int hash;

        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        // 判断传入节点与此结点的“key”和“value”是否相等。都相等则返回true
        public final boolean equals(Object o) {
            if (! (o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry e = (Map.Entry) o;
            Object k1 = getKey();
            Object k2 = e.getKey();
            if (Objects.equals(k1, k2)) {
                Object v1 = getValue();
                Object v2 = e.getValue();
                if (Objects.equals(v1, v2)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }

        // 每当相同key的value被覆盖时被调用一次，在HashMap的子类LinkedHashMap中实现了这个方法
        void recordAccess(HashMap<K, V> m) {
        }

        // 每移除一个entry就被调用一次，在HashMap的子类LinkedHashMap中实现了这个方法；
        void recordRemoval(HashMap<K,V> m) {
        }
    }

    // 数组用于存放Entry对象，大小只能是2的n次方
    @SuppressWarnings("unchecked")
    transient Entry<K, V>[] table = (Entry<K, V>[]) EMPTY_TABLE;

    // 已使用的数组位置的个数，判断是否需要扩容
    transient int size;

    // 扩容的临界点，一般为 capacity*loadFactor
    int threshold;

    // 由构造函数传入的指定负载因子
    final float loadFactor;

    // HashMap的修改次数
    // 如果在迭代的过程中HashMap被其他线程修改了,modCount的数值就会发生变化,
    // 这时候expectedModCount和ModCount不相等,迭代器就会抛出ConcurrentModificationException()异常
    transient int modCount;

    // 对哈希值的散列优化产生影响
    transient int hashSeed = 0;

    public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }

        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }

        this.loadFactor = loadFactor;
        /*
         * 此时并不会创建容器，因为没有传具体值。
         * 当下次传具体值的时候，才会“根据这次的初始容量”，创建一个内部数组。
         * 所以此次的初始容量只是作为下一次扩容（新建）的容量。
         */
        threshold = initialCapacity;
        init();
    }

    public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public HashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(Map<? extends K, ? extends V> m) {
        // 生成空数组，并指定扩容值
        this((int) Math.max(m.size() / DEFAULT_LOAD_FACTOR + 1, DEFAULT_INITIAL_CAPACITY), DEFAULT_LOAD_FACTOR);
        // 由于此时数组为空，所以使用“扩容临界值”新建一个数组
        inflateTable(threshold);
        // 将传入map的键值对添加到初始数组中
        putAllForCreate(m);
    }

    void init() {
    }

    @SuppressWarnings("unchecked")
    private void inflateTable(int toSize) {
        // 内部数组的大小必须是2的n次方，所以要找到“大于”toSize的“最小的2的n次方”。
        int capacity = roundUpToPowerOf2(toSize);
        // 下次扩容临界值
        threshold = (int) Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);
        table = new Entry[capacity];
        initHashSeedAsNeeded(capacity);
    }

    private static int roundUpToPowerOf2(int number) {
        return number >= MAXIMUM_CAPACITY
                ? MAXIMUM_CAPACITY
                : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1; // (number - 1) << 1 保证了最高位的1
    }

    /**
     * 根据内部数组长度初始化hashseed
     * @param capacity 内部数组长度
     * @return hashSeed是否初始化
     */
    final boolean initHashSeedAsNeeded(int capacity) {
        boolean currentAltHashing = hashSeed != 0;
        boolean userAltHashing = isBooted() && (capacity >= Holder.ALTERNATIVE_HASHING_THRESHOLD);
        boolean switching = currentAltHashing ^ userAltHashing;
        // 为true则赋初始化值
        if (switching) {
            // randomHashSeed 方法在 1.7 中才存在
//            hashSeed = userAltHashing
//                    ? sun.misc.Hashing.randomHashSeed(this)
//                    : 0;
        }
        return switching;
    }

    private static class Holder {
        /**
         * 容量阈值，初始化hashSeed的时候会用到该值
         */
        static final int ALTERNATIVE_HASHING_THRESHOLD;

        static {
            // 获取系统变量jdk.map.althashing.threshold
            String altThreshold = java.security.AccessController.doPrivileged(
                    new sun.security.action.GetPropertyAction(
                            "jdk.map.althashing.threshold"));

            int threshold;
            try {
                threshold = (null != altThreshold)
                        ? Integer.parseInt(altThreshold)
                        : ALTERNATIVE_HASHING_THRESHOLD_DEFAULT;
                if (threshold == -1) {
                    threshold = Integer.MAX_VALUE;
                }
                if (threshold < 0) {
                    throw new IllegalArgumentException("value must be positive integer.");
                }
            } catch (IllegalArgumentException failed) {
                throw new Error("Illegal value for 'jdk.map.althashing.threshold'", failed);
            }

            ALTERNATIVE_HASHING_THRESHOLD = threshold;
        }
    }

    private void putAllForCreate(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            putForCreate(entry.getKey(), entry.getValue());
        }
    }

    /**
     * 数组中每一项存的都是一个链表，
     * 先找到i位置，然后循环该位置上的每一个entry，
     * 如果发现存在key与传入key相等，则替换其value。然后结束方法。
     * 如果没有找到相同的key，则继续执行下一条指令，将此键值对存入链表头
     */
    private void putForCreate(K key, V value) {
        int hash = key == null ? 0 : hash(key);
        int i = indexFor(hash, table.length);
        for (Entry<K, V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash
                    && ((k = e.key) == key || (key != null && key.equals(k)))) {
                e.value = value;
                return;
            }
        }
        // 将该键值对存入指定下标的链表头中
        createEntry(hash, key, value, i);
    }

    int hash(Object k) {
        int h = hashSeed;
//        if (0 != h && k instanceof String) {
//            return sun.misc.Hashing.stringHash32((String) k);
//        }
        h ^= k.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * 返回hash值的索引，采用除模取余法，h & (length-1)操作 等价于 hash % length操作， 但&操作性能更优
     * 根据key的hash值与数组长度，找到该key在table数组中的下标
     * @param h hash值
     * @param length 数组长度
     * @return 下标
     */
    static int indexFor(int h, int length) {
        //除模取余,相当于hash % length，&速度更快
        return h & (length-1);
    }

    /**
     * 将键值对与他的hash值作为一个entry，插入table的指定下标中的链表头中
     * @param hash hash值
     * @param key 键值名
     * @param value 键值
     * @param bucketIndex 被插入的下标
     */
    void createEntry(int hash, K key, V value, int bucketIndex) {
        Entry<K, V> e = table[bucketIndex];
        // 头插法
        table[bucketIndex] = new Entry<>(hash, key, value, e);
        size++;
    }

    @Override
    public V put(K key, V value) {
        if (table == EMPTY_TABLE) {
            inflateTable(threshold);
        }

        if (key == null) {
            return putForNullKey(value);
        }
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        /*
         * 数组中每一项存的都是一个链表，
         * 先找到i位置，然后循环该位置上的每一个entry，
         * 如果发现存在key与传入key相等，则替换其value。然后结束侧方法。
         * 如果没有找到相同的key，则继续执行下一条指令，将此键值对存入链表头
         */
        for (Entry<K, V> e = table[i]; e != null; e = e.next) {
            Object k = null;
            if ((e.hash == hash) && ((k = e.key) == key) || key.equals(k)) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        modCount++;
        // 查看是否需要扩容，并将该键值对存入指定下标的链表头中
        addEntry(hash, key, value, i);
        return null;
    }

    /**
     * 如果key为null，则将其value存入table[0]的链表中 todo
     * @param value 键值
     * @return 如果覆盖了旧value，则返回value，否则返回null
     */
    private V putForNullKey(V value) {
        for (Entry<K, V> entry = table[0]; entry != null; entry = entry.next) {
            if (entry.key == null) {
                V oldValue = entry.value;
                entry.value = value;
                entry.recordAccess(this);
                return oldValue;
            }
        }
        modCount++;
        addEntry(0, null, value, 0);
        return null;
    }

    void addEntry(int hash, K key, V value, int bucketIndex) {
        // 如果当前键值对数量达到了临界值，且目标table下标不存在，则扩容table
        if ((size >= threshold) && null != table[bucketIndex]) {
            System.out.println("key=" + key + ", value=" + value + ", bucketIndex=" + bucketIndex + " resize to " + 2 * table.length);
            resize(2 * table.length);
            // 由于数组扩容了，所以需要重新计算下标
            hash = key == null ? 0 : hash(key);
            bucketIndex = indexFor(hash, table.length);
        }
        createEntry(hash, key, value, bucketIndex);
    }

    /**
     * 对数组扩容，即创建一个新数组，并将旧数组里的东西重新存入新数组
     * @param newCapacity 新数组容量
     */
    void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable, initHashSeedAsNeeded(newCapacity));
        table = newTable;
        threshold = (int) Math.min(newCapacity * loadFactor, MAXIMUM_CAPACITY + 1);
    }

    void transfer(Entry[] newTable, boolean rehash) {
        int newCapacity = newTable.length;
        for (Entry<K, V> e : table) {
            while (null != e) {
                Entry<K, V> next = e.next;
                if (rehash) {
                    e.hash = null == e.key ? 0 : hash(e.key);
                }
                int i = indexFor(e.hash, newCapacity);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }
    }

    public int size() {
        return size;
    }

    public V get(Object key) {
        if (key == null) {
            return getForNullKey();
        }
        Entry<K, V> entry = getEntry(key);
        return null == entry ? null : entry.getValue();
    }

    private V getForNullKey() {
        if (size == 0) {
            return null;
        }
        for (Entry<K, V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                return e.value;
            }
        }
        return null;
    }

    final Entry<K, V> getEntry(Object key) {
        if (size == 0) {
            return null;
        }
        int hash = null == key ? 0 : hash(key);
        for (Entry<K, V> e = table[indexFor(hash, table.length)];
             e != null;
             e = e.next) {
            Object k = null;
            if (e.hash == hash && ((k = e.key) == key) || (key != null && key.equals(k))) {
                return e;
            }
        }
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

}
