package com.company;

/**
 * Индексация с 0.
 * [0, size-1]
 * <p/>
 * User: komarov.as
 * Date: 09.02.15
 * Time: 15:38
 */
public class List {

    List() {
        first = null;
    }

    private int size;
    private Item first;

    /**
     *
     */
    private static class Item {
        int data;
        Item next;
        Item prev;

        Item(int data, Item prev, Item next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Добавляет элемент data в начало списка.
     *
     * @param data добавляемый элемент
     */
    public void addFirst(int data) {
        first = new Item(data, null, first);
        size++;
    }

    /**
     * Добавляет элемент data в конец списока.
     *
     * @param data добавляемый элемент
     */
    public void addLast(int data) {
        if (isEmpty()) {
            first = new Item(data, null, null);
        } else {
            Item currentItem = itemAt(size - 1);
            currentItem.next = new Item(data, currentItem, null);
        }
        size++;
    }

    /**
     * Возвращает элемент на позиции pos.
     *
     * @param pos номер позиции
     * @return элемент на позиции pos
     */
    private Item itemAt(int pos) {
        Item currentItem = first;

        for (int i = 0; i < pos; i++) {
            currentItem = currentItem.next;

        }
        return currentItem;
    }

    /**
     * Добавляет элемент data в позицию pos.
     *
     * @param data добавляемый элемент
     * @param pos  позиция куда добавляется элемент
     */
    public void addToPos(int data, int pos) {
        Item currentItem = itemAt(pos);
        currentItem = new Item(data, currentItem.prev, currentItem);
        size++;
    }

    /**
     * Удвляет первый элемент списка.
     */
    public void deleteFirst() {
        first = first.next;
        first.prev = null;
        size--;
    }

    /**
     * Удаляет последний жлемент списка.
     */
    public void deleteLast() {
        Item currentItem = itemAt(size - 1);
        currentItem.prev.next = null;
        currentItem.prev = null;
        size--;
    }

    /**
     * Удаляет элемент в указанной позиции pos.
     *
     * @param pos позиция удаляемого элемента
     */
    public void deleteAtPos(int pos) {
        Item currentItem = itemAt(pos);
        currentItem.prev.next = currentItem.next;
        currentItem.next.prev = currentItem.prev;
        size--;
    }

    /**
     * Очищает список.
     */
    public void clearList() {
        first = null;
        size = 0;
    }

    /**
     * Возвращает первый эелемент.
     *
     * @return первый элемент
     */
    public int getFirstData() {
        return first.data;
    }

    /**
     * Возвращает последний элемент.
     *
     * @return последний элемент
     */
    public int getLastData() {
        Item currentItem = itemAt(size - 1);
        return currentItem.data;
    }

    /**
     * Возвращает элемент с указанной позицией pos.
     *
     * @param pos номер возвращаемого элемента
     * @return элемент списка
     */
    public int getDataAt(int pos) {
        Item currentItem = itemAt(pos);
        return currentItem.data;
    }

    /**
     * Возвращает размер списка.
     *
     * @return размер списка
     */
    public int size() {
        return size;
    }

    /**
     * Возвращает позицию pos искомого элемента data.
     *
     * @param data искомый элемент
     * @return позиция искомого элемента
     */
    public int indexOf(int data) {
        Item currentItem = first;
        int pos = 0;
        while ((currentItem != null) && (currentItem.data != data)) {
            pos++;
        }
        if (currentItem == null) {
            pos = -1;
        }
        return pos;
    }

    /**
     * Выводит список на экран.
     */
    public void printList() {
        Item current = first;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    /**
     * Возвращает true если список пуст и false если нет.
     *
     * @return
     */
    public Boolean isEmpty() {
        return first == null;
    }
}
