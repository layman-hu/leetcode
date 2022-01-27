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
public class solution0000_0014.Solution0001 {
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
public class solution0000_0014.Solution0002 {


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
public class solution0000_0014.Solution0003 {

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



### 4.寻找两个正序数组的中位数

#### 二分查找

<details>
<summary>题目</summary>
<pre><code>
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
算法的时间复杂度应该为 O(log (m+n)) 。
示例 1：
输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：
输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
示例 3：
输入：nums1 = [0,0], nums2 = [0,0]
输出：0.00000
示例 4：
输入：nums1 = [], nums2 = [1]
输出：1.00000
示例 5：
输入：nums1 = [2], nums2 = []
输出：2.00000
提示：
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 10^6
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
</code></pre>
</details>

```java
public class solution0000_0014.Solution0004 {

    //4. 寻找两个正序数组的中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //二分查找
        //将短的数组放在nums1中
        if(nums1.length>nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        /*
        考虑：把nums1和nums2想象成一个大数组nums
        中位数：中位数定义，将一个集合分成两个子集，在中位数左边的子集一定小于中位数右边的子集
        这里定义：左边子集数量等于右边子集数量，或者比右边多1。这样，求出了左子集，右子集自然就得出来了
         */

        /*
        len = nums1.length+nums2.length=m+n;
        nums含奇数个元素，左子集个数:(len/2)+1=(len+1)/2
        nums含偶数个元素，左子集个数:len/2=(len+1)/2
        所以nums不论奇偶，左子集个数都可表示为:(len+1)/2=(m+n+1)/2
         */
        int total_left_subset_num = (m+n+1)/2;

        // 在 nums1 的区间 [0, m] 里查找恰当的分割线，
        /*
         使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]

         total_left_subset_num = i+j
         i,j分别代表nums1和muns2的中位数下标
         i-1和j-1表示在中位数左边，即元素分别在nums1和nums2的左子集
         */

        //定义nums1左右指针，当left和right重合时，搜寻结束

        int nums1_left = 0;
        int nums1_right = m;

        while(nums1_left<nums1_right){
            int i = nums1_left + (nums1_right-nums1_left+1)/2;
            int j = total_left_subset_num - i;
            if(nums1[i-1] > nums2[j]){
                // 下一轮搜索的区间 [nums1_left, i - 1]
                nums1_right = i-1;
            }else {
                // 下一轮搜索的区间 [i, nums1_right]
                nums1_left = i;
            }
        }
        int i = nums1_left;
        int j = total_left_subset_num - i;

        int nums1_left_max = ((i==0)?Integer.MIN_VALUE:nums1[i-1]);
        int nums1_right_min = ((i==m)?Integer.MAX_VALUE:nums1[i]);
        int nums2_left_max = ((j==0)?Integer.MIN_VALUE:nums2[j-1]);
        int nums2_right_min = ((j==n)?Integer.MAX_VALUE:nums2[j]);

        if((m+n)%2 == 1){
            //奇数个，此时中位数在左子集的最后一个
            return (nums1_left_max>nums2_left_max)?nums1_left_max:nums2_left_max;
        } else {
            //偶数个，此时中位数为左子集最大值与右子集最小值的均值
            return 1.0*((nums1_left_max>nums2_left_max?nums1_left_max:nums2_left_max) +(nums1_right_min<nums2_right_min?nums1_right_min:nums2_right_min) )/2;
        }
    }

    public static void main(String[] args){
        int[] n1 = {1,2};
        int[] n2 = {3,4};
        System.out.println(findMedianSortedArrays(n1, n2));
    }
}
```

### 5.最长回文序列

#### 回文序列，中心点扩散

<details>
<summary>题目</summary>
<pre><code>
给你一个字符串 s，找到 s 中最长的回文子串。
示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：
输入：s = "cbbd"
输出："bb"
示例 3：
输入：s = "a"
输出："a"
示例 4：
输入：s = "ac"
输出："a"
提示：
1 <= s.length <= 1000
s 仅由数字和英文字母（大写和/或小写）组成
</code></pre>
</details>

```java
public class solution0000_0014.Solution0005 {

    //5. 最长回文子串
    public static String longestPalindrome(String s) {
        int odd_palindrome_len = 1;//奇数回文序列长度
        int odd_palindrome_index = 0;
        int even_palindrome_len = 0;//偶数回文序列长度
        int even_palindrome_index = 0;//偶回文序列中点下标，取左边下标

        int len = s.length();
        for(int i=0; i<len; i++){
            int even_index_temp = i;
            int even_len_temp = 0;
            int interval = 0;
            while (even_index_temp-interval>=0 && even_index_temp+1+interval<len){
                if(s.charAt(even_index_temp-interval) == s.charAt(even_index_temp+1+interval)){
                    even_len_temp += 2;
                    interval++;
                }else break;
            }
            if(even_len_temp > even_palindrome_len){
                even_palindrome_len = even_len_temp;
                even_palindrome_index = even_index_temp;
            }

            int odd_index_temp = i;
            int odd_len_temp = 1;
            int interval2 = 1;
            while (odd_index_temp-interval2>=0 && odd_index_temp+interval2<len){
                if(s.charAt(odd_index_temp-interval2) == s.charAt(odd_index_temp+interval2)){
                    odd_len_temp += 2;
                    interval2++;
                }else break;
            }
            if(odd_len_temp > odd_palindrome_len){
                odd_palindrome_len = odd_len_temp;
                odd_palindrome_index = odd_index_temp;
            }
        }
        if(odd_palindrome_len>even_palindrome_len){
            return s.substring(odd_palindrome_index-(odd_palindrome_len/2),odd_palindrome_index+(odd_palindrome_len/2)+1);
        }else {
            return s.substring((even_palindrome_index+1)-(even_palindrome_len/2),even_palindrome_index+(even_palindrome_len/2)+1);
        }

    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("ac"));
    }
}
```

### 6.Z 字形变换

#### StringBuild用法

<details>
<summary>题目</summary>
<pre><code>
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);
示例 1：
输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
示例 2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
示例 3：
输入：s = "A", numRows = 1
输出："A"
提示：
1 <= s.length <= 1000
s 由英文字母（小写和大写）、',' 和 '.' 组成
1 <= numRows <= 1000
</code></pre>
</details>

```java
public class solution0000_0014.Solution0006_plus {

    //6. Z 字形变换
    public static String convert(String s, int numRows) {
        //numRows行对应numRows个StringBuild
        if(numRows == 1) return s;
        StringBuilder[] strs = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++) strs[i] = new StringBuilder();

        int index = 0;
        int sign = 1;
        for(char c:s.toCharArray()){
            strs[index].append(c);
            index += sign;
            if(index==0 || index==numRows-1){
                sign = -sign;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i=0; i<numRows; i++){
            result.append(strs[i]);
        }

        return result.toString();
    }

    public static void main(String[] args){
        System.out.print(convert("PAYPALISHIRING", 3));
    }
}
```

### 7.整数反转

#### int型整数溢出判定方法

<details>
<summary>题目</summary>
<pre><code>
给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
假设环境不允许存储 64 位整数（有符号或无符号）。
示例 1：
输入：x = 123
输出：321
示例 2：
输入：x = -123
输出：-321
示例 3：
输入：x = 120
输出：21
示例 4：
输入：x = 0
输出：0
提示：
-2^31 <= x <= 2^31 - 1
1 <= numRows <= 1000
</code></pre>
</details>

```java
public class solution0000_0014.Solution0007 {

    //7. 整数反转
    /*
    2^31-1=2147483647
    -2^31=-2147483648
           1534236469
           9646324351
     */

    public static int reverse(int x) {
        int result = 0;
//        int num_flag = x>0?1:-1;
        while (x != 0){
            int remainder = x%10;
            /*
            if((result*10 + remainder)<Integer.MIN_VALUE || (result*10 + remainder)>Integer.MAX_VALUE)
                return 0;
            当result*10 + remainder溢出时，他仍然是整数类型，32位，溢出位丢失，导致判定失败
            换位思考，将不等式两边同时除以10即可
            即
            result + remainder/10<Integer.MIN_VALUE/10
            和result + remainder/10>Integer.MAX_VALUE/10

            进一步等价于
            result<Integer.MIN_VALUE/10
            和result>Integer.MAX_VALUE/10
             */
            if(result<Integer.MIN_VALUE/10 || result>Integer.MAX_VALUE/10)
                return 0;
            result = result*10 + remainder;
            x /= 10;
        }
        return result;
        /*
        失败案例
        9646324351越界了
         */
//        int zero_flag = 1;
//        int num_flag = x>0?1:-1;
//        x = x>0?x:-x;
//        StringBuilder builder = new StringBuilder();
//
//        while (x>=10){
//            int remainder = x%10;
//            x /= 10;
//            if(remainder == 0 && zero_flag == 1){
//                continue;
//            }else if(remainder != 0){
//                zero_flag = 0;
//            }
//            builder.append(String.valueOf(remainder));
//        }
//        builder.append(String.valueOf(x));
//
//        int result = num_flag*Integer.valueOf(builder.toString());
//        if(result<(-1*1L<<32) || result>(1L<<32)-1) return 0;
//
//        System.out.print(num_flag>0?"":"-");
//        System.out.print(builder.toString());
//        System.out.println();
//
//        return result;
    }

    public static void main(String[] args){
//        System.out.println(reverse(123));
//        System.out.println(reverse(-123));
        System.out.println(reverse(1534236469));
//        System.out.println(reverse(0));
        /*
        2^31-1=2147483647
        -2^31=-2147483648
        9646324351
        2147483647

         */
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
    }
}
```



### 8. 字符串转换整数 (atoi)

#### int型整数溢出判定方法

```java
public class solution0000_0014.Solution0008 {

    //8. 字符串转换整数 (atoi)
    public static int myAtoi(String s) {

        int num = 0;
        int sign_flag = 1;
        int sign_num = 0;//符号个数，+-12输出0，你敢信
        int num_flag = 0;
        for(char c:s.toCharArray()){
            if(c == ' ' && num_flag == 0 && sign_num == 0) continue;
            if(c == '+' && num_flag == 0){
                sign_num++;
                continue;
            }
            if(c == '-' && num_flag == 0) {
                sign_flag = -1;
                sign_num++;
                continue;
            }
            else if(c>='0' && c<='9'){
                if(sign_num>1) return 0;

                //Integer.MIN_VALUE = -2147483648
                if(sign_flag == -1 ){
                    if(num < Integer.MIN_VALUE/10)
                        return Integer.MIN_VALUE;
                    if(num == Integer.MIN_VALUE/10 && (c-'0')>8)
                        return Integer.MIN_VALUE;
                }

                //Integer.MAX_VALUE = 2147483647
                if(num > Integer.MAX_VALUE/10) return Integer.MAX_VALUE;
                if(num == Integer.MAX_VALUE/10 && (c-'0')>7) return Integer.MAX_VALUE;

                num = num*10 + ((sign_flag>0)?(c-'0'):-(c-'0'));
                num_flag = 1;
            }else return (num_flag == 0)?0:num;
        }
        return num;
    }

    public static void main(String[] args){
        System.out.println(myAtoi(" + 123"));
        System.out.println(-2147483648);
    }
}
```



### 9. 回文数

```java
public class solution0000_0014.Solution0009 {

    //9. 回文数
    public boolean isPalindrome(int x) {
        /*
        反转数字的位数已经达到原始数字位数的一半？
        由于整个过程我们不断将原始数字除以 10，
        然后给反转后的数字乘上 10，
        所以，当原始数字小于或等于反转后的数字时，
        就意味着我们已经处理了一半位数的数字了。

        记录官方题解思路，代码中我没有去实现
         */


        if(x<0) return false;//负数直接不是回文数
        int num_len = 0;

        int x_temp = x;
        while (x_temp != 0){
            x_temp /= 10;
            num_len++;
        }
        int half_x = 0;

        /*
        优化如下
        if(num_len%2 == 0){//x为偶数个
            for(int i=0; i<num_len/2; i++){
                int remainder = x%10;//余数
                half_x = 10*half_x + remainder;
                x /= 10;
            }
            return (x - half_x == 0)?true:false;
        }else {
            for(int i=0; i<num_len/2; i++){
                int remainder = x%10;//余数
                half_x = 10*half_x + remainder;
                x /= 10;
            }
            x /= 10;
            return (x - half_x == 0)?true:false;
        }
        */
        for(int i=0; i<num_len/2; i++){
            int remainder = x%10;//余数
            half_x = 10*half_x + remainder;
            x /= 10;
        }
        if(num_len%2==1) x /= 10;
        return (x - half_x == 0)?true:false;
    }

    public static void main(String[] args){
        solution0000_0014.Solution0009 solution0009 = new solution0000_0014.Solution0009();
        System.out.println(solution0009.isPalindrome(-101));
    }
}
```



### 10. 正则表达式匹配

#### 动态规划

```java
public class solution0000_0014.Solution0010 {

    //10. 正则表达式匹配
    public boolean isMatch(String s, String p) {
        boolean table[][] = new boolean[s.length()+1][p.length()+1];

        table[0][0] = true;

        //初始化第一行
        for(int j=1; j<table[0].length; j++){
            char c = p.charAt(j-1);
            if(j>1){
                if(c == '*')
                    table[0][j] = table[0][j-2];
                else table[0][j] = false;
            }else {
                //此时，*前无字符，*代表0个字符
                if(c == '*')
                    table[0][j] = true;
            }
        }

        //生成第二行至最后一行
        for(int i=1; i<table.length; i++){
            char ch1 = s.charAt(i-1);
            for(int j=1; j<table[i].length; j++){
                char ch2 = p.charAt(j-1);
                if(ch2 == '.' || ch2 == ch1){
                    table[i][j] = table[i-1][j-1];
                }else if(ch2 == '*'){
                    if(j>1){
                        if(table[i][j-2])
                            table[i][j] = true;
                        else {
                            char pre = p.charAt(j-2);
                            if(pre == ch1 || pre == '.'){
                                table[i][j] = table[i-1][j];
                            }
//                            else table[i][j] =false;
                        }
                    }
                }


            }
        }
        boolean lastRow[] = table[table.length-1];
        return lastRow[lastRow.length-1];
    }

    public static void main(String[] args){
        solution0000_0014.Solution0010 solution = new solution0000_0014.Solution0010();
//        System.out.println(solution.isMatch("ab",".*"));
//        System.out.println(solution.isMatch("aab","c*a*b"));
        System.out.println(solution.isMatch("mississippi","mis*is*p*."));

    }
}
```



### 11. 盛最多水的容器

#### 双指针

```java
public class solution0000_0014.Solution0011 {

    //11. 盛最多水的容器

    /*
    双指针
    area = max{min{height[i],height[j]} * Math.abs(j-i) |i,j属于height.lenght}
     */
    public int maxArea(int[] height) {
        int p=0, q=height.length-1;//p和q分别为头尾指针
        int max = 0;

        while (p<q){
            int min_height = height[p]<height[q]?height[p]:height[q];
            max = max>min_height*(q-p)?max:min_height*(q-p);
            if(height[p]<height[q]){
                p++;
            }else q--;
        }
        return max;
    }

    public static void main(String[] args){
        solution0000_0014.Solution0011 solution = new solution0000_0014.Solution0011();
//        int nums[] = {1,8,6,2,5,4,8,3,7};
//        int nums[] = {1,1};
        int nums[] = {1,2,1};
//        int nums[] = {1,8,6,2,5,4,8,3,7};


        System.out.println(solution.maxArea(nums));
    }
}
```



### 2.两数之和

#### 单链表操作，大数相加

#### 



