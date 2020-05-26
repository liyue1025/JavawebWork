public class test {
    public static void main(String[] args) {

        int pageNumber = 10;
        int rows = 5;

        String _start = String.valueOf((pageNumber-1)*rows); //开始查询的索引
        String[] start = new String[1];
        start[0] = _start;

        System.out.println(start[0]);
    }
}
