/**
 * data: 23.03.11
 * problem: BAEKJOON 9498
 * project: 시험 성적
 * level: Bronze 5
 * author: thelight0804
 */

import java.util.Scanner;

public class Num9498 {
  public static void main(String[] args) {
    // input score
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();

    // output result
    if (num > 89) {
      System.out.println('A');
    } else if (num > 79) {
      System.out.println('B');
    } else if (num > 69) {
      System.out.println('C');
    } else if (num > 59) {
      System.out.println('D');
    } else {
      System.out.println('F');
    }
  }
}