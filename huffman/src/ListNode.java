public class ListNode {
    public ListNode next;
    Object data;  //这个object用的就很灵性。解决了可以存任意格式数据的问题。
                  //据说，这样做也可以容易解决数据格式转换的问题
    public ListNode() {}

    public ListNode(Object data) {
        this.data = data;
    }
}
