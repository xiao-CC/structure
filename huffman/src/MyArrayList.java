import java.util.ArrayList;
import java.util.List;

public class MyArrayList<E> implements MyList<E>{
    //原数组
    public Object[] arr = new Object[0];
    public int size; //记录长度

    //添加
    public void add(E e) {
        //变长后的数组
        Object[] newArr = new Object[arr.length+1];
        //把原数组中的数据复制到新数组中
        for(int i=0;i<arr.length;i++) {
            newArr[i] = arr[i];
        }
        //把新数据放到末尾
        newArr[arr.length]=e;
        //更新原数组地址
        arr = newArr;
        size++;
    }

    //删除
    @Override
    public E remove(int index) {
        return null;
    }

    //查找
    public E get(int index){
        return null;
    }

    //长度
    public int size() {
        return size;
    }

    /*public static void main(String[] args) {
        MyArrayList mylist = new MyArrayList();
        //获取系统当前时间
        long start = System.currentTimeMillis();
        for(int i=0;i<10000;i++) {
            mylist.add(i);
        }
        long last = System.currentTimeMillis();
        System.out.println("耗时："+(last-start));

        List<Integer> list= new ArrayList<>();
        long start2=System.currentTimeMillis();
        for(int i=0;i<10000;i++) {
            list.add(i);
        }
        long last2 = System.currentTimeMillis();
        System.out.println("耗时："+(last2-start2));
    }*/

}
