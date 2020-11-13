public interface StackInterface<T> {
    boolean isEmpty();
    int size();
    void push(T item);
    T pop();
    T peek();
}
