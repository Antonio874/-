public class Stack<T> {
    private T[] data;
    private int size;
    // Конструктор класса, принимающий емкость стека
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }
    // Метод для добавления элемента в стек
    public void push(T element) {
        if (size < data.length) {
            data[size] = element;
            size++;
        } else {
            System.out.println("Stack overflow");
        }
    }
    // Метод для удаления элемента из стека
    public T pop() {
        if (size > 0) {
            size--;
            T element = data[size];
            return element;
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }
    // Метод для получения последнего добавленного элемента из стека без его удаления
    public T peek() {
        if (size > 0) {
            return data[size - 1];
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }
}
