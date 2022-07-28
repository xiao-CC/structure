public class MyLinkList<E> implements MyList<E>{
    public ListNode root; // 根节点
    public ListNode last; // 尾节点
    public int size;

    public MyLinkList() {
        // 初始化根节点，用来保存头节点
        root = new ListNode();
    }
    //前插
    /*@Override头插法
    public void add(E e) {
        ListNode newNode = new ListNode(e);
        if (root.next==null){
            root.next=newNode;
            newNode=last;
        }
        else {
            ListNode tem=new ListNode();
            tem=root.next;
            root.next=newNode;
            newNode.next=tem;
        }
    }*/

    //后插
    @Override
    public void add(E e) {
        ListNode newNode = new ListNode(e);
        if (root.next==null){
            root.next=newNode;
            newNode=last;
        }
        else {
            ListNode cur=root;
            while (cur.next!=last){
                cur=cur.next;
            }
            cur.next=newNode;
            newNode.next=last;
        }
    }

    @Override
    public E remove(int index) {
        ListNode cur=root;
        for (int i=0;i+1<=index-1;i++){
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return (E) cur.data;
    }

    @Override
    public E get(int index) {
        ListNode cur=root;
        for (int i=0;i+1<=index;i++){
            cur=cur.next;
        }
        return (E) cur.data;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyLinkList<String> link = new MyLinkList<>();
        link.add("a");
        link.add("b");
        link.add("c");
        link.add("d");

        //System.out.println("size = "+link.size());
        System.out.println(link.root.next.next.data);
    }
}
