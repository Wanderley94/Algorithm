package Homework_04.LinkIterator;

public class LinkIteratorApp {
    public static void main(String[] args) {

            LinkedList list = new LinkedList();

            LinkInterator itr = new LinkInterator(list);

            itr.insertAfter("Artem", 20);
            itr.insertBefore("Sergey", 10);

            itr.reset();

            itr.getCurrent();

            itr.deleteCurrent();

            list.display();
    }
}