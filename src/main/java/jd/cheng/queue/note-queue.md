# 队列
1. FIFO
2. 从队尾添加；从队首取出

# 基本操作
1. enqueue - 入队 - array.addLast - O(1)
2. dequeue - 出队 - array.removeFirst - O(n)
3. getFront - 看队首 - array.getFirst - O(1)
4. size
5. isEmpty

**当队列中元素很多的时候，dequeue操作很费时间**

# 循环队列
## 基本概念
**利用指针解决dequeue后必须挪动数组**
- dequeue - 出队 - O(1)
- front指针: 指向队首
- tail指针：指向队尾
- 队列为空，front和tail指向同一个位置
- 队列为满, (tail + 1) % capacity = front

## 注意点
### 循环
用取余(Mod)操作实现循环
### 遍历循环队列
`for(int i=pFront; i!=pTail; i=(i+1) % data.length)`
### 扩容
```
// 将数组中从front开始，到tail为止的所有元素
// 放入新数组，从0开始放
// 重设front和tail指针
for(int i=0; i<data.length; i++) {
    newData[i] = data[(i+pFront) % data.length];
}
```