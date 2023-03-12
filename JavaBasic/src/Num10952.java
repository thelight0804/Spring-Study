/**
 * data: 23.03.12
 * problem: BAEKJOON 10952
 * project: A+B - 5
 * level: Bronze 5
 * author: thelight0804
 */

import java.util.Scanner;

public class Num10952 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      if (a == 0) break; //exit
      //output a + b
      System.out.println(a + b);
    }
  }
}