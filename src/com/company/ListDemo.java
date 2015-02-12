package com.company;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: komarov.as
 * Date: 12.02.15
 * Time: 15:00
 * To change this template use File | Settings | File Templates.
 */
public class ListDemo {

    public static final int INT = 0;
    private Scanner in;
    private static final int IS_EMPTY_CODE = -1;
    private static final int ADD_TO_FIRST_CODE = 1;
    private static final int ADD_TO_last_CODE = 2;
    private static final int ADD_TO_POS_CODE = 3;
    private static final int DELETE_FIRST_CODE = 4;
    private static final int DELETE_LAST_CODE = 5;
    private static final int DELETE_AT_POS_CODE = 6;
    private static final int CLEAR_LIST_CODE = 7;
    private static final int GET_FIRST_DATA_CODE = 8;
    private static final int GET_LAST_DATA_CODE = 9;
    private static final int GET_DATA_AT_CODE = 10;
    private static final int GET_SIZE_CODE = 11;
    private static final int INDEX_OF_CODE = 12;
    private static final int PRINT_LIST_CODE = 13;
    private static final int EXIT_CODE = 0;

    private static void printMenu() {
        System.out.println(ADD_TO_FIRST_CODE + " - добавление числа в начало списка");
        System.out.println(ADD_TO_last_CODE + " - добавление числа в конец списка");
        System.out.println(ADD_TO_POS_CODE + " - добавление числа в позицию с заданным номером");
        System.out.println(DELETE_FIRST_CODE + " - удаление первого элемента списка");
        System.out.println(DELETE_LAST_CODE + " - удаление последнего элемента списка");
        System.out.println(DELETE_AT_POS_CODE + " - удаление элемента с заданным номером");
        System.out.println(CLEAR_LIST_CODE + " - очистка списка");
        System.out.println(GET_FIRST_DATA_CODE + " - получение первого числа списка");
        System.out.println(GET_LAST_DATA_CODE + " - получение последнего числа списка");
        System.out.println(GET_DATA_AT_CODE + " - получение числа списка с заданным номером");
        System.out.println(GET_SIZE_CODE + " - получение числа элементов списка");
        System.out.println(INDEX_OF_CODE + " - определение позиции первого вхождения в список заданного числа");
        System.out.println(PRINT_LIST_CODE + " - показать список");
        System.out.println(EXIT_CODE + " - Выход");
    }

    public void run() {
        in = new Scanner(System.in);
        List list = new List();
        do {
            printMenu();
            int cmd = in.nextInt();
            switch (cmd) {
                case EXIT_CODE:
                    break;
                case ADD_TO_FIRST_CODE:
                    list.addFirst(in.nextInt());
                    break;
                case ADD_TO_last_CODE:
                    list.addLast(in.nextInt());
                    break;
                case ADD_TO_POS_CODE:
                    int data = in.nextInt();
                    int pos = in.nextInt();
                    if (pos < 0 || pos > list.size()) {
                        System.out.println("Элемента с заданым номером не сущетвует");
                    } else {
                        list.addToPos(data, pos);
                    }
                    break;
                case DELETE_FIRST_CODE:
                    if (list.isEmpty()) {
                        System.out.println("Список Пуст");
                    } else {
                        list.deleteFirst();
                    }
                    break;
                case DELETE_LAST_CODE:
                    if (list.isEmpty()) {
                        System.out.println("Список Пуст");
                    } else {
                        list.deleteLast();
                    }
                    break;
                case DELETE_AT_POS_CODE:
                    if (list.isEmpty()) {
                        System.out.println("Список Пуст");
                    } else {
                        pos = in.nextInt();
                        if (pos < 0 || pos > list.size()) {
                            System.out.println("Элемента с заданым номером не сущетвует");
                        } else {
                            list.deleteAtPos(pos);
                        }
                    }
                    break;
                case CLEAR_LIST_CODE:
                    list.clearList();
                    break;
                case GET_FIRST_DATA_CODE:
                    if (list.isEmpty()) {
                        System.out.println("Список Пуст");
                    } else {
                        list.getFirstData();
                    }
                    break;
                case GET_LAST_DATA_CODE:
                    if (list.isEmpty()) {
                        System.out.println("Список Пуст");
                    } else {
                        list.getLastData();
                    }
                    break;
                case GET_DATA_AT_CODE:
                    if (list.isEmpty()) {
                        System.out.println("Список Пуст");
                    } else {
                        pos = in.nextInt();
                        if (pos < 0 || pos > list.size()) {
                            System.out.println("Элемента с заданым номером не сущетвует");
                        } else {
                            list.getDataAt(pos);
                        }
                    }
                    break;
                case GET_SIZE_CODE:
                    if (list.isEmpty()) {
                        System.out.println("Список Пуст");
                    } else {
                        System.out.println(list.size());
                    }
                    break;
                case INDEX_OF_CODE:
                    if (list.isEmpty()) {
                        System.out.println("Список Пуст");
                    } else {
                        System.out.println(list.indexOf(in.nextInt()));
                    }
                    break;
                case PRINT_LIST_CODE:
                    if (list.isEmpty()) {
                        System.out.println("Список Пуст");
                    } else {
                        list.printList();
                    }
                    break;
                default:
                    System.out.println("Неизвестная команда");
                    break;
            }
            if (cmd == EXIT_CODE) {
                break;
            }
        } while (true);
    }
}
