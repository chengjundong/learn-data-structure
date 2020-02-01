# 二分搜索树 Binary Search Tree
## 二叉树定义
* 具有唯一根节点
* 每个节点最多，有一个左子，一个右子
* 左子，也叫前驱，predecessor
* 右子，也叫后继，successor
* 没有子节点的为叶子节点
* 每个节点最多一个父节点
* 具有天然递归结构，**树操作大部分需要递归**

## 二分搜索树定义
* 是一颗二叉树
* 每个节点的值，必须大于左子树所有的节点
* 每个节点的值，必须小于右子树所有的节点
* 存储的数据有可比较性
* 可以不包含重复元素

## 插入
1. node == null, return new Node(input)
2. node.value > input, 递归right，并挂入right
3. node.value < input, 递归left，并挂入left
4. 记录每个node的深度
5. 对于每次添加，与当前树的深度作比较，如果较大，修改树的深度

## 查询
二分法查找，递归运算
* 基本问题:  node为空，false；node的值匹配，true
* 更小的问题：根据node的值与输入值的比较，递归左子或者右子

## 遍历
### 前序遍历
相对来说，最常用，最基本的访问方式  
遍历顺序：中间节点 -> 左子树 -> 右子树  
### 中序遍历
**可以用于从小到大排序**  
遍历顺序：左子树 -> 中间节点 -> 右子树  
### 后序遍历
应用场景：释放树的内存，从低向上，操作之后将内存释放  
遍历顺序：左子树->右子树->中间节点
### 辨别前，中，后序
递归访问中，每个节点一共有三次被访问机会。节点的读取只会发生在其中任意一次。
1. 初次访问
2. 访问节点左子返回后
3. 访问节点右子返回后

判断是二叉搜索树的遍历顺序，就看每个节点的值在哪次访问的时候被读取
1. 初次访问 - 读取 - 前序
2. 访问节点左子返回后 - 读取 - 中序
3. 访问节点右子返回后 - 读取 - 后序

### 非递归实现前序遍历
需要使用栈，基本操作顺序如下：
1. push root -> stack
2. stack.pop; access node.value
3. push node.right -> stack if exists
4. push node.left -> stack if exists
5. repeat 2 ~ 4 until stack is empty

### 层序遍历
一层一层的遍历树 ，使用队列实现
1. enqueue root
2. dequeue & access value
3. enqueue node.left if exists
4. enqueue node.right if exists
5. repeat 2 ~ 4 until queue is empty

### 深度优先遍历
前，中，后序遍历属于深度优先遍历，会access到最底层，然后逐级向上返回
### 广度优先遍历
层序遍历，实际应用：最短路径搜索

## 删除
### 查找最小值
从root开始，向左搜索，直到某个node的left为null，那么这个node就是最小值
### 删除最小值
- 如果最小值是叶子，直接删除
- 如果最小值还有右子树，删除后，将右子树替换到它的位置

### 最大值
从root开始，向右搜索，直到某个node的right为null，那么这个node就是最大值
### 删除最大值
- 叶子，直接删除
- 有左子树，删除后，将左子树替换它的位置

### 删除任意节点
```
IF n.left == null
	THEN remove n & return n.right
ELSE IF n.right == null
	THEN remove n & return n.left
ELSE
	do hibbard deletion
```
#### Hibbard Deletion
在二叉搜索树中，当要删除的节点，既有左子，又有右子的时候。删除步骤如下：
1. 找到要删除的节点N
2. 找到N的右子树的最小值的节点X
3. 记录并删除X
4. 创建一个新节点M，M.value = X.value
5. 将N的左右子树都挂在M上
6. 删除N
7. 返回M

*参考，[Hibbard Deletion](https://www.ucloud.cn/yun/77241.html)*

## 其他操作
### floor & ceil
在二分搜索树中，找某个值的floor和celi
- floor：比该值小的最大的数
- ceil：比该值大的最小的数

### rank & select
- rank: 找出排名为N的数字是多少？
- select: 找出某个值的排名 

### node.size
- 某个节点的子节点的数量

### node.depth
- 某个节点的深度

### node.count
- 支持重复数据
- 当有重复数据的时候，增加count，删除时，减少count
- 当count为0时，需要删除节点