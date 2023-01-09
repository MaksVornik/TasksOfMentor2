package Collections.MyLists;

public class MyLinkedList<T> implements MyList<T> {
    public MyLinkedList() {
    }

    transient int size = 0;
    transient Node<T> first1;
    transient Node<T> last1;

    @Override
    public void add(T element) {//+
        final Node<T> l = last1;
        final Node<T> newNode = new Node<>(l,null,element);
        last1 = newNode;
        if (l == null) {
            first1 = newNode;
        }
        else {
            l.next1 = newNode;
        }
        size++;
    }




    private boolean isPositionIndex(int index) {//+
        return index >= 0 && index <= size;
    }

    private void checkPositionIndex(int index) {//+
        if (!isPositionIndex(index)) {
            System.out.println("Несуществующий индекс ");
        }
    }


    @Override
    public void add(int index, T element) {// + , но немного разобраться
        checkPositionIndex(index);
        if (index == size) {
            final Node<T> l = last1;
            final Node<T> newNode = new Node<>(l, null, element);
            last1 = newNode;
            if (l == null) {
                first1 = newNode;
            } else {
                l.next1 = newNode;
            }

        }else {
            Node<T> x = node(index);
            Node<T> p = x.prev1;
            Node<T> newNode = new Node<>(p,x,element);
            p.next1 = newNode;
            x.prev1 = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        Node<T> x = node(index);
        Node<T> n = x.next1;
        Node<T> p = x.prev1;
        if (index == 0) {
            n.prev1 = null;
            first1 = n;
        }else if (index == (size - 1)) {
            p.next1 = null;
            last1 = p;
        } else {
            n.prev1 = p;
            p.next1 = n;
            size--;

        }

        return (T) x.value1;
    }

    Node<T> node(int index) { /// Обьяснить этот метод Абдуле
        if (index < (size >> 1)) {
            Node<T> x = first1;
            for (int i = 0; i < index; i++) {
                x = x.next1;
            }
            return x;
        } else {
            Node<T> x = last1;
            for (int i = size - 1; i > index; i--) {

                x  = x.prev1;
            }
            return x;
        }

    }


    @Override
    public T get(int index) {//+
        checkPositionIndex(index);
        return (T) node(index).value1;
    }

    @Override
    public T getFirst() {//+
        return (T) first1;
    }

    @Override
    public T getLast() {//+
        return (T) last1;
    }

    @Override
    public void set(int index, T element) {//+
        checkPositionIndex(index);
        Node<T> x = node(index);
        T oldVal = x.value1;
        x.value1 = element;
//        Node<T> p = x.prev;

//        if (index == 0) {
//            Node<T> newNode = new Node<>(null,x.next,element);
//        }else {
//            Node<T> newNode = new Node<>(p,x.next,element);
//            p.next = newNode;
//            x.next.prev = newNode;
//        }


    }

    @Override
    public int size() {//+
        return size;
    }


    private static class Node<T> {
        private Node<T> prev1;
        private Node<T> next1;
        private T value1;

        public Node(Node<T> prev1, Node<T> next1, T value1) {
            this.prev1 = prev1;
            this.next1 = next1;
            this.value1 = value1;
        }

        public Node<T> getPrev() {
            return prev1;
        }

        public Node<T> getNext() {
            return next1;
        }

        public T getValue() {
            return value1;
        }
    }
    //StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("[");
//        for (int i = 0; i < size; i++) {
//            stringBuilder.append(elements[i]);
//            if (i != size - 1) {
//                stringBuilder.append(", ");
//            }
//        }
//        stringBuilder.append("]");
//        return stringBuilder.toString();
    @Override
    public String toString() {
        StringBuilder retStr1 = new StringBuilder("[");
        String retStr2 = "]";

        Node current = first1 ;
        while(current != null){
            retStr1.append(current.getValue());
            if (current.next1 != null) { // если у него следующего элемента нет , то не добавляем
                retStr1.append(", ");
            }
            current = current.getNext();

        }

        return retStr1 + retStr2;
    }

}