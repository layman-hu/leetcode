### 1.两数之和

#### 哈希表应用

<details>
<summary>题目</summary>
<pre><code>
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。
示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]
提示：
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案
进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
</code></pre>
</details>

```java
public class Solution1 {
    //1.哈希表
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        /*
        key:target-nums[i]
        value:i
         */
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for(int i=0; i<len; i++){
            if(hashMap.containsKey(nums[i])){
                return new int[]{i, hashMap.get(nums[i])};
            }
            hashMap.put(target-nums[i], i);
        }
        return new int[]{};
    }
    public static void main(String[] args){
        int i = 0;
        int len_count = 0;
        int target = 0;
        int[] n = new int[4];
        Scanner in = new Scanner(System.in);
        for(i=0 ; i<5; i++) {
            if(i == 4){
                target = in.nextInt();
                break;
            }
            len_count++;
            n[i] = in.nextInt();
        }
        in.close();
        System.out.println("target:"+target);
        System.out.println("i:"+i+" len_count:"+ len_count);
        int[] result = twoSum(n,target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
```



### 2.两数之和

#### 单链表操作，大数相加

<details>
<summary>题目</summary>
<pre><code>
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例 1：
![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/02/addtwonumber1.jpg)
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
示例 2：
输入：l1 = [0], l2 = [0]
输出：[0]
示例 3：
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
提示：
每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零。
</code></pre>
</details>

```java
public class Solution2 {


    //2.大数相加，链表
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(); //l3当做头结点
        ListNode tail = l3;//tail尾指针

        //将l1 l2看作同样长度的链表，不足位用0代替
        int carry = 0;//初始进位为0
        while (l1 != null || l2 != null) {
            int l1_val = (l1 == null ? 0 : l1.val);
            int l2_val = (l2 == null ? 0 : l2.val);

            int l3_val = (l1_val + l2_val + carry) % 10;
            carry = (l1_val + l2_val + carry) / 10;
            tail.next = new ListNode(l3_val);
            tail = tail.next;

            if(l1 != null){
                if(l1.next != null)
                    l1 = l1.next;
                else l1 = null;
            }

            if(l2 != null){
                if(l2.next != null)
                    l2 = l2.next;
                else l2 = null;
            }

        }
        //两链表最末位若存在进位，则添加一个结点
        if(carry == 1)
            tail.next = new ListNode(carry);

        return l3.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(1);

        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(4);
//        l2.next.next = new ListNode(3);

        ListNode l3 = addTwoNumbers(l1, l2);

        while (l3.next != null){
            System.out.print(l3.val);
            l3 = l3.next;
        }
        System.out.println(l3.val);


    }
}
```



### 3.无重复字符的最长子串

#### 哈希表，字符串，滑动窗口

<details>
<summary>题目</summary>
<pre><code>
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:
输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
示例 4:
输入: s = ""
输出: 0
提示：
0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成
</code></pre>
</details>

```java
public class Solution3 {

    //3. 无重复字符的最长子串
    /*
    思路：散列表，滑动窗口
     */
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;//最大长度
        int fast_point = 0;
        int slow_point = 0;

        int str_len = s.length();
        /*
        key:char
        value:index
         */
        HashMap<Character,Integer> hashMap = new HashMap<>();

        for(fast_point=0; fast_point<str_len; fast_point++){
//            if(!hashMap.containsKey(s.charAt(fast_point))){
//                hashMap.put(s.charAt(fast_point),fast_point);
//                result = Math.max(result, fast_point-slow_point+1);
//            }else {
//                slow_point = Math.max(hashMap.get(s.charAt(fast_point))+1, slow_point);
//                hashMap.replace(s.charAt(fast_point), fast_point);
//                result = Math.max(result, fast_point-slow_point+1);
//            }

            if(hashMap.containsKey(s.charAt(fast_point))){
//                slow_point = Math.max(hashMap.get(s.charAt(fast_point))+1, slow_point);
                slow_point = (hashMap.get(s.charAt(fast_point))+1>slow_point)?(hashMap.get(s.charAt(fast_point))+1):slow_point;
            }

            hashMap.put(s.charAt(fast_point), fast_point);
//            result = Math.max(result, fast_point-slow_point+1);
            result = (result>fast_point-slow_point+1)?result:(fast_point-slow_point+1);
        }

        return result;
    }

    public static void main(String[] args){
//        String s = "1234";
//        System.out.println(s.charAt(0));
        
//        System.out.println(lengthOfLongestSubstring("dvdf"));
//        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
```







### 2.两数之和

#### 单链表操作，大数相加

### XXXXXXX

#### xxxxx



