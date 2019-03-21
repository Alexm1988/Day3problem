package Day6;

import org.testng.annotations.Test;

import java.util.Arrays;

public class codingex {
    @Test
//print odd numbers 1 to 20.
    public void testPrintOddNumbers() {
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 1) System.out.println(i);
        }
    }

    @Test
    //print even numbers 1 to 10
    public void testPrintEvenNumbers() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) System.out.println(i);
        }
    }

    @Test
    // write a code to check if the words are palindromes
    // noon or racecar
    public boolean isPalindrome(String s) {
        s = "noon";
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }

    @Test
    //print "hello world" at even numbers
    public void printHelloIfEven() {
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) System.out.println(i + " = Hello World");
        }
    }
    @Test
    //swap two numbers in an array
    public void swapTwoNumbersInArray(){
        int [] array = {1,2,3,4};
        swap(array,1,2);
        System.out.println(Arrays.toString(array));}
     private void swap(int[] array, int indexL, int indexR) {
        int temp = array[indexL];
        array[indexL] = array[indexR];
        array[indexR] = temp;
     }
    @Test
//swap two numbers in an array
    public void SwapTwoNumbersInArray() {
        int[] array = {21,22,33,44,56,65};
        swap1(array,3,4);
        System.out.println(Arrays.toString(array));
    }
    private void swap1(int[] array, int indexL, int indexR) {
        int temp = array[indexL];
        array[indexL] = array[indexR];
        array[indexR]= temp;
    }

    @Test
//count the number of letters 'l' in a string
    public void countLetterNumber() {
        String input = "hello world";
        int result = 0;
        for(char eachChar : input.toCharArray()) {
            if (eachChar== 'l') result++;
        }
        System.out.println(result);
    }
    @Test
//count the number of letters 'l' in a string
    public void countLetterNumber1() {
        String input = "hello world";
        int result1 = 0;
        char[] array = input.toCharArray();
        System.out.println(array);
        for(int i = 0; i< array.length; i++) {
            if (array[i] == 'l') result1++;}
            System.out.println(result1);

        }


    }







