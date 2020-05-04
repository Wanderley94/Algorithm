package Homework_02;

public interface DequeInterface<E>  {

    void addFirst(E e);

    void addLast(E e);

    boolean offerFirst(E e);


    boolean offerLast(E e);

    void removeFirst();


    void removeLast();

   E pollFirst();


    E pollLast();


    E getFirst();

    E getLast();

    E peekFirst();

    E peekLast();

    boolean removeFirstOccurrence(Object o);

    boolean removeLastOccurrence(Object o);

    public int size();

}
