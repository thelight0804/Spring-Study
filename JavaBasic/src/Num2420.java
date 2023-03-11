/**
 * data: 23.03.11
 * problem: BAEKJOON 2420
 * project: 사파리월드
 * level: Bronze 5
 * author: thelight0804
 */
import java.util.Scanner;
public class Num2420{
  public static void main(String[] args){
    //input n, m
    Scanner sc = new Scanner(System.in);
    //(-2,000,000,000 ≤ N, M ≤ 2,000,000,000)
    long n = 0, m = 0;
    n = sc.nextInt();
    m = sc.nextInt();

    //output result
    System.out.printf("%d", Math.abs(n - m));
  }
}