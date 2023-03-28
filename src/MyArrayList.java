import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList<S> {

    private Object[] array;
    private int cursor = 0;

    MyArrayList(int initialCapacity) {
        this.array = new Object[initialCapacity];
    }

    MyArrayList() {
        this(10);
        ArrayList<Integer> a = new ArrayList<>();
    }

    public void add(S value) {
        array[cursor] = value;
        cursor++;
        if (cursor < array.length) {
            array = Arrays.copyOf(array, array.length + 10);
        }
    }

    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, size() - 1 - index);
        cursor--;
    }

    public void clear() {
        array = new Object[10];
        cursor = 0;
    }

    public int size() {
        return cursor;
    }

    public Object get(int index) {
        if (index > cursor) {
            return null;
        }
        return array[index];
    }
}
