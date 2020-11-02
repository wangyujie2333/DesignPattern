package com.javabasic;

/**
 * @author wangyuj
 * @date 2020/10/19
 **/
public class Stack {
    public static void main(String[] args) throws Exception {
        ArrayStack<Integer> arrayStack = new ArrayStack();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(2);
        arrayStack.push(2);
        arrayStack.push(2);
        arrayStack.push(4);
        System.out.println(arrayStack.pop());
    }

    public static class QueueStack<Item> {
        
    }
    public static class ArrayStack<Item> {
        Item[] items = (Item[]) new Object[1];
        private int N = 0;

        public void push(Item item) {
            N++;
            reSize();
            items[N] = item;
        }

        public Item pop() throws Exception {
            if (isEmpty()) {
                throw new Exception();
            }
            reSize();
            Item item = items[N];
            items[N] = null;
            N--;
            return item;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public void reSize() {
            if (N >= items.length) {
                Item[] itemscopy = (Item[]) new Object[items.length << 1];
                System.arraycopy(items, 0, itemscopy, 0, items.length);
                items = itemscopy;
            }
            if (N > 0&&N <= items.length/4) {
                Item[] itemscopy = (Item[]) new Object[items.length >> 1];
                System.arraycopy(items, 0, itemscopy, 0, items.length);
                items = itemscopy;
            }
        }
    }
}
