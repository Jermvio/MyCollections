public class MyStack <S> extends MyLinkedList <S> {
    public void push(S value) {
        add(value);
    }

    public Object peek() {
        if (size() != 0) {
            return lastNode.data;
        }
        return null;
    }

    public Object pop() {
        Object result = peek();
        remove(size() - 1);
        return result;
    }
}
