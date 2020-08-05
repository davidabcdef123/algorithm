package queue;

/**
 * @param:
 * @return:
 * @Description: 循环队列
 * @date 2020/8/5 21:49
 */
public class MyQueue {

    private int[] array;

    //首索引
    private int front;
    //尾索引
    private int rear;

    public MyQueue(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 入队
     *
     * @param element 入队的元素
     */
    public void enQueue(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满！");
        }
        array[rear] = element;
        //计算新的队尾
        rear = (rear + 1) % array.length;
    }

    /**
     * 出队
     */
    public void deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空！");
        }
        //int deQueueElement = array[front];
        //计算新的首位
        front = (front + 1) % array.length;
       // return deQueueElement;
    }

    /**
     * 输出队列
     */
    public void output() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue(6);
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        myQueue.enQueue(5);
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.enQueue(6);
        myQueue.enQueue(7);
        myQueue.enQueue(8);
        myQueue.output();
    }
}
