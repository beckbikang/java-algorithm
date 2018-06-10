package klink;

/**
 * @Author: bikang@staff.weibo.com
 * @Description:
 * @Date: Created in 下午10:23 2018/5/28
 * @Modified By:
 */
public class SimpleLink {

    public static void main(String args[]){
        System.out.println("tt");

        LinkList linkList = new LinkList();
        linkList.insertFirst(1,1.1);
        linkList.insertFirst(2,2.1);
        linkList.insertFirst(3,3.1);
        linkList.insertFirst(4,4.1);
        linkList.insertFirst(5,5.1);
        linkList.show();

    }
}

class Link{
    public int i1;
    public double d1;
    public Link next;
    public Link(int i, double d){
        this.i1 = i;
        this.d1 = d;
    }

    public void showLink(){
        System.out.println(
                "i1:"+i1+" d1:"+d1
        );
    }
}

class LinkList{

    private Link first;

    public LinkList()
    {
        first = null;
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    public void insertFirst(int id, double dd)
    {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link find(int key){
        Link current = first;

        while (current.i1 != key)
        {
            if(current.next == null){
                return null;
            }else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key)
    {
        Link current = first;
        Link pre = first;
        while (current.i1 != key){
            if(current.next == null){
                return null;
            }else{
                pre = current;
                current = current.next;
            }
        }
        if(current == first){
            first = first.next;
        }else {
            pre.next = current.next;
        }
        return current;
    }

    public Link deleteFirst()
    {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void show()
    {
        System.out.println("##start print linklist");
        Link current = first;
        while (current != null){
            current.showLink();
            current = current.next;
        }
        System.out.println("##end###");
    }

}


















