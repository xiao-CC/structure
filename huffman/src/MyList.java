public interface MyList<E> {
    //添加
    public void add(E e);

    //移除
    public E remove(int index);

    //获取数据
    public E get(int index);

    //长度
    public int size();
}
