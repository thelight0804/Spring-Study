/**
 * data: 23.03.11
 * problem: BAEKJOON 2753
 * project: 윤년
 * level: Bronze 5
 * author: thelight0804
 */

import java.util.Scanner;
public class Num2753{
  public static void main(String[] args){
    //input year
    Scanner sc = new Scanner(System.in);
    int year = sc.nextInt();

    //output result
    if(year % 4 == 0 && (year % 100 !=0 || year % 400 == 0)){
      System.out.println(1);
    }else{
      System.out.println(0);
    }
  }
}