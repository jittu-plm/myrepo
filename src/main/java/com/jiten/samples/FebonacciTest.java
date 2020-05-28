package com.jiten.samples;

/**
 * In Prokarma - for TMobile
 */

public class FebonacciTest {

    public static void main(String[] args) {
        fibenocci();
        System.out.println();
        System.out.println("Recursive febo..");
        recFebo(0, 1);
        System.out.println();
        System.out.println(recFactorial(5));
        System.out.println(factorial(5));
        System.out.println();
        reverseEachWord("Jiten is a nice boy");
        System.out.println();
        reverseEachWordRec("Jiten is a nice boy");
    }


    private static void fibenocci(){
        int sum = 0;
        int first = 0;
        int second = 1;
        for (int i=0; i<10; i++){
            sum = first + second;
            first = second;
            second = sum;
            System.out.println("febonoacci = " + sum);
        }
    }


    /**
     * find febonacci numbers in recursive way
     * @param f
     * @param s
     */
    private static void recFebo(int f, int s){
        int sum = f + s;
        f = s;
        s = sum;
        System.out.println("febo = " + sum);
        if(sum > 100)
            return;
        recFebo(f,s);
    }

    /**
     * finds factorial of a number in recursive way
     * @param n
     * @return
     */
    private  static  int  recFactorial(int n){
        if(n >= 1)
            return n * recFactorial(n-1);
        else
            return 1;
    }

    /**
     * factorial in interative way
     * @param n
     * @return
     */
    private static  int factorial(int n){
        int fac = 1;
        for (int i=1; i <= n; i++){
            fac *= i;
        }
        return  fac;
    }

    private  static  void reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0 ; i <words.length; i++){
            char[] word = words[i].toCharArray();
            for (int j= word.length-1;j>=0;j--){
                System.out.print(word[j]);
            }
            System.out.println();
        }
    }

    private  static  void reverseEachWordRec(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0 ; i <words.length; i++){
            char[] word = words[i].toCharArray();
            recWord(word,word.length);
            System.out.print(' ');
        }
    }

    private static char[]  recWord(char[] word, int n){
        if(n <= 0)
            return null;
        System.out.print(word[n-1]);
        return recWord(word,n-1);
    }
}
