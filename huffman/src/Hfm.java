import java.util.*;

public class Hfm {
    /**
     * 关于树的非递归遍历
     * 基本都一样，结构为两个while，或是一个while嵌套一个if-else
     * 使用栈，入栈时使出为前序遍历，出栈时输出为中续遍历
     */

    static List<Node> list = new ArrayList<Node>();
    Node root=new Node();

    public Hfm(int[] arr){
        //将数组中的数储存到list
        for (int j : arr) {
            Node node = new Node();
            node.data = j;
            list.add(node);
        }
        build();
    }

    //建树
    public void build(){
        //排序
        int start = 0;
        int end = list.size()-1;
        quicksort(list,start,end);

        while (list.size()>=2) {
            Node father=new Node();
            father.data = list.get(1).data + list.get(0).data;
            father.lift = list.get(0);
            father.right = list.get(1);
            list.add(father);
            list.remove(0);
            list.remove(0);
            if (list.size()==1){
                root=father;
                return;
            }
            build();
        }
    }

    //递归遍历，打印哈夫曼树
    public void print(Node node){
        if (node!=null){
            print(node.lift);
            print(node.right);
            System.out.println(node.data);
        }
    }

    //非递归前序遍历
    public void preOrd(Node root){
        Stack<Node> stack=new Stack<Node>();
        Node current=root;
        if (root==null){
            return;
        }
        while (current!=null||!stack.isEmpty()){
            while (current!=null){              // 这种while和下面那种if-else都可以
                System.out.println(current.data);
                stack.push(current);
                current=current.lift;
            }
            current=stack.pop();
            current=current.right;
        }
    }

    //非递归中序遍历
    public void midOrd(Node root){
        if (root==null){
            return;
        }
        Stack<Node> stack=new Stack<Node>();
        Node current=root;
        while (current!=null||!stack.isEmpty()){
            if (current!=null){
                stack.push(current);
                current=current.lift;
            }else {
                current=stack.pop();
                System.out.println(current.data);
                current=current.right;
            }
        }
    }

    /**
     * 非递归后序遍历
     * stack2用来标记哪边访问完了。如果访问完了左子树，那继续访问右子树。 而如果访问完了右子树，那就要输出根节点。
     * 这个算法的关键问题在于，只有当没有右子树时才会进行输出；所以，要先访问左子树，再判断是否要输出，再访问右子树。
     */
    public void postOrd(Node root){
        if (root==null){
            return;
        }
        Node current=root;
        Stack<Node> stack1=new Stack<Node>();
        Stack<String> stack2=new Stack<String>();
        while (current!=null||!stack1.isEmpty()){
            //首先遍历左子树和沿途根节点，入栈
            while (current!=null){
                stack1.push(current);
                stack2.push("left");
                current=current.lift;
            }
            //判断是否需要输出
            while (!stack1.isEmpty()&&stack2.peek()=="right"){
                current=stack1.pop();
                stack2.pop();
                System.out.println(current.data);
                //要手动跳出，这个方法不能自动跳出
                if (stack1.isEmpty()){
                    return;
                }
            }
            //转到右边进行遍历
            if (!stack1.isEmpty()){
                current=stack1.peek().right;
                stack2.pop();
                stack2.push("right");
            }
        }
    }

    //快速排序
    public void quicksort(List<Node> list,int low,int high){
        int i=low;
        int j=high;
        int pivot=list.get(low).data;
        while (j>i){
            while (j>i&&list.get(j).data>=pivot){   //这里的j>i不能省略，否则报错
                j--;
            }
            if (list.get(j).data<=pivot){ //即使相等也要换位
                Node tem=list.get(i);
                list.set(i,list.get(j));
                list.set(j,tem);
            }
            while (j>i&&list.get(i).data<=pivot){
                i++;
            }
            if (list.get(i).data>=pivot){
                Node tem=list.get(i);
                list.set(i,list.get(j));
                list.set(j,tem);
            }
        }
        if (i>low) quicksort(list,low,i-1);
        if (high>j) quicksort(list,j+1,high);
    }

    public static void main(String[] args) {
        int[] arr=new int[]{4,5,11,7};
        Hfm hfm=new Hfm(arr);
        //hfm.print(hfm.root);
        //hfm.preOrd(hfm.root);
        //hfm.midOrd(hfm.root);
        hfm.postOrd(hfm.root);
    }
}
