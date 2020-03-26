package study;

class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data = data;
        Node next =null;
    }
}
public class MyLinkedList {
    private Node head = null;

    //打印
    public void display(){
        System.out.print("打印链表  >   ");
        for(Node cur=head;cur!=null;cur=cur.next){
            System.out.print(cur.data);
            if(cur.next!=null){
                System.out.print(" , ");
            }
        }
    }

    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }else{
            node.next=head;
            head = node;
        }
    }

    //尾插
    public void addLast(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }else{
            Node last = head;
            while(last.next!=null){
                last = last.next;
            }
            last.next=node;
        }
    }

    //在任意位置插入
    /*首先，确定要插入的位置，若要插入的位置在开始,用addFirst();
                                                       若插入的位置在末尾，用addLast();
                                                       若插入的位置在中间，就要找到index位置前一个结点，再插入
        获取结点个数的方法，getSize();
        获取index位置结点的方法，getIndex(int index)
     */
    public int getSize(){
        int size=0;
        for(Node cur=head;cur!=null;cur=cur.next){
            size++;
        }
        return size;
    }
    public Node getIndex(int index){
        Node cur = head;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur;
    }
    public boolean addIndex(int index,int data){
        int size = getSize();
        if(index<0||index>=size){
            return false;
        }else if(index == 0){
            addFirst(data);
            return true;
        }else if(index == size){
            addLast(data);
            return true;
        }else{
            Node node = new Node(data);
            Node prev = getIndex(index-1);
            node.next = prev.next;
            prev.next=node;
            return true;
        }
    }

    //查找是否包含关键字toFind是否在单链表当中
    public boolean contains(int toFind){
        for(Node cur =head;cur!=null;cur= cur.next){
            if(cur.data==toFind){
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字为toRemove的节点
    /*首先判断要删除的节点是否是头结点，若为头结点，则，直接令head=head.next;
                                                                            否则，先找到要删除结点的前一个结点，再执行prev.next = prev.next.next;
        按照元素找到前一个结点的方法，getValue();
     */
    public Node getValue(int value){
        for(Node cur=head;cur!=null && cur.next!=null;cur=cur.next){
            if(cur.next.data==value){
                return cur;
            }
        }
        return null;
    }
    public void remove(int toRemove){
        if(head.data==toRemove){
            head=head.next;
        }else{
            Node prev = getValue(toRemove);
            Node toDelete = prev.next;
            prev.next=toDelete.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList my = new MyLinkedList();
        my.addFirst(1);
        my.addFirst(2);
        my.addFirst(3);
        my.display();
        System.out.println();
        my.addLast(11);
        my.addLast(22);
        my.display();
        System.out.println();
        my.addIndex(1,33);
        my.display();
        System.out.println();
        my.remove(1);
        my.display();
        System.out.println();
        System.out.println(my.contains(99));
    }
    //删除所有值为key的节点
}
