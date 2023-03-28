public class MyQueue <S> extends MyLinkedList<S> {
    public Object peek() {
        if (size != 0) {
            return firstNode.data;
        }
        return null;
    }

    public Object poll() {
        if (size != 0) {
            return remove(0);
        }
        return null;
    }
}
