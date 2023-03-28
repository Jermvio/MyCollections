import javax.security.auth.login.AccountLockedException;

public class MyHashMap <K, V> {

    private Node<K, V> firstNode;
    private int size = 0;

    public void put(K key, V value) {
        if (firstNode == null) {
            firstNode = new Node<>(key, value, null);
            size++;
            return;
        }

        Node<K, V> lastNode = firstNode;
        while (lastNode.next != null) {
            if (lastNode.key.equals(key)) {
                return;
            }
            lastNode = lastNode.next;
        }
        lastNode.next = new Node<>(key, value, null);
        size++;
    }

    public Object get(K key) {
        if (size == 0) {
            return null;
        }
        Node<K, V> neededNode = firstNode;
        while (!neededNode.key.equals(key) && neededNode.next != null) {
            neededNode = neededNode.next;
        }
        if (neededNode.key.equals(key)) {
            return neededNode.value;
        } else {
            return null;
        }
    }

    public void remove(K key) {
        if (size == 0) {
            return;
        }
        Node<K, V> neededNode = firstNode;
        if (firstNode.key.equals(key)) {
            firstNode = firstNode.next;
            size--;
            return;
        }
        Node<K, V> lastNode = firstNode;
        while (!neededNode.key.equals(key) && neededNode.next != null) {
            lastNode = neededNode;
            neededNode = neededNode.next;
        }
        if (neededNode.key.equals(key)) {
            lastNode.next = lastNode.next.next;
            size--;
        }
    }

    public void clear() {
        firstNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    protected static class Node<K, V> {
        K key;
        V value;
        MyHashMap.Node<K, V> next;

        Node(K key, V value, MyHashMap.Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
