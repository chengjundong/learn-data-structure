# 递归
递归就是把问题转化为更小的问题，逐步解决的过程
## 递归操作的两部分
1. 求解基本问题
2. 原问题转化为更小的问题

```
// 用递归求数组和
// 基本问题 -> 当index超出时，返回0
// 更小的问题 -> 移动index，转化问题为"当前index的值 + 余下所有值"
private static int sum(int index, int[] input) {
	return index == input.length ? 0 
			: input[index] + sum(index+1, input);
}
```
## 链表与递归
链表天然具有递归性质  
n1 -> n2 -> n3 -> n4的链表可以视为：  n1 -> others#1  
其中，others#1 = n2 -> others#2  
