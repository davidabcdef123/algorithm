package array;

/**
 * 数组
 */
public class MyArray {

    private int[] array;

    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 新增元素-不扩容
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
     * @param:
     * @return:
     * @Description: 在已满的数据里增加数据导致的扩容
     * @date 2020/8/3 20:32
     */
    public void changeLength(int index, int element) {
        if (index < 0 || index > size) {
            System.out.println("越界了");
            return;
        }
        //满了 扩容 <=
        if (array.length == size) {
            resize();
        }
        //size和index的关系
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;

    }

    /**
     * @param:
     * @return:
     * @Description: 扩容
     * @date 2020/8/3 21:54
     */
    public void resize() {
        int[] arrayNew = new int[array.length * 2];
        //原数组，起始位置，新数组，起始位置，复制多长
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    public void delete(int index) {
        if (index < 0 || index > size) {
            System.out.println("越界了");
            return;
        }
        for (int i = index; i < size-1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    /**
     * 输出
     */
    public void outPut() {
        System.out.println("array长度=" + array.length + "  array大小=" + size);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        //新增-不扩容
       /* MyArray myArray = new MyArray(10);
        myArray.add(0, 1);
        myArray.add(1, 2);
        myArray.add(2, 3);
        myArray.add(3, 4);
        myArray.add(4, 5);
        myArray.add(1, 6);
        myArray.outPut();*/
        //新增-扩容
        /*MyArray myArray = new MyArray(4);
        myArray.changeLength(0, 1);
        myArray.changeLength(1, 2);
        myArray.changeLength(2, 3);
        myArray.changeLength(3, 4);
        myArray.changeLength(4, 5);
        myArray.changeLength(1, 6);
        myArray.outPut();*/
        //删除
        MyArray myArray = new MyArray(5);
        myArray.changeLength(0, 0);
        myArray.changeLength(1, 1);
        myArray.changeLength(2, 2);
        myArray.changeLength(3, 3);
        myArray.changeLength(4, 4);
        myArray.changeLength(5, 5);
        myArray.delete(1);
        myArray.outPut();

    }
}
