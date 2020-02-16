# AVL 树
自平衡的二分搜索树，AVL是两个发明人的名字
## 定义
- 对于任意一个节点，左右子树高度差不超过1
- 高度和节点数量是O(logn)关系
- 标注每个节点的高度
  - H(leaf) = 1
  - H(parent) = MAX(H(leftChild), H(rightChild)) + 1
- 平衡因子 = ABS(H(leftChild) - H(rightChild))
- 一旦有任意节点的平衡因子 > 1，那么整颗AVL就不再平衡

## 时间复杂度
- 所有CRUD都是O(logn)

## 旋转平衡
### 何时需要维护平衡
不平衡产生在节点改变处至root的路径上
- 插入一个节点后
- 删除一个节点后

**四种不平衡情况**
- LL 不平衡发生在左子树的左侧
  - 一次右旋转
- RR 不平衡发生在右子树的右侧
  - 一次左旋转
- LR 不平衡发生在左子树的右侧
  - 一次左旋转，变成LL
  - 再来一次右旋转
- RL 不平衡发生在右子树的左侧
  - 一次右旋转，变成RR
  - 再来一次左旋转

### 右旋转
整颗树向左倾斜
- node.balance-factor > 1
- node.left.balance-factor >= 0

旋转步骤
- tempNode = node.left.right
- node.left.right = node
- node.left = tempNode

### 左旋转
整颗树向右倾斜
- node.balance-factor < -1
- node.right.balance-factor <= 0

旋转步骤
- tempNode = node.right.left
- node.right.left = node
- node.right = tempNode

## 基于AVL的集合
- map
- set

## 性能比较
针对英文小说《葛朗台》，比较四种不同底层实现的Map在统计词频时候的性能
- 基于链表的Map
- 基于BST的Map
- 基于AVL的Map
- Java的HashMap

### 单词自然顺序统计
BST和AVL表现趋同
```
// unit is MS
linked list map: 6756
BST map: 77
AVL map: 71
JAVA hashmap: 14
```

### 单词从小到大排序后统计
可以看到，当统计目标本身是有序的时候，BST退化很严重，变成了链表
```
// unit is MS
linked list map: 14300
BST map: 35059
AVL map: 42
JAVA hashmap: 14
```

## 优化
- 当发生修改时，维护平衡可以优化。当node的高度未发生变化时，它的所有祖先节点都不需要再维护
