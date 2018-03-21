/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author LeeYeHoo
 */
public class Final {
    /**
     * @param args the command line arguments
     */
    
    static Scanner s = new Scanner(System.in);
    
    //Default no of input
    static int size=5;
    
    public static void main(String[] args) throws IOException {
        
        printNotFoundWords();
        System.out.print("\nPress Enter to continue..");
        getSentence();
        printSquared();
        System.out.print("\nPress Enter to continue..");
        getSentence();
        reverseWordInSentence();
        System.out.print("\nPress Enter to continue..");
        getSentence();
        printNotPalindrome();
        System.out.print("\nPress Enter to continue..");
        getSentence();
        printByVowelNo();
    }
    
    
    public static String getSentence(){
        return s.nextLine();
    }
    public static String getWord(){
        return s.next();
    }
    public static int getInt(){
        return s.nextInt();
    }
    
    //No 1
    public static void printNotFoundWords(){
        System.out.println("\n\n\nNumber 1, show words that are not found in first sentence from second sentence\n");
        System.out.print("Input first sentence : ");
        String f_sentence = getSentence();
        System.out.print("\nInput second sentence : ");
        String s_sentence = getSentence();
        
        compareWords(createWordSet(f_sentence), createWordSet(s_sentence));
    }
    
    //Separate words in sentence and store it to an array
    public static String[] createWordSet(String sentence){
        String[] ret = new String[getWordNum(sentence)];
        String word = null;
        int index = 0, x;
        
        for(x=0;x<sentence.length();x++){
            char letter = sentence.charAt(x);
            if(letter != ' '){
                if(word == null){
                    word = letter+"";
                }else{
                    word = word+letter;
                }
            }else{
                ret[index++] = word;
                word = null;
            }
        }
        ret[index] = word;
        
        return ret;
    }
    
    //Gets the number of words in sentence by space
    public static int getWordNum(String s){
        int ret = 1;
        
        for(int x=0; x < s.length(); x++){
            if(s.charAt(x) == ' '){
                ret ++;
            }
        }
        
        return ret;
    }
    
    //Retrieve if there are same word. If not found, print
    public static void compareWords(String[] f_set, String[] s_set){
        int y;
        
        System.out.println("\nPrinting Words that are not found...\n\n");
        for(int x=0; x < s_set.length; x++){
            for(y=0; y < f_set.length && !s_set[x].equals(f_set[y]); y++){}
            if(y == f_set.length){
                System.out.println(s_set[x]);
            }
        }
    }
    
    //No 2
    public static void printSquared(){
        int[] num = new int[size];
        int [] asc = new int[size];
        int min = 9999;
        System.out.println("\n\n\n\nNumber 2, get 5 number and square it. If the number is not even or divisible by 3, Print it in ascending order.");
        for(int x=0; x < size; x++){
            System.out.print("\nInput numeber : ");
            num[x] = getInt();
            num[x] = num[x] * num[x];
        }
        
        sortAcs(num);
        System.out.println("\nPrinting Squared numbers...\n\n");
        for(int x=0; x <size; x++){
            if(num[x] % 2 !=0 && num[x] % 3 != 0){
                System.out.println(num[x]);
            }
        }
    }
    //Sort it by ascending order
    public static void sortAcs(int arr[]){
        for(int x=0; x < size-1; x++){
            for(int y=0; y < size-1; y++){
                if(arr[y] > arr[y+1]){
                    int temp = arr[y+1];
                    arr[y+1] = arr[y];
                    arr[y] = temp;
                    y--;
                }
            }
        }
    }
    
    //No 3
    public static void reverseWordInSentence(){
        System.out.println("\n\n\n\nNumber 3, get a sentence and word. Reverse the word and capitalize it from the sentence\n");
        System.out.print("Input sentence : ");
        String sentence = getSentence();
        System.out.print("\nInput word : ");
        String word = getWord();
        char[] replaced_sentence;
        
        if(sentence.length() >= word.length()){
            if(isFound(sentence, word)){
                replaced_sentence = replaceWord(sentence, word);
                System.out.println(replaced_sentence);
            }else{
                System.out.println("\nWord not Found!");
            }
        }else{
            System.out.println("\nPlease Input a word that exist");
        }
    }
    
