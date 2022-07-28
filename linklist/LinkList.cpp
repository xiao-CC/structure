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
    Node *first;   //first的作用不光是头节点，还可以代表整个链表，即用头节点操作整个链表
public:
    LinkList();
    LinkList(int a[]);  //头插法构造
    ~LinkList();
    int Lenght();
    void PrintList();
    int Get(int i);    //按下标查找
    int Locate(int n);  //按值查找
    void Insert(int x,int n);//在中间插,n是位置，x是值
    void EndIns(int a[]);   //尾插法
    void Delete(int n);   //n从1计
    void Update(int x,int n);
};

LinkList::LinkList()
{
    cout<<"null const"<<endl;
    first=new Node;
    first->next=NULL;
}

LinkList::LinkList(int a[])
{
    //偷个懒，只能插5个
    cout<<"arr const"<<endl;
    first=new Node;
    first->next=NULL;
    for(int i=0;i<5;i++)
    {
        Node *s=new Node;
        s->data=a[i];
        s->next=first->next;
        first->next=s;
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
    Node *tem=first->next;
                        
    while (tem!=NULL)
    {
        cout<<tem->data;
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
    cout<<"执行插入"<<endl;
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

void LinkList::EndIns(int a[])
{
        cout<<"end insert"<<endl;
    if(first->next!=NULL) return;  
    Node *pNew;
	first = new Node;
	Node *pEnd = first;       //由于二者同为引用地址，所以此时二者完全一样
    
	for (int i = 0; i < 5; i++ )
	{
		pNew = new Node;
		pNew->data = a[i];

        /* 以第一遍循环举例
        由于前述原因，不管此处是pend->next还是first->next
        实际上都是 new Node的next
        所以，此时pnew会同时赋值给first和pend */
		pEnd->next = pNew;
        
		pEnd = pNew;
	}
	pEnd->next = nullptr;//让最后一个节点指向空
}

void LinkList::Delete(int n)
{
    Node *tem=first;
    int count=0;
    while (tem!=NULL&&count<n-1)    //查找第n-1个节点
    {
        tem=tem->next;
        count++;
    }
    if (tem==NULL||tem->next==NULL)
    {
        cout<<"erro"<<endl;
        return;
    }
    Node *tem2=tem;
    tem=tem->next;
    tem2->next=tem->next;
}

void LinkList::Update(int x,int n)
{
    Node *tem=first;
    for (int i = 0; i<n; i++)
    {
        tem=tem->next;
    }
    tem->data=x; 
}

int main()
{
    int arr[5]={1,2,3,4,5};
    LinkList list;
	LinkList *plist = &list;
    plist->EndIns(arr);
    plist->PrintList();
    plist->Update(9,2);
    plist->PrintList();
}