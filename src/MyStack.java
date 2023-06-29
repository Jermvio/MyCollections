public class MyStack <S> extends MyLinkedList <S> {
    public void push(S value) {
        add(value);
    }

    public S peek() {
        if (size() != 0) {
            return lastNode.data;
        }
        return null;
    }

    public S pop() {
        S result = peek();
        remove(size() - 1);
        return result;
    }
}
