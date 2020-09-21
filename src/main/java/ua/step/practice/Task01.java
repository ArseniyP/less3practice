package ua.step.practice;

/**
 * Заполнить массив на 15 элементов числами Фибоначчи.
 * Вывести на консоль только четные элементы массива.
 * <p>
 * Пример вывода:
 * 1 2 5 13 34 89 233 610\
 *  1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711,
 */
public class Task01 {
    public static void main(String[] args) {

        final int len = 15;

        int [] arr = new int[len];

        arr[0] = 1;
        arr[1] = 1;

        for(int i = 2 ; i < arr.length ; i++)
        {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for(int i = 0 ; i < arr.length ; i = i + 2)
        {
            System.out.printf("%d ", arr[i]);
        }
    }
}