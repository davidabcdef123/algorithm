package arr;

/**
 * 数组新增
 */
public class MyArray {

    private int[] array;

    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 新增元素
     *
     * @param index
     * @param element
     */
    public void add(int index, int element) {
        if (index < 0 || index > size) {
            System.out.println("越界了");
            return;
        }

        //从右往左小混混，将元素诸葛向右挪动1位
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        //腾出来的地方存放新元素
        array[index] = element;
        size++;
    }

    /**
     * 输出
     */
    public void outPut() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(10);
        myArray.add(0, 1);
        myArray.add(1, 2);
        myArray.add(2, 3);
        myArray.add(3, 4);
        myArray.add(4, 5);

        myArray.add(1, 6);
        myArray.outPut();
    }
}
