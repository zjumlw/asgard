package com.will.asgard.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 138. 复制带随机指针的链表 medium
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 *
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 *  
 *
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 *
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 *
 * 示例 4：
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *
 * 提示：
 * 0 <= n <= 1000
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2021-07-22 10:10 下午
 * @Version 1.0
 **/
public class Problem138 {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node pHead = head;
        Node copyDummy = new Node(-1);
        Node pCopy = copyDummy;

        Map<Node, Integer> originNodeToIndex = new HashMap<>();
        Map<Integer, Node> indexToCopyNode = new HashMap<>();

        // 其实可以不用 index，直接存 Node 即可
        int index = 0;
        // 先线性复制 next 逻辑
        while (pHead != null) {
            originNodeToIndex.put(pHead, index);
            // 更新 pCopy
            pCopy.next = new Node(pHead.val);
            pCopy = pCopy.next;
            indexToCopyNode.put(index, pCopy);
            // 往下遍历
            pHead = pHead.next;
            index++;
        }

        // 重新回到头部
        pHead = head;
        pCopy = copyDummy.next;
        while (pHead != null) {
            if (pHead.random != null) {
                int idx = originNodeToIndex.get(pHead.random);
                Node copyRandom = indexToCopyNode.get(idx);
                pCopy.random = copyRandom;
            }

            pHead = pHead.next;
            pCopy = pCopy.next;
        }

        return copyDummy.next;
    }

    private Map<Node, Node> cacheNode = new HashMap<>();
    public Node copyRandomListV2(Node head) {
        if (head == null) {
            return null;
        }
        if (!cacheNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cacheNode.put(head, headNew);
            headNew.next = copyRandomListV2(head.next);
            headNew.random = copyRandomListV2(head.random);
        }

        return cacheNode.get(head);
    }

    public Node copyRandomListV3(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        HashMap<Node,Node> map = new HashMap<>();
        while(cur!=null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur=head;
        while(cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }

    // 增加后继节点
    public Node copyRandomListV4(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node head = node1;
        printNode(head);

        Problem138 problem138 = new Problem138();
        Node copy = problem138.copyRandomList(head);
        System.out.println("========");
        printNode(copy);
    }

    private static void printNode(Node head) {
        if (head == null) {
            System.out.println("null");
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (head != null) {
            if (sb.length() != 0) {
                sb.append("->");
            }
            sb.append(head.val);
            sb2.append(head.val).append("->").append(head.random != null ? head.random.val : "null").append("\n");

            head = head.next;
        }


        System.out.println(sb);
        System.out.println(sb2);
    }
}
