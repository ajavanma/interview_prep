package bootDev;

// implementing Stack class in Java using ArrayList to handle dynamic resizing:

import java.util.ArrayList;
import java.util.List;

// In Java, <T> represents a type parameter, making the class or interface generic. 
// This means that you can use these classes and interfaces with different types without the need to create multiple versions of them for each datatype.
// can operate on objects of various types
// It replaces the need for casting and can reduce the risk of ClassCastException.
// <T> is a placeholder for the type that the class or method will operate on. This type will be specified when an object of the generic class is created or
//  when the generic method is called.

public class Stack<T> {    // The class is generic, allowing it to handle stacks of any type of object.
    private List<T> items;

    // Constructor
    public Stack() {
        items = new ArrayList<>();
    }

    public void push(T item) {
        items.add(item);        // add items to the end of the list, which serves as the top of the stack.
    }

    // remove the top item from the stack and return it, the same type that the stack holds
    public T pop() {
        if (!items.isEmpty()) {
            return items.remove(items.size() - 1);
        }
        return null; 
    }

    // view the top item of the stack 
    public T peek() {
        if (!items.isEmpty()) {
            return items.get(items.size() - 1);
        }
        return null; 
    }

    public int size() {
        return items.size();
    }

    // Main method to test Stack implementation
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("item 1");
        stack.push("item 2");
        stack.push("item 3");

        System.out.println("Top item (peek): " + stack.peek());  // Should print item 3
        System.out.println("Stack size: " + stack.size());       // Should print 3
        System.out.println("Popping top item: " + stack.pop());  // Should remove and print item 3
        System.out.println("New top item: " + stack.peek());     // Should print item 2
        System.out.println("New stack size: " + stack.size());   // Should print 2
    }
}
