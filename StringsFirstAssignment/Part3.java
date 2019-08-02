
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public Boolean twoOccurrences(String stringa, String stringb){
        int startIndex = stringb.indexOf(stringa);
        if (startIndex == -1){
            return false;
        }
        return true;
    }
    
    public String lastPart(String stringa, String stringb){
        int startIndex = stringb.indexOf(stringa);
        if (startIndex == -1){
            // if stringa does not occur in stringb, return all of stringb
            return stringb;
        }
        // start at the end of stringa and go to the end of stringb
        return stringb.substring(startIndex+stringa.length(), stringb.length());
    }
    
    public void testing(){
        Boolean test1 = twoOccurrences("any", "string");
        Boolean test2 = twoOccurrences("a", "banana");
        System.out.println(test1);
        System.out.println(test2);
        
        String test3 = lastPart("any", "string");
        System.out.println(test3);
        String test4 = lastPart("an", "banana");
        System.out.println(test4);

        String test5 = lastPart("a", "banana");
        System.out.println(test5);
        
    }
}
