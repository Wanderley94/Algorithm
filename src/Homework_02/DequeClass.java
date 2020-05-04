package Homework_02;

public class DequeClass<E> implements DequeInterface<E> {

    private int size;
    private E[] data;

    private int head;
    private int tail;
    private static final int DEFAULT_TAIL = 0;
    private static final int DEFAULT_HEAD = 0;

    @SuppressWarnings("unchecked")
    public DequeClass (int maxSize) {
            this.data = (E[]) new Object[maxSize];
            this.head = DEFAULT_HEAD;
            this.tail = DEFAULT_TAIL;
        }

    @Override
    public void addFirst(E e) {

        if (e == null) {
            throw new NullPointerException();
        }

        else{
            data[head = (head - 1) & (data.length - 1)] = e;
        }
    }

    @Override
    public void addLast(E e) {

        if (e == null) {
            throw new NullPointerException();
        }
        else{
            data[tail++] = e;

        }
    }

    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        addLast( e);
        return true;
    }

    @Override
    public void removeFirst()
    {
       data[data.length - 1] = null;
    }

    @Override
    public void removeLast() {


    }

    @Override
    public E pollFirst() {

        int h = head;
        @SuppressWarnings("unchecked")
        E result = (E) data[h];
        if (result == null)
            return null;
        data[h] = null;
        head = (h + 1) & (data.length - 1);
        return result;

    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return data[head];
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

}
