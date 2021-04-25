package com.will.asgard.algo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @Description p381
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 *
 * 注意: 允许出现重复元素。
 *
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * 示例:
 *
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 *
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 *
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 *
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 *
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 *
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 *
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-10-31 3:03 下午
 * @Version 1.0
 */
public class Problem381 {
    public static void main(String[] args) {
        RandomizedCollection rc = new RandomizedCollection();
        System.out.println(rc.insert(1));
        System.out.println(rc.insert(1));
        System.out.println(rc.insert(2));
        System.out.println(rc.remove(1));
        System.out.println(rc.insert(3));
        System.out.println(rc.getRandom());
        System.out.println(rc);
    }
}

class RandomizedCollection {

    private static final int DEFAULT_CAPACITY = 16;
    private int[] array;
    private int size;
    private final Random random;
    private final Map<Integer, Set<Integer>> idxMap;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        array = new int[DEFAULT_CAPACITY];
        random = new Random();
        idxMap = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        ensureCapacity();
        Set<Integer> idx = idxMap.getOrDefault(val, new HashSet<>());
        int oldCnt = idx.size();
        idx.add(size);
        idxMap.put(val, idx);

        array[size++] = val;
        return oldCnt == 0;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idxMap.containsKey(val)) {
            return false;
        }

        Set<Integer> idx = idxMap.get(val);
        Iterator<Integer> it = idx.iterator();
        int i = it.next();
        // 待删除的数移除其索引
        idx.remove(i);
        if (idx.size() == 0) {
            idxMap.remove(val);
        }

        // 待删除的数不是最后一位
        if (i != size - 1) {
            // 将待删除的数和最后一个数交换
            int lastNum = array[size - 1];
            array[i] = lastNum;
            Set<Integer> lastNumIdx = idxMap.get(lastNum);
            lastNumIdx.remove(size - 1);
            lastNumIdx.add(i);
        }

        size--;
        ensureCapacity();
        return true;
    }

    private void ensureCapacity() {
        // 数量等于容量，扩容1倍
        if (size == array.length) {
            int[] temp = new int[array.length * 2];
            System.arraycopy(array, 0, temp, 0, size);
            array = temp;
            // 数量小于容量的一般，且容量大于默认容量，缩容一半
        } else if (size < array.length / 2 && array.length > DEFAULT_CAPACITY) {
            int[] temp = new int[array.length / 2];
            System.arraycopy(array, 0, temp, 0, size);
            array = temp;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int randomIdx = random.nextInt(size);
        return array[randomIdx];
    }

    public String toString() {
        if (array == null)
            return "null";
        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(array[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}