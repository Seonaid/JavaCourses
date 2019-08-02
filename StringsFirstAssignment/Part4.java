import edu.duke.*;

/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    public void findYouTubeLinks(){
        System.out.println("Start again");
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String word : ur.words()) {
            // process each word in turn
            String searchTerm = "youtube";
            int startIndex = word.toLowerCase().indexOf(searchTerm);
            if (startIndex != -1){
                int beginning = word.indexOf("\"");
                int ending = word.indexOf("\"", beginning+1);
                String link = word.substring(beginning+1, ending);
                System.out.println(link);
            }
        }           
    }
}
