package ua.step.practice;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Задание: Есть массив размером n элементов и заполненный
 * случайными числами в диапазоне от 0 до 100.
 * Необходимо разделить этот массив на массивы меньшего
 * размера в каждом из которых будет находиться не менее m элементов из
 * большого массива.
 * Значения n и m вводятся с клавиатуры пользователем.
 * Вывести на экран исходный массив и разделенный массив.
 *
 * Пример вывода:
 *
 * Исходный массив [35, 80, 39, 79, 63, 32, 89, 22, 29, 29]
 * Результат
 * [35, 80, 39]
 * [79, 63, 32]
 * [89, 22, 29]
 * [29]
 */
public class Task11 {

    public static void main(String[] args) {
        // TODO: не менять стоки ниже - нобходимо для тестирования @see ua.step.homework01.TaskTest09
        long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массивов через пробел: ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr;

        arr = new int[n];

        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = rnd.nextInt(101);
        }

        int len = n / m;
        int lastLen = n % m;
        int [][] arr2;

        if(lastLen > 0)
        {
            arr2 = new int[len + 1][];
            arr2[len] = new int[lastLen];
        }
        else
        {
            arr2 = new int[len][];
        }
        for(int i = 0; i < len; i++)
            arr2[i] = new int[m];


        int indxArr = 0;
        for(int i = 0; i < arr2.length; i++)
            for(int j = 0; j < arr2[i].length; j++)
                arr2[i][j] = arr[indxArr++];

        System.out.println("Исходный массив " + Arrays.toString(arr));
        System.out.println("Результат");
        for(int i = 0; i < arr2.length; i++)
            System.out.println(Arrays.toString(arr2[i]));
    }
}
