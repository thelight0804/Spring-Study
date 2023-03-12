/**
 * data: 23.03.12
 * problem: BAEKJOON 10872
 * project: 팩토리얼
 * level: Bronze 5
 * author: thelight0804
 */

import java.util.Scanner;

public class Num10872{
  public static void main(String[] args) {
    //input n
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int fac = 1;

    //calculation factorial
    for (int i = 1; i < n + 1; i++) {
      fac *= i;
    }

    System.out.println(fac);
  }
}