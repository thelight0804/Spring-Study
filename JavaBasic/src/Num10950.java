/**
 * data: 23.03.12
 * problem: BAEKJOON 10950
 * project: A+B - 3
 * level: Bronze 5
 * author: thelight0804
 */

import java.util.Scanner;

public class Num10950{
  public static void main(String[] args){
    //input test case
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    //output a + b for test case
    for (int i = 0; i < t; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.println(a + b);
    }
  }
}