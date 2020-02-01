# 集合与映射 Set & Map
## 集合 Set
集合中的元素是不重复的，不要求有序  
应用场景举例：统计一篇文章中的词汇量
### 基本操作
- add - 不能添加重复元素
- remove
- contains

### 基于二分搜索树的集合实现
- add -> BST.add -> O(logn)
- remove -> BST.remove -> O(logn)
- contains -> BST.contains -> O(logn)

对于满二叉树，每一层都是2的次方，如果有h层，则节点的总数N = 2^h - 1  
由此可得，h = log2(N+1)，即时间复杂度为O(logN)  
**对于对数log的时间复杂度来说，底数是多少影响不大，因此忽略不计。只需要知道是对数关系即可**

### 基于链表的集合实现
- add -> linkedlist.add -> O(n)
- remove -> linkedlist.remove -> O(n)
- contains -> linkedlist.contains -> O(n)

## 映射 Map
每个元素都是一个键值对（Key-Value）
### 基本操作
- put(K, V)
- V remove(K)
- boolean contains(K)
- V get(K)
- void set(K, V)
- int getSize()
- boolean isEmpty()

### 基于链表实现
需要一个新的数据结构，Entry。本身是一个Key-Value，并且对于Entry的equals判断需要改写为：仅当key相同，就可以认为相同。
- put(K, V) -> list.add if not contains -> O(n)
- V remove(K) -> list.remove if found -> O(n)
- boolean contains(K) -> list.contains -> O(n)
- V get(K) -> list.getByValue, leverage `equals` method -> O(n)
- void set(K, V) -> list.getByValue, then change the value of entry -> O(n)
- int getSize()
- boolean isEmpty()

### 基于二分搜索树实现
- put(K, V) -> tree.add if not contains -> O(logn)
- V remove(K) -> tree.remove if found -> O(logn)
- boolean contains(K) -> tree.contains -> O(logn)
- V get(K) -> tree.getByValue, leverage `equals` method -> O(logn)
- void set(K, V) -> tree.getByValue, then change the value of entry -> O(logn)
- int getSize()
- boolean isEmpty()