package ua.step.practice;

import java.util.Scanner;

/**
 * Программа должна выводить слово Yes для симметрич-
 * ного массива и слово No – для несимметричного. Симме-
 * тричным считается массив, в котором значения элементов с
 * конца равно значению элементов с начала. Массив заполняется
 * пользователем вручную.
 * Размер массива (количество строк и колонок) задается при
 * запуске программы.
 *
 * Примеры значений для симметричного массива:
 * <p>
 * 1, 2, 3, 2, 1
 * 2, 2, 3, 2, 2
 * 1, 3, 2, 3, 1
 * 5, 4, 3, 4, 5
 *
 *
 */
public class Task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размернось массива (сколько строк и колонок): ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] marr;

        marr = new int[rows][];
        for(int i = 0; i < marr.length; i++)
            marr[i] = new int[cols];

        for(int i = 0; i < marr.length; i++)
            for(int j = 0; j < marr[i].length; j++)
                marr[i][j] = scanner.nextInt();

        int steps;
        boolean isSim = true;
        for(int i = 0; i < marr.length; i++){
            steps = marr[i].length / 2;
            for(int j = 0; j < steps; j++)
            {
                if(marr[i][j] != marr[i][marr[i].length - j - 1])
                {
                    isSim = false;
                    break;
                }
            }
            if(!isSim)
                break;
        }

        if(isSim)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
