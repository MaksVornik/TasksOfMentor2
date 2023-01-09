package Collections.MyLists;

public interface MyList<T> {
    void add(T element);// +
    void add(int index, T element);//+
    T remove(int index);
    T get(int index);// +
    T getFirst();//+
    T getLast();//+
    void set(int index, T element);//+

    int size();//+

}
