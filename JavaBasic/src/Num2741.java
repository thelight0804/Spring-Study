/**
 * data: 23.03.11
 * problem: BAEKJOON 2741
 * project: N 찍기
 * level: Bronze 5
 * author: thelight0804
 */

import java.io.*;

public class Num2741 {
  public static void main(String[] args) throws IOException {
    //input n
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    //output result
    for (int i = 1; i < n+1; i++)
      System.out.println(i);

    br.close();
  }
}