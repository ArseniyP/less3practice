package ua.step.practice;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Random;

/**
 * Задание: Заполнить массив на 10 элементов случайными числами
 * от -5 до +5. Посчитать количество уникальных значений
 * (встречающихся в массиве один раз). Вывести на консоль
 * значения уникальных элементов и индексы, под которыми
 * они находятся в массиве.
 *
 *  Пример:
 *      -5 -> 0 индекс
 *      3 -> 1 индекс
 *      4 -> 2 индекс
 *      2 -> 3 индекс
 *      0 -> 4 индекс
 *      -2 -> 5 индекс
 *      -4 -> 6 индекс
 *      -1 -> 9 индекс
 */
public class Task06 {

    static int searchIndx(int [][] nums, int num)
    {
        for(int i = 0; i < nums.length; i++)
            if(nums[i][0] == num)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        // TODO: не менять стоки ниже - нобходимо для тестирования @see ua.step.homework01.TaskTest06
        long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);

        int [] arr = new int[10];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(11) - 5;
        }

        int [][] nums = new int[11][];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = new int[2]; //[][0] - число, [][1] - кол-во повторений числа
            nums[i][0] = i - 5;
        }

        for(int i = 0; i < arr.length; i++) {
            nums[searchIndx(nums, arr[i])][1]++;
        }

        for(int i = 0 ; i < arr.length; i++)
        {
            if(nums[searchIndx(nums, arr[i])][1] == 1)
                System.out.printf("%d -> %d индекс\n", arr[i], i);
        }
    }
}