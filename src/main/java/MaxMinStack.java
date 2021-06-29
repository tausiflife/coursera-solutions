import java.lang.Double;

public class MaxMinStack<T extends Comparable> {
    private Stack<T> data;
    private Stack<T> max;
    private Stack<T> min;

    public MaxMinStack() {
        this.data = new Stack<>();
        this.max = new Stack<>();
        this.min = new Stack<>();
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public int size() {
        return data.size();
    }

    public void push(T item) {
        this.data.push(item);
        if (this.data.size() == 1) {
            this.max.push(item);
            this.min.push(item);
            return;
        }
        T maxE = this.max.peek();
        this.max.push(maxE.compareTo(item) > 0 ? maxE : item);
        T minE = this.min.peek();
        this.min.push(minE.compareTo(item) < 0 ? minE : item);

    }

    public T pop() {
        T d = this.data.pop();
        this.max.pop();
        this.min.pop();
        return d;
    }

    public T peek() {
        return this.data.peek();
    }

    public T getMaximumElement() {
        return this.max.peek();
    }

    public T getMinimumElement() {
        return this.min.peek();
    }
}
