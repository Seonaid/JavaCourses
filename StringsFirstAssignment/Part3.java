
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
    
    public void testing(){
        Boolean test1 = twoOccurrences("any", "string");
        Boolean test2 = twoOccurrences("a", "banana");
        System.out.println(test1);
        System.out.println(test2);
    }
}
