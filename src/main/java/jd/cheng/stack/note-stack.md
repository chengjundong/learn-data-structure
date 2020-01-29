# 栈的基本属性
1. 操作是数组操作的子集
2. 只能在栈顶添加元素，栈顶取出元素
3. LIFO

# 应用场景
1. 撤销(Ctrl + Z)
2. 程序调用系统栈

# 栈的基本方法
1. push: 压入 -> array.addLast
2. pop: 弹出 -> array.removeLast
3. peek: 看栈顶元素 -> array.getLast
4. size
5. isEmpty
如果没有resize，以上方法的时间复杂度都是O(1)。因为都是在已知索引的情况下，对数组进行操作。

