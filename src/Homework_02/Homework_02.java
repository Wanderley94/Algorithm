package Homework_02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Homework_02 {

    public static void main(String[] args) {

        reverseString(); // task_02

        DequeClass<String> deque = new DequeClass(10);

        deque.addFirst("Рамон");
        deque.addFirst("daddy");
        deque.addLast("Крипер");
        deque.addLast("1");
        deque.addLast("2");
        deque.addLast("3");
        deque.addLast("4");
        deque.addLast("5");
        deque.addLast("6");
        deque.addLast("7");
        deque.addLast("8");

        deque.pollFirst();
        deque.pollFirst();
        deque.pollFirst();

        deque.addFirst("daddy");



    }

    private static void reverseString() {

        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        char[] CharArray = str.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char element: CharArray) {
            stack.add(element);
        }

        StringBuilder sb = new StringBuilder();

        while (stack.size() != 0){
          sb.append(stack.pop());
        }

        System.out.println(sb);

    }

}