    //Search if word is found from sentence
    public static boolean isFound(String sentence, String word){
        int index_sen = 0, y = 0;
        boolean isFound = false;
        
        for(int x=0; x < sentence.length(); x++){
            index_sen = x;
            for(y=0; y < word.length() && sentence.charAt(index_sen ++) == word.charAt(y); y++){}
            
            if(y == word.length()){
                isFound = true;
                break;
            }
        }
        
        return isFound;
    }
    
    //Replace the word found from sentence to given word
    public static char[] replaceWord(String sentence, String word){
        String reverse = reverseWord(word).toUpperCase();
        int i = indexFound(sentence, word);
        char[] ret = new char[sentence.length()];
        
        for(int x=0; x < sentence.length(); x++){
            ret[x] = sentence.charAt(x);
        }
        for(int x=0; x < reverse.length(); x++){
            ret[i++] = reverse.charAt(x);
        }
        
        return ret;
    }
    
    //Return the index where the word was found
    public static int indexFound(String sentence, String word){
        int index_sen = 0, y = 0, ret = 0;
        
        for(int x=0; x < sentence.length(); x++){
            ret = index_sen = x;
            for(y=0; y < word.length() && sentence.charAt(index_sen ++) == word.charAt(y); y++){}
            
            if(y == word.length()){
                break;
            }
        }
        
        return ret;
    }
    
    //Return a string after reversing given string
    public static String reverseWord(String word){
        String ret = null;
        for(int x=word.length()-1; x >= 0; x--){
            if(ret == null){
                ret = word.charAt(x)+"";
            }else{
                ret = ret+word.charAt(x);
            }
        }
        return ret;
    }
    
    //No 4
    public static void printNotPalindrome(){
        System.out.println("\n\n\nNumber 4, get sentence and list all the words that are not palindrome\n");
        System.out.print("Input sentence : ");
        String sentence = getSentence();
        
        printNotPalindrome(sentence);
    }
    
    //Print words that are not palindrome
    public static void printNotPalindrome(String sentence){
        String[] set = createWordSet(sentence);
        
        System.out.println("\nPrinting Words That are not Palindrome...\n\n");
        for(String s : set){
            if(!isPalindrome(s)){
                System.out.println(s);
            }
        }
    }
    
    //Check if the word is palindrome
    public static boolean isPalindrome(String s){
        return s.equals(reverseWord(s));
    }
    
    //No 5
    public static void printByVowelNo(){
        System.out.print("\n\n\nNumber 5, get a sentence and list all the words by number of vowels in ascending order\n");
        System.out.print("Input sentence : ");
        String sentence = getSentence();
        
        printByVowel(sentence);
    }
    
    //Print words by vowel number
    public static void printByVowel(String sentence){
        String set[] = createWordSet(sentence);
        
        arrangeByVowel(set);
        
        System.out.println("\nPrinting Words By number of vowels...\n\n");
        for(String s : set){
            System.out.println(countVowel(s) +" --- " + s);
        }
    }
    
    //Sort array by the number of vowels from word by ascending order
    public static void arrangeByVowel(String[] s){
        int curr_vow = 0, next_vow = 0;
        String temp;
        for(int x=0; x < s.length-1; x++){
            for(int y=0; y < s.length-1; y++){
                curr_vow = countVowel(s[y]);
                next_vow = countVowel(s[y+1]);
                if(curr_vow > next_vow){
                    temp = s[y+1];
                    s[y+1] = s[y];
                    s[y] = temp;
                    y--;
                }
            }
        }
    }
    
    //Return the number of vowels found from a word
    public static int countVowel(String s){
        int ret = 0;
        char temp;
        s = s.toLowerCase();
        for(int x=0; x < s.length(); x++){
            temp = s.charAt(x);
            
            if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u')
                ret++;
        }
        
        return ret;
    }
}
