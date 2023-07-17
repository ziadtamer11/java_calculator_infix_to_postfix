package org.example;

public class Stack<C> {
    private Object[] data;
    private int top;

    public Stack() {
        this.data = new Object[10];
        this.top = -1;
    }

    public void push(Object item) {
        if (this.top == this.data.length - 1) {
            this.resize();
        }
        this.data[++this.top] = item;
    }

    public Object pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
        }
        return this.data[this.top--];
    }

    public Object peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
        }
        return this.data[this.top];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    private void resize() {
        Object[] newData = new Object[this.data.length * 2];
        System.arraycopy(this.data, 0, newData, 0, this.data.length);
        this.data = newData;
    }

    public int size() {
        return this.top + 1;
    }
}
