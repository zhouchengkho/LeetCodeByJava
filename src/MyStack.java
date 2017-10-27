import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoucheng on 10/26/17.
 */
public class MyStack {
    private List<Integer> ls;

    public MyStack() {
        ls = new LinkedList<>();
    }

    public MyStack(int[] arr) {
        ls = new LinkedList<>();
        buildStack(arr);
    }

    public void buildStack(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            ls.add(arr[i]);
        }
    }

    public Integer pop() {
        Integer a = null;
        if(ls.size() > 0) {
            a = ls.get(ls.size()-1);
            ls.remove(ls.size()-1);
        }
        return a;
    }

    public void push(Integer a) {
        ls.add(a);
    }

    public boolean isEmpty() {
        return ls.size() == 0;
    }

    public void print(boolean even) {
        while(ls.size() != 0) {
            Integer a = pop();
            if(isEven(a) && even) {
                System.out.println(a);
            } else if(!isEven(a) && !even) {
                System.out.println(a);
            }
        }
    }

    private boolean isEven(Integer a) {
        return a%2 == 0;
    }

}
