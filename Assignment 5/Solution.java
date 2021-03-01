import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
            right = null;
            left = null;
        }
    }
    static class BinaryTree{
        Node root;

    }
    public void add(int value){
        
    }
   
    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {
        long [] sum;
        sum[0] = a[0];
        BinaryTree b;
        b.add(sum[0]);

        for(int i = 0; i < a.length; i++){
           long temp = 0;
           temp += a[i];
           long temp1 = 0;
           temp1 = temp%m;
           
           if(temp1 > max){
            max = temp1;
           }
        }
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
%
        bufferedWriter.close();

        scanner.close();
    }
}
