/**
 * data: 23.03.12
 * problem: BAEKJOON 10951
 * project: A+B - 4
 * level: Bronze 5
 * author: thelight0804
 */

import java.util.Scanner;

public class Num10951 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNextInt()) { //NoSuchElementException
      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.println(a + b);
    }
  }
}