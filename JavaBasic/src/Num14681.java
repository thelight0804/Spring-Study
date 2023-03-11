/**
 * data: 23.03.11
 * problem: BAEKJOON 14681
 * project: 사분면 고르기
 * level: Bronze 5
 * author: thelight0804
 */

import java.util.Scanner;

public class Num14681 {
  public static void main(String[] args) {
    //input x, y
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int y = sc.nextInt();

    //output Quadrant
    if (x > 0) {
      System.out.println((y > 0) ? '1' : '4');
    } else {
      System.out.println((y > 0) ? '2' : '3');
    }
  }
}