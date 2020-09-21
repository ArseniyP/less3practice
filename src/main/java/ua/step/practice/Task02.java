package ua.step.practice;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

/**
 * Задание: Заполнить массив на 30 элементов случайными числами
 * от -70 до +50.
 * Найти минимальный элемент и максимальный элементы и вывести их на консоль через пробел
 */
public class Task02 {
    public static void main(String[] args) {
        // TODO: не менять стоки ниже - необходимо для тестирования @see ua.step.homework.TaskTest02
        long seed = 0;// args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);

        int [] arr = new int[30];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(121) - 70;
        }

        int min;
        int max;
        min = max = arr[0];

        for (int elem:arr) {
            if(elem < min)
                min = elem;
            if(elem > max)
                max = elem;
        }

        System.out.printf("%d %d", min, max);

    }
}