public class MyQueue <S> extends MyLinkedList<S> {
    public S peek() {
        if (size != 0) {
            return firstNode.data;
        }
        return null;
    }

    public S poll() {
        if (size != 0) {
            return remove(0);
        }
        return null;
    }
}
