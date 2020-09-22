package com.will.asgard.loki.model.leetcode;

/**
 * @Description
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 *
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *
 * 计算监控树的所有节点所需的最小摄像头数量。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 示例 2：
 *
 *
 *
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 *
 * 提示：
 *
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-cameras
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-09-22 9:41 下午
 * @Version 1.0
 */
public class Problem968 {

    public int minCameraCover(TreeNode root) {
        int[] array = dfs(root);

        return array[1];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        int[] leftArray = dfs(root.left);
        int[] rightArray = dfs(root.right);
        int[] array = new int[3];
        array[0] = leftArray[2] + rightArray[2] + 1;
        array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], leftArray[1] + rightArray[0]));
        array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
        return array;
    }

    private static int NO_CAMERA = 0;
    private static int HAS_CAMERA = 1;
    private static int NO_NEED = 2;
    private int count = 0;

    public int minCameraCoverV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (dfsV2(root) == NO_CAMERA) {
            count++;
        }
        return count;
    }

    private int dfsV2(TreeNode root) {
        // 空结点，不需要camera
        if (root == null) {
            return NO_NEED;
        }
        int left = dfsV2(root.left);
        int right = dfsV2(root.right);
        // 左右子树至少有一个没有camera，则当前结点需要放置camera
        if (left == NO_CAMERA || right == NO_CAMERA) {
            count++;
            return HAS_CAMERA;
        }
        // 左右子树至少有一个有camera，则当前结点不需要camera，否则为结点和子结点没有被监控
        return left == HAS_CAMERA || right == HAS_CAMERA ? NO_NEED : NO_CAMERA;
    }
    public static void main(String[] args) {
        Problem968 problem968 = new Problem968();

        String data = "0,0,0,null,null,0,null,null,null";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);

        int num = problem968.minCameraCover(root);
        System.out.println(num);
    }


}
