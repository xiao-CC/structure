#include <iostream>
using namespace std;

class Node
{
public:
    Node *next;
    int data;
};


class LinkList
{
private:
    Node *first;
public:
    LinkList();
    LinkList(int a[]);  //偷个懒，只能新建长度为5的链表
    ~LinkList();
    int Lenght();
    void PrintList();
    int Get(int i);    //按下标查找
    int Locate(int n);  //按值查找
    void Insert(int x,int n);//在中间插,n是位置
    //int Delete(int n);
};

LinkList::LinkList()
{
    first=new Node;
    first->next=NULL;
    cout<<"LinkList"<<endl;
}

LinkList::LinkList(int a[])
{
    cout<<"gouzao"<<endl;
    first=new Node;  //个人感觉，节点是靠指针创建的
    Node *tem=first;
    for(int i=0;i<=5;i++)
    {
        Node *s=new Node;
        s->data=a[i];
        tem->next=s;
        tem=s;
    }
}

LinkList::~LinkList()
{
    delete first;
}

int LinkList::Get(int i)
{
    Node *tem=first->next;
    int count=1;
    while (tem!=NULL&&count<i)
    {
        tem=tem->next;
        count++;
    }
    return tem->data;   //书上这个地方有个else，但是感觉c++的else和java的不太一样，有空查查
    // if (tem==NULL)throw"位置";
    // else return tem->data; 
    //这个写法是书上的    
}

int LinkList::Lenght()
{
    Node *tem=first->next;
    int n=0;
    while (tem!=NULL)
    {
        tem=tem->next;
        n++;
    }
    return n;
}

void LinkList::PrintList()
{
    cout<<"print"<<endl;
    Node *tem=first->next;  //感觉这意思就是，前面new过一个叫first的node
                            //所以后面就不需要再new tem这个node了，直接用next连起来就可以
    while (tem!=NULL)
    {
        cout<<tem->data;   //个人理解，这个箭头才是命令指针走到下一个节点
                           //而data和next则是知名走到下一个节点的哪个位置
        tem=tem->next;
    }
}

int LinkList::Locate(int n)
{
    Node *tem=first->next;
    int count=1;
    while (tem!=NULL)
    {
        if (tem->data==n)
        {
            return count;
        }
        count++;
        tem=tem->next;
    }
    return 0;
}

void LinkList::Insert(int x,int n)
{
    cout<<"insert"<<endl;
    int count=0;
    Node *tem=first;
    while (count<n-1)
    {
        count++;
        tem=tem->next;
    }
    Node *s=new Node;
    s->data=x;
    s->next=tem->next; //先链接s和原先的n位置，这句tem-next只是赋值指针
    tem->next=s;  //再链接n-1和s
}

// int LinkList::Delete(int n)
// {
// }

int main()
{
    LinkList list;  //新建以一个空链表
	LinkList *plist = &list;  //新建一个链表的指针，这个指针用来调用链表的方法
    //上面两行新建链表是真的神了

    plist->Insert(3,1);
    plist->PrintList();
}