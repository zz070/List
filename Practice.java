package study;

/*
        1. 删除链表中等于给定值 toRemove的所有节点。
        2. 反转一个单链表。
        3. 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
        4. 输入一个链表，输出该链表中倒数第k个结点。
        5. 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
        6. 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
        7. 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
        8. 链表的回文结构。
        9. 输入两个链表，找出它们的第一个公共结点。
        10. 给定一个链表，判断链表中是否有环。
        11. 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 */
class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
        ListNode next = null;
    }
}
public class Practice{
    public ListNode removeElements(ListNode head,int val){
        if(head == null){
            return null;
        }
        ListNode prev = head;
        ListNode cur = prev.next;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        if(head.val == val){
            head = head.next;
        }
        return head;
    }

    //反转一个单链表。
    public ListNode reverse1(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode newHead = null;
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            if(next == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return newHead;
    }

    //给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
    private int size(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }
    public ListNode middleList(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        int step = size(head)/2;
        ListNode cur = head;
        for(int i = 0;i<step;i++){
            cur = cur.next;
        }
        return cur;
    }
    //输入一个链表，输出该链表中倒数第k个结点
    public ListNode outputKNode(ListNode head,int k) {
        int size = size(head);
        if(k<=0 || k>size){
            return null;
        }
        int step = size - k;
        ListNode cur = head;
        for(int i = 0;i < step;i++){
            cur = cur.next;
        }
        return cur;
    }

    //将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    public ListNode twoNode(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while(cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                newTail.next = cur1;
                cur1 = cur1.next;
            }else{
                newTail.next = cur2;
                cur2 = cur2.next;
            }
            newTail = newTail.next;
        }
        if(list1 == null){
            newTail.next = list2;
        }
        if(list2 == null){
            newTail.next = list1;
        }
        return newHead.next;
    }

    //  6. 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public ListNode partition(ListNode head,int x){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                smallTail.next = cur;
                smallTail = smallHead.next;
                cur = cur.next;
            }else{
                bigTail.next = cur;
                bigTail = bigTail.next;
                cur = cur.next;
            }
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
    // 7. 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    public ListNode reverseSame(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur = head;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;
            }
            newTail.next = cur;
            cur = cur.next;
            newTail = newTail.next;
        }
        return newHead.next;
    }

    //链表的回文结构
    public boolean isPalindrome(ListNode A) {
        if (A == null || A.next == null) {
            return true;
        }
        // 1. 先找到 A 链表的中间节点
        int size = size(A);
        int steps = size / 2;
        ListNode B = A;
        for (int i = 0; i < steps; i++) {
            B = B.next;
        }
        // 上面的循环结束后, B 就指向 A 链表的中间位置了
        // 2. 从 B 开始对后面的链表进行逆置操作
        ListNode prev = null;
        ListNode cur = B;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                // 说明此时的 cur 已经是链表的最后一个节点了, 更新头结点的位置
                B = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // 3. 分别从 A 和 B 出发, 来依次对比两个链表的元素是否对应相等.
        // 如果链表的长度为 奇数 个, 那 A 和 B 长度是相同的, 此时无影响
        // 如果链表的长度为 偶数 个, 那 A 的长度比 B 要长一个元素, 就需要注意遍历的时候循环结束条件
        // 要以 B 为基准
        while (B != null) {
            if (A.val != B.val) {
                // 对应元素不同, 说明不是回文
                return false;
            }
            A = A.next;
            B = B.next;
        }
        return true;
    }



    //输入两个链表，找出它们的第一个公共结点。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        int step = lenA - lenB;
        ListNode longHead = headA;
        ListNode shortHead = headB;
        if(step<0){
            longHead = headB;
            shortHead = headA;
            step = lenB - lenA;
        }
        for(int i = 0;i<step;i++){
            longHead = longHead.next;;
        }
        while (longHead != null && shortHead != null && longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return longHead;
    }

    private int getLength(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }

    //给定一个链表，判断链表中是否有环
    public boolean hasCycle(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        while(two != null && two.next != null){
            one = one.next;
            two = two.next.next;
            if(one == two){
                return true;
            }
        }
        return false;
    }


    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
    public ListNode detectCycle(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        while(two!= null && two.next != null){
            one = one.next;
            two = two.next.next;
            if(one == two){
                break;
            }
        }
        if(two == null || two.next == null){
            return null;
        }
        ListNode cur1 = head;
        ListNode cur2 = two;
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }


}





