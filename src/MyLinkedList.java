public class MyLinkedList<S> {


    protected int size = 0;

    protected Node<S> lastNode;
    protected Node<S> firstNode;

    public void add(S value) {
        if (firstNode == null) {
            firstNode = new Node<>(value, null, null);
            lastNode = firstNode;
            size++;
            return;
        }

        Node<S> newNode = new Node<>(value, lastNode, null);
        lastNode.next = newNode;
        lastNode = newNode;
        size++;
    }

    public Object remove(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        Node<S> neededNode = firstNode;
        int i = 0;
        while (i != index) {
            neededNode = neededNode.next;
            i++;
        }

        if (neededNode.equals(firstNode)) {
            firstNode = firstNode.next;
            firstNode.prev = null;
        } else {
            neededNode.prev.next = neededNode.next;
            if (!neededNode.equals(lastNode)) {
                neededNode.next.prev = neededNode.prev;
            } else {
                lastNode = lastNode.prev;
                lastNode.next = null;
            }
        }
        size--;
        return neededNode.data;
    }

    public Object get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        Node<S> neededNode = firstNode;
        int i = 0;
        while (i != index) {
            neededNode = neededNode.next;
            i++;
        }
        return neededNode.data;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    protected static class Node<S> {
        S data;
        Node<S> next;
        Node<S> prev;

        Node(S data, Node<S> prev, Node<S> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}