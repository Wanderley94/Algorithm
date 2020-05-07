package Homework_04;

import java.util.Iterator;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E>, Iterable {

    private Entry<E> lastElement;

    @Override
    public void insertLast(E value) {
      Entry<E> entry = new Entry<>(value);

      if (isEmpty()) {
          firstElement = entry;
      }
      else {
          lastElement.next = entry;
      }

      lastElement = entry;
      size++;
    }

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size() == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();
        if (isEmpty()) {
            lastElement = null;
        }
        return removedValue;
    }

    @Override
    public boolean remove(E value) {
        Entry<E> current = firstElement;
        Entry<E> previous = null;
        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
        }
        else if (current == lastElement) {
            lastElement = previous;
            previous.next = null;
        }
        else {
            previous.next = current.next;
        }

        size--;
        return true;
    }

    @Override
    public Iterator iterator() {
        return new TwoLinkedListiterator();
    }

    private class TwoLinkedListiterator implements Iterator<E> {

        Entry currentElement = firstElement;
        Entry nextElement;
        E value;

        @Override
        public boolean hasNext() {

           if (currentElement == null) {
               return false;
           }else{
               return true;
           }
        }

        @Override
        public E next() {

            value = (E) currentElement.value;
            nextElement = currentElement.next;
            currentElement = nextElement;

            return value;
        }
    }
}
