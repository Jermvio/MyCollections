public class MyHashMap<K, V> {

    private Node<K, V>[] table;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = (Node<K, V>[]) new Node[16]; // Початковий розмір масиву
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> newNode = new Node<>(key, value, null);

        if (table[index] == null) {
            table[index] = newNode;
            size++;
            return;
        }

        Node<K, V> currentNode = table[index];
        while (currentNode.next != null) {
            if (currentNode.key.equals(key)) {
                return; // Ключ вже існує, нічого не робимо
            }
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> currentNode = table[index];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }

        return null; // Ключ не знайдений
    }

    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> currentNode = table[index];

        if (currentNode != null && currentNode.key.equals(key)) {
            table[index] = currentNode.next;
            size--;
            return;
        }

        Node<K, V> prevNode = currentNode;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                prevNode.next = currentNode.next;
                size--;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    protected static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
