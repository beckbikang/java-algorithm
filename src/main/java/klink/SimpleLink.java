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
        //tlinklist();
        //tcylink();
        //tcylink2();
        tdlink();
    }

    public static void tdlink(){
        DoubleDlink doubleDlink = new DoubleDlink();

        doubleDlink.insertFirst(1);
        doubleDlink.insertFirst(2);
        doubleDlink.insertLast(4);
        doubleDlink.insertLast(5);

        doubleDlink.displayForward();
        doubleDlink.displayBackward();
    }

    public static void tcylink(){
        CycleLink linkList = new CycleLink();
        linkList.insertFirst(1,1.1);
        linkList.insertFirst(2,2.1);
        linkList.insertFirst(3,3.1);
        linkList.insertFirst(4,4.1);
        linkList.insertFirst(5,5.1);
        linkList.insertLast(6, 6.1);
        linkList.showList();
        linkList.deleteFirst();
        linkList.showList();
    }

    public static void tcylink2(){
        CycleLink linkList = new CycleLink();

        linkList.sortInsert(2,2.1);
        linkList.sortInsert(1,1.1);
        linkList.sortInsert(3,3.1);
        linkList.sortInsert(4,4.1);
        linkList.sortInsert(5,5.1);
        linkList.sortInsert(6, 6.1);
        linkList.showList();
        linkList.deleteFirst();
        linkList.showList();
    }


    public static void tlinklist(){
        LinkList linkList = new LinkList();
        linkList.insertFirst(1,1.1);
        linkList.insertFirst(2,2.1);
        linkList.insertFirst(3,3.1);
        linkList.insertFirst(4,4.1);
        linkList.insertFirst(5,5.1);
        linkList.show();
    }
}


class DoubleDlink{

    private Dlink first;
    private Dlink last;

    public DoubleDlink(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    //前面插入
    public void insertFirst(long i){
        Dlink dlink = new Dlink(i);
        if(isEmpty()){
            last = dlink;
        }else{
            first.pre = dlink;
        }
        dlink.next = first;
        first = dlink;
    }

    //最后插入
    public void insertLast(long i){
        Dlink dlink = new Dlink(i);
        if(isEmpty()){
            first = dlink;
        }else{
            last.next = dlink;
        }
        dlink.pre = last;
        last = dlink;
    }


    public Dlink delFirst(){
        Dlink tmp = first;
        if(isEmpty()){
            return null;
        }else{
            if(first.next == null){
                last = null;
            }else{
                first.next.pre = null;
            }
            first = first.next;
        }
        return tmp;
    }

    public Dlink delLast(){
        Dlink tmp = last;
        if(isEmpty()){
            return null;
        }else{
            if(first.next == null){
                first = null;
            }else{
                last.pre.next = null;
            }
            last = last.pre;
        }
        return tmp;
    }

    public boolean insertAfter(long key, long l){

        Dlink cur = first;
        while (cur.ldata != key){
            cur = cur.next;
            if(cur == null){
                return false;
            }
        }
        Dlink dlink = new Dlink(l);

        if(cur == last){
            dlink.next = null;
            last = cur;
        }else{
            dlink.next = cur.next;
            cur.next.pre = dlink;
        }
        dlink.pre = cur;
        cur.next = dlink;

        return true;
    }

    public Dlink deleteKey(long k){

        Dlink cur = first;
        while (cur.ldata != k){

            cur = cur.next;
            if(cur == null){
                return null;
            }
        }

        if(cur == first){
            first = cur.next;
        }else{
            cur.pre.next =
                    cur.next;
        }

        if(cur == last){
            last = cur.pre;
        }else{
            cur.next.pre = cur.pre;
        }


        return cur;
    }



    public void displayForward(){
        Dlink cur = first;
        System.out.println("displayForward");
        while (cur!= null){
            cur.showData();
            cur = cur.next;
        }
        System.out.println();
    }

    public void displayBackward(){
        Dlink cur = last;
        System.out.println("displayBackward");
        while (cur!= null){
            cur.showData();
            cur = cur.pre;
        }
        System.out.println();
    }








}


class Dlink{
    public long ldata;
    public Dlink next;
    public Dlink pre;
    public Dlink(long l){
        ldata = l;
    }
    public void showData(){
        System.out.println("ldata="+ldata);
    }
}



/**
 * 双端链表
 */
class CycleLink{
    private Link first;
    private Link last;

    public CycleLink(){
        first = null;
        last = null;
    }
    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int i,double d){
        Link link = new Link(i, d);
        if(isEmpty()){
            last = link;
        }
        link.next = first;
        first = link;
    }

    public void insertLast(int i,double d){
        Link link = new Link(i, d);
        if(isEmpty()){
            first = link;
        }else{
            last.next = link;
        }
        last = link;

    }


    public void sortInsert(int i,double d){
        Link link = new Link(i, d);
        if(isEmpty()){
            last = link;
            first = link;
        }else{
            Link pre,cur;
            pre = cur = first;
            while (cur != null){
                if(cur.i1 > i) break;
                pre = cur;
                cur = cur.next;
            }
            if(cur == first){
                link.next = first;
                first = link;
            }else if(cur == null){
                pre.next = link;
                link.next = cur;
            }else{
                last.next = link;
                last = link;
            }
        }

    }


    public Link deleteFirst(){
        if(isEmpty()){
            return null;
        }
        Link tmp = first;
        if(first.next == null){
            last = null;
        }
        first = first.next;

        return tmp;
    }

    public void showList(){
        System.out.println("show list");
        Link cur = first;
        while (cur != null){
            cur.showLink();
            cur = cur.next;
        }

        System.out.println("");
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


















