

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