# 并查集
比较特殊的树状结构，用于处理连接问题
- 社交网络，随机挑出两个用户，他们的社交关系是否相通
- 商品之间是否有某种联系
- 网络节点之间是否相通

## 连接问题与路径问题区别
- 两个节点之间有路径，肯定连接
- 但是两个节点之间是否连接，不一定需要求出路径

## 操作
- union：将两个节点相连
- find: 查找某个节点所属集合

## Quick Find
### 实现
- 使用数组存储
- 初始化，给每个index的数据标记上不同的编号，代表一开始所有元素都不相通
- find只需要找到两个index的编号，作比较即可

union的步骤  
```
union(x, y)
1. find id[y]
2. find all indexs whose id is equal to id[x]
3. change to id[y]
```
### 时间复杂度
- find: O(1)
- union: O(n)

## Quick Union
### 实现
- 数组实现，用于存放某个node的parent
- 模拟一棵由child指向parent的树
- 当一个node的parent是自己的时候，它就是自己这棵树的root

```
union步骤
union(x, y)
1. get rootX
2. get rootY
3. rootX.parent = rootY
```

```
find步骤, find(x, y)
1. get rootX
2. get rootY
3. whether rootX == rootY?
```

### 时间复杂度
- union O(h)
- find O(h)

均与树的深度有关，一般都比N小
### 基于Rank的优化
union的时候不要武断地直接将 `rootX.parent = rootY`, 而是判断两边树的的深度。  
将深度小的树挂到深度大的树，这样union完之后，整颗树的深度不变。  
由于union和find操作都与树的深度H有关，这样可以优化操作
