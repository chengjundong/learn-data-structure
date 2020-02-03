# 堆 heap
## 满二叉树和完全二叉树
- 满二叉树：除了leaf，所有node都有left和right
- 完全二叉树：将元素一层一层从左到右排列，缺失的node在右下角处

## 二叉堆
- 首先是一棵完全二叉树
- 最大堆: node永远大于left和right
- 最小堆: node永远小于left和right
- 不用管非直系节点之间的数据大小关系

## 数组实现二叉堆
由于二叉堆是按层，将所有元素从左到右码放。因此，我们可以采用数组来实现。

**index从1开始，比较方便**  

- parent.index = child.index / 2
- left-child.index = parent.index * 2
- right-child.index = parent.index * 2 + 1

**index从0开始，也是可以**

- parent.index = (child.index - 1) / 2
- left-child.index = parent.index * 2 + 1
- right-child.index = parent.index * 2 + 2

## 二叉堆的添加操作 add
需要使用到sift-up，上浮操作，基本操作如下：

1. 向数组中添加一个元素 X
2. 将元素X的parent index计算出来
3. 得到元素X的parent，并与X比较
	- parent >= X，结束
	- parent < X，交换parent与X
4. 重复2 ~ 3步骤
	- 要么，X的parent大于X
	- 或者，X是堆顶

## 二叉堆的提取操作 extract
需要使用sift-down，下沉，基本操作如下：

1. 将数组中index=0的元素，即堆顶，取出
2. 将数组的最后一个元素X删除并保存其值
3. 将X放入堆顶
4. 取X的left和right，与其中的最大值比较
	- X >= MAX(X.left, X.right); 结束
	- X < MAX(X.left, X.right); 二者交换
5. 重复第4步，直到：
	- 要么，X >= MAX(X.left, X.right)
	- 或者，X没有child了
	
## 时间复杂度
- add O(logn)
- extract O(logn)

并且，完全二叉树不会退化为链表，即不可能永远在一遍放入元素  
所以时间复杂度O(logn)不会退化为O(n)

## replace
1. 将堆顶元素替换为新元素X
2. 对X执行sift-down
3. 时间复杂度 O(logn)

## heapify
将任意数组变成堆有两种方法：
- 直接将数字逐个插入，时间复杂度为O(nlogn)
- heapify，时间复杂度为O(n)

heapify具体步骤：

1. 找到数组中最后一个元素的parent X
2. 从X开始，到堆顶为止，对所有元素进行sift-down

# 优先队列
- 普通队列：FIFO
- 优先队列：出队顺序与入队顺序无关，同优先级有关

## 优先队列的底层实现分析
1. 普通线性结构
	- 入队 O(1)
	- 出队 O(n)
2. 顺序线性结构
	- 入队 O(n)
	- 出队 O(1)
3. 堆
	- 入队 O(logn)
	- 出队 O(logn)
	
## 基于最大堆实现的优先队列
- enqueue: heap.add; O(logn)
- dequeue: heap.extract; O(logn)
- front: heap.peek; O(1)

## D叉堆
parent有D个children，在sift-down的时候，需要与所有子节点比较

## 索引堆
可以查看堆中的其他元素，不仅仅是堆顶  
