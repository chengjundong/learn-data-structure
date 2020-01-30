# 链表
## 基本特性
- 真正的动态
- 使用Node (数据+指针)串联
- 相比数组，失去了随机访问能力，需要遍历

## 基本插入操作
1. 找到需要插入位置的前驱，prev
2. 创建一个新的node
3. 将prev的next给与新建node的next
4. 将preve的next指向新建的node
5. 如果输入index为0，即在头部插入，需要特殊处理

```
// basic
Node newNode = new Node(value);
newNode.next = prev.next;
prev.next = node;

// advanced
// new Node can accept its value & its next in constructor
prev.next = new Node(value, prev.next);
```

## 虚拟头指针
为head赋值一个value为NULL的Node即可

## 删除操作
1. 找到要删除的index的prev
2. prev.next即为target
3. 将target的next给与prev.next。此时target就被踢出了list
4. 最后将target的next设置为null，断开与list的链接，等待被回收

## 时间复杂度分析
1. addLast - O(n) - need iterate
2. addFirst - O(1)
3. add - O(n) - need iterate
3. remove - O(n) - need iterate
4. removeLast - O(n) - need iterate
5. removeFirst - O(1)
6. get - O(n) - need iterate
7. set - O(n) - need iterate

## 用链表实现栈
由于链表在头结点的CRUD操作都是O(1)复杂度，所以特别适合用于实现栈  
栈，只需要在链表头进行push和pop都行
1. push -> addFirst -> O(1)
2. pop -> removeFirst -> O(1)
3. peek -> getFirst -> O(1)

## 用链表实现队列
**需要添加tail指针**
1. enqueue -> addLast -> O(1) -> need tail
2. dequeue -> removeFirst -> O(1)
3. front -> getFirst -> O(1)  

基于链表实现的队列和基于动态数组的循环队列，算法复杂度和性能类似