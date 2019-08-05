
/**
 * Write a description of Question1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Question1 {
   public void findAbc(String input){
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           String found = input.substring(index+1, index+4);
           System.out.println(found);
           System.out.println("Part 2... Index is currently: " + index);
           index = input.indexOf("abc",index+3);
           System.out.println("Index after updating is: " + index);
       }
   }

   public void test(){
       System.out.println("\nStartAgain 3");
       //findAbc("abcd");
       //findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
       findAbc("abcabcabcabca");
       //findAbc("abcbabccabcd");
   }
}
