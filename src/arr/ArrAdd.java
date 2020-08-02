package arr;

/**
 * 数组新增
 */
public class ArrAdd {

    public static String[] array = new String[]{"1", "2", "3", "4", "5"};

    public static void main(String[] args) {
        add("7", 1);
    }

    private static void add(String element, int index) {
        if (index < 0 || index > array.length) {
            System.out.println("数组越界");
            return;
        }
        for (int i = 0; i < array.length; i++) {

        }


    }
}
