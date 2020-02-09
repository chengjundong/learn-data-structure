# Trie 字典树 前缀树
专门用于处理字符串的数据结构
## 时间复杂度
只与要查询的单词长度有关，与字典中有多少单词无关  
由于英语单词通常都小于10，所以可以认为该数据结构查询速度很快
## 结构
- 每个节点都有26个指向下个节点的指针 （不考虑大小写）
- 每个节点放一个字母
- next可以用映射Map来表示
- 每个节点存放一个tag：表示该节点是否可以做为一个word的结尾
## 操作
### 添加 add
1. 拆分输入String为char[]
2. 从root开始依次将char[]摆放进tree
    - 当字符不存在，则放入
    - 当字符存在，则取出
3. 对于最后一个字符，需要检查是否标记为the end of word
    - 是，结束。该单词已存在。
    - 否，标记成end of word，并且tree size + 1。因此此时可以认为添加了一个新单词。
### 整词查询 contains
1. 拆分输入String为char[]
2. 从root开始，依次搜索next中是否包含char
   - 有一个char不包含，结束，不存在
   - 全部包含，检查最后一个节点是否为end of word
     - 是，存在
     - 不是，不存在。只是存在一个以该单词为前缀的单词
### 前缀查询
同整词查询，只是不需要判断最后一个词是否为end of word
### 通配符查询
如果对于某个字符，如'.'，需要匹配所有可能，则需要一个循环遍历所有子节点的过程。  
参考题目 [LeetCode 211](https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/)

## 其他
- 字典树空间占用大
- 空间利用率更高的压缩字典树，但是插入维护成本高
- Ternay search tree，三分搜索树
- 后缀树
- 子串查询：KMP，Boyer-Moore，Rain-Karp
- 文件压缩
- 模式匹配