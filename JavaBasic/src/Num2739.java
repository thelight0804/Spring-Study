/**
 * data: 23.03.12
 * problem: BAEKJOON 2739
 * project: 구구단
 * level: Bronze 5
 * author: thelight0804
 */

import java.util.Scanner;
public class Num2739{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for (int i = 1; i < 10; i++) {
      System.out.printf("%d * %d = %d\n", n, i, i * n);
    }
  }
}