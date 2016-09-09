/*
package letcode.BinaryTree;

import java.util.HashSet;

*/
/**
 * Created by RI01796 on 2016/8/1.
 *//*

/// <summary>
/// 二叉树节点
/// </summary>
/// <typeparam name="K"></typeparam>
/// <typeparam name="V"></typeparam>
public class BinaryNode<K, V> {

    /// <summary>
    /// 节点元素
    /// </summary>
    public K key;

    /// <summary>
    /// 节点中的附加值
    /// </summary>
    public HashSet<V> attach = new HashSet<V>();

    /// <summary>
    /// 左节点
    /// </summary>
    public BinaryNode<K, V> left;

    /// <summary>
    /// 右节点
    /// </summary>
    public BinaryNode<K, V> right;

    public BinaryNode() {
    }

    public BinaryNode(K key, V value, BinaryNode<K, V> left, BinaryNode<K, V> right) {
        //KV键值对
        this.key = key;
        this.attach.add(value);

        this.left = left;
        this.right = right;
    }

    //region 添加操作
    /// <summary>
    /// 添加操作
    /// </summary>
    /// <param name="key"></param>
    /// <param name="value"></param>
    public void Add(K key, V value)
    {
    }
       // #endregion

//        #region 添加操作
    /// <summary>
    /// 添加操作
    /// </summary>
    /// <param name="key"></param>
    /// <param name="value"></param>
    /// <param name="tree"></param>
    /// <returns></returns>
    public BinaryNode<K, V> Add(K key, V value, BinaryNode<K, V> tree)
    {
        if (tree == null)
            tree = new BinaryNode<K, V>(key, value, null, null);

        //左子树
        if (key.CompareTo(tree.key) < 0)
            tree.left = Add(key, value, tree.left);

        //右子树
        if (key.CompareTo(tree.key) > 0)
            tree.right = Add(key, value, tree.right);

        //将value追加到附加值中（也可对应重复元素）
        if (key.CompareTo(tree.key) == 0)
            tree.attach.add(value);

        return tree;
    }
      //  #endregion
}*/
