import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyLL<Integer> myList = new MyLL<>();

        for(int i = 0; i< 10; i++) {
            myList.addFirst(i);
        }
        System.out.println("Done!");
    }
}