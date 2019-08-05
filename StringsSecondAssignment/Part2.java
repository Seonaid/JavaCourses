
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa, String stringb){
        int num = 0;
        int startIndex = stringb.indexOf(stringa);
        //System.out.println(stringa + " in " + stringb);
        
        while (startIndex != -1){
            num = num+1;
            //System.out.println("total counted: ");
            //System.out.println(num);
            startIndex = stringb.indexOf(stringa, startIndex + stringa.length());
            //System.out.println(startIndex);
        }
        return num;
    }
    
    public void testHowMany(){
        // howMany("A", "AAA") with single repeating letter counts letters
        int test1 = howMany("A", "AAA");
        if (test1!= 3) System.out.println(test1);
        
        // howMany("AA", "AAAAAA") with double repeating letter counts repeats
        int test2 = howMany("AA", "AAAAA");
        if (test2!= 2) System.out.println("error with double repeating letter");
        // howMany("AA", "AABAAB") returns 2
        int test3 = howMany("AA", "AABAAB");
        if (test3!= 2) System.out.println("error with non-repeating letter");
        
        // howMany("AB", "AjioageHAGOAB AB AB AB") returns 4
        int test4 = howMany("AB", "AjioageHAGOAB AB AB AB");
        if (test4!= 4) System.out.println("error with spaces");
    
        System.out.println("howMany tests finished");
    }
}
