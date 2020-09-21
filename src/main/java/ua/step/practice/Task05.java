package ua.step.practice;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.Arrays;

/**
 * Задание: Заполнить массив на 10 элементов случайными числами
 * от -5 до +5. Посчитать количество повторяющихся значений.
 * Вывести на консоль только повторяющиеся элементы (больше одного повторения)
 * и количество повторений.
 * <p>
 * Пример:
 * 0 – 5 раз
 * 2 – 3 раза
 * 7 – 2 раза
 */
public class Task05 {
    public static void main(String[] args) {
        // TODO: не менять стоки ниже - нобходимо для тестирования @see ua.step.homework01.TaskTest05
        long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);

        int [] arr = new int[10];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(11) - 5;
        }
        Arrays.sort(arr);

        int count = 1;
        for(int i = 0; i < arr.length - 1; i++)
        {
            if(arr[i] == arr[i+1]) {
                count++;
            }
            else if(count > 1) {
                System.out.printf("%d - %d раза\n", arr[i], count);
                count = 1;
            }
        }
        if(count > 1)
        {
            System.out.printf("%d - %d раза\n", arr[arr.length-1], count);
        }
    }
}