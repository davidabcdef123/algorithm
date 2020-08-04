package link;

public class MyLinkedList {

    //头节点指针
    private Node head;
    //尾部节点指针
    private Node last;
    //链表实际长度
    private int size;

    /**
     * @param:
     * @return:
     * @Description: 插入
     * @date 2020/8/4 22:19
     */
    public void insert(int data, int index) throws Exception {
        if (index > size || index < 0) {
            System.out.println("越界了");
            throw new Exception();
        }
        Node insertNode = new Node(data);
        if (size == 0) {
            head = insertNode;
            last = insertNode;
        }
        //头部
        else if (index == 0) {
            insertNode.next = head;
            head = insertNode;
        } else if (index > 0 && index < size) {
            //中间
            Node prevNode = get(index - 1);
            insertNode.next = prevNode.next;
            prevNode.next = insertNode;
        } else if (index == size) {
            //尾部
            last.next = insertNode;
            last = insertNode;
        }
        size++;
    }

    /**
     * 获取
     *
     * @param index
     * @return
     */
    public Node get(int index) throws Exception {
        if (index < 0 || index > size) {
            System.out.println("越界了");
            throw new Exception();
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * @param:
     * @return:
     * @Description: 节点
     * @date 2020/8/4 22:19
     */
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * @param:
     * @return:
     * @Description: 根据位置删除
     * @date 2020/8/4 22:20
     */
    public void delete(int index) throws Exception {
        if (index < 0 || index > size) {
            System.out.println("越界了");
            throw new Exception();
        }
        //暂时不考虑空集合的情况
        //头部
        if (index == 0) {
            head = head.next;
        } else if (index > 0 && index < size) {
            //中间
            //preNode.next = preNode.next.next;
            Node preNode = get(index - 1);
            preNode.next = preNode.next.next;
        } else if (index == size - 1) {
            //尾部节点
            Node prevNode = get(index - 1);
            prevNode.next = null;
            last = prevNode;
        }
        size--;
    }

    public void outPut() {
        Node node = head;
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        try {
            MyLinkedList myLinkedList = new MyLinkedList();
            myLinkedList.insert(0, 0);
            myLinkedList.insert(1, 1);
            myLinkedList.insert(2, 2);
            myLinkedList.insert(3, 3);
            myLinkedList.delete(2);
            myLinkedList.outPut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
