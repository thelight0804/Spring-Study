/**
 * data: 23.03.12
 * problem: BAEKJOON 2438
 * project: 별 찍기 - 1
 * level: Bronze 5
 * author: thelight0804
 */

import java.util.Scanner;
public class Num2438 {
  public static void main(String[] args){
    //input n
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    //output &
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < i + 1; j++) {
        System.out.print("*"); //add *
      }
      System.out.println(); //next line
    }
  }
}