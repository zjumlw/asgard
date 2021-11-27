package com.will.asgard.algo.leetcode;

/**
 * @Description 211. 添加与搜索单词 - 数据结构设计 medium
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *  
 *
 * 提示：
 *
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-11-25 4:15 下午
 * @Version 1.0
 **/
public class Problem211 {
    class WordDictionary {

        class Node {
            private boolean isWord;
            // 都是字母表示，可以用数组
            private Node[] next;

            public Node(boolean isWord) {
                this.isWord = isWord;
                next = new Node[26];
            }

            public Node() {
                this(false);
            }
        }

        private Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node curNode = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Node next = curNode.next[c - 'a'];
                if (next == null) {
                    curNode.next[c - 'a'] = new Node();
                }
                curNode = curNode.next[c - 'a'];
            }
            if (!curNode.isWord) {
                curNode.isWord = true;
            }
        }

        // 递归调用match
        public boolean search(String word) {
            return match(word, root, 0);
        }

        private boolean match(String word, Node node, int start) {
            // 终止条件
            if (start == word.length()) {
                return node.isWord;
            }
            char alpha = word.charAt(start);
            if (alpha == '.') {
                for (int i = 0; i < 26; i++) {
                    if (node.next[i] != null && match(word, node.next[i], start + 1)) {
                        // 有一个匹配就成功
                        return true;
                    }
                }
                // 没有匹配到
                return false;
            } else {
                if (node.next[alpha - 'a'] == null) {
                    return false;
                }
                return match(word, node.next[alpha - 'a'], start + 1);
            }
        }
    }
}
