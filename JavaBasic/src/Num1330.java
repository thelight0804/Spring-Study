/**
 * data: 23.03.09
 * problem: BAEKJOON 1330
 * project: 두 수 비교하기
 * level: Bronze 5
 * author: thelight0804
 */

import java.util.Scanner;

public class Num1330 {
  public static void main(String[] args) {
    int a = 0, b = 0;

    //input a, b
    Scanner sc = new Scanner(System.in);
    a = sc.nextInt();
    b = sc.nextInt();

    //compare
    if (a > b) System.out.println('>');
    else if (a < b)
      System.out.println('<');
    else System.out.println("==");
  }
}