# 红黑树
## 定义
1. 一棵二分搜索树
2. root是黑色
3. leaf(最后的空节点)是黑色
4. 节点是红色或黑色
5. 红色的左子和右子，必是黑色
6. 从任意一个节点到leaf，经过黑色的节点是一样的。参考2-3树，从任何节点到其下的叶子，路径长度必定相同。

**红黑树的平衡是：黑色节点绝对平衡**

## 2-3树性质
- 满足二分搜索树的基本定义
- 有两种节点
  - A：存放一个元素
    - 左子
    - 右子
  - B：存放两个元素
    - 左子
    - 中子
    - 右子
- 绝对平衡：从root到任意一个leaf，经过的节点数量一定相同


因此，每个节点有二个，或者三个节点，故称为2-3树
### 2-3树添加操作
2-3树的添加，永远不会向一个空的地方添加节点
1. 找到添加的位置
2. 先和找到的位置的节点进行融合
   - 如果融合后，是个3节点，结束
   - 如果融合后是个4节点，则拆分成左子，parent，右子
3. 如果融合后，节点是3节点
   - root: 拆分就行
   - 非root：需要将中间节点向上推。同parent融合

详见课程，[2-3树添加](https://coding.imooc.com/lesson/207.html#mid=15081)

## 红黑树与2-3树的比较
- 红黑树中的节点只有有一个元素
- 2-3树中的2节点，就是红黑树中的一个普通黑色节点
- 2-3树中的3节点，在红黑树中是2个节点
  - 由于2-3树中的3节点内的两个元素，存在大小关系，则红黑树中的这两个节点也有大小关系
  - 小的那个是孩子，大的是父亲
  - 小的节点是红色，用于指示同其父亲一起，代表2-3树中的3节点
  - 大的是黑色
- 红黑树中，所有的节点都是左倾的

**对于2-3树，应用上述方法，可以转换成红黑树**

## 时间复杂度
最大高度：2logN
- 从root到leaf，为logN
- 每个节点都有red + black，所以高度 X2

复杂度，CRUD都是O(logN)。
- 由于高度比AVL高，所以同样复杂度下，查询速度比AVL慢。
- 添加与删除，比AVL快。

## 红黑树添加操作
参考2-3树，添加节点是永远添加红色节点。
### 添加root
1. 先添加一个红色节点
2. 由于是第一个节点，设置为root。参考定义，红黑树的root必须为黑色，进行变色操作。

### 左旋转
向node的右侧，添加一个节点X，X初始为红色。  
此刻，红黑树定义被打破，需要进行左旋转。  
```
node.right = x.left
x.left = node
x.color = node.color
node.color = RED
```

### 变色 flip color
对应2-3树中的，3-node添加一个元素，然后拆分的过程  
当如下情况
- parent为BLACK
- left child和right child为RED

翻转为
- parent为RED
- left child和right child为BLACK

### 右旋转
向node的左侧添加一个新的红色节点X，node本身是红色
```
Node t = node.left
node.left = t.right
t.right = node
t.color = node.color
node.color = RED
```

### 子过程组合
当parent为Black，leftChild为Red，时
- 添加一个rightChild
  - 颜色翻转
- 添加一个leftChild的leftChild
  - 基于leftChild做右旋转
  - 颜色翻转
- 添加一个leftChild的rightChild
  - 基于leftChild做左旋转
  - 基于新的leftChild做右旋转
  - 颜色翻转

## 性能总结
- 完全的随机数据，二分搜索树很好用
- 查询较多，用AVL较好
- 插入删除较多，用红黑树较好
- 综合统计性能，红黑树最好
- TreeMap和TreeSet选用了红黑树，因为有序 + 综合性能最好

## 扩展：splay tree 伸展树
统计性能更优，相比红黑树。利用了局部性原理，突出最近被访问的数据。原理是，它认为最近刚被访问的数据，被访问的概率更高。