package ua.step.practice;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.Scanner;


/**
 * Задание: Заполнить массив размерности n случайными строчны-
 * ми (маленькими) латинскими буквами. Подсчитать, сколько раз встреча-
 * ется каждая буква. Вывести буквы, которые встречаются
 * больше 3 раз. n – задается с клавиатуры.
 * <p>
 * Пример вывода:
 * g - 4 раза
 * l - 4 раза
 * s - 5 раз
 * v - 5 раз
 * x - 5 раз
 */
public class Task08 {

    static int getIndexByChar(int [][] chars, char ch)
    {
        for (int i = 0; i < chars.length; i++)
            if(chars[i][0] == ch)
                return i;
        return -1;
    }

    static  void printRes(int [] data)
    {
        System.out.printf("%c - %d раз", data[0], data[1]);
        int lastNum = data[1] % 10;
        int secNum = data[1] % 100 / 10;
        if(secNum == 1)
            return;
        switch(lastNum)
        {
            case 2:
            case 3:
            case 4:
                System.out.print("а");
        }
    }

    public static void main(String[] args) {
        // TODO: не менять стоки ниже - нобходимо для тестирования @see ua.step.homework01.TaskTest08
        long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int len = scanner.nextInt();

        char[] arr;

        arr = new char[len];

        for(int i = 0; i < arr.length; i++)
            arr[i] = (char)('a' + rnd.nextInt(26));

        int [][] countChars = new int[26][];

        for(int i = 0; i < countChars.length; i++) {
            countChars[i] = new int [2];
            countChars[i][0] = 'a' + i;
        }

        for(char ch : arr)
        {
            countChars[getIndexByChar(countChars, ch)][1]++;
        }

        //Вывод результата

        int lastIndex = -1; //индекс последней буквы, которая повторяется больше 3 раз

        for(int i = countChars.length - 1; i >= 0; i--)
        {
            if(countChars[i][1] > 3)
            {
                lastIndex = i;
                break;
            }
        }

        for(int i = 0 ; i < lastIndex; i++)
        {
            if(countChars[i][1] > 3) {
                printRes(countChars[i]);
                System.out.print("\n");
            }
        }

        if(lastIndex > -1)
        {
            printRes(countChars[lastIndex]);
        }
    }
}
