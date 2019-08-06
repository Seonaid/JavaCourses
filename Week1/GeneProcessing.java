import edu.duke.*;

/**
 * Write a description of GeneProcessing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GeneProcessing {

    public int howMany(String stringa, String stringb){
        // returns how many times stringa occurs in stringb
        int num = 0;
        stringa = stringa.toLowerCase();
        stringb = stringb.toLowerCase();
        int startIndex = stringb.indexOf(stringa);
        // as long as there are still some stringa-s left
        while (startIndex != -1){
            num = num+1; // add one to the count
            startIndex = stringb.indexOf(stringa, startIndex + stringa.length());
        }
        return num;
    }
    
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        dna = dna.toLowerCase();
        stopCodon = stopCodon.toLowerCase();
        int stopIndex = dna.indexOf(stopCodon, startIndex+1);
        System.out.println("Stop index for: " + stopCodon + stopIndex);
        while (stopIndex != -1){
            int geneLength = stopIndex+2 - startIndex;
            if (geneLength % 3 == 0){
                return stopIndex + 3;
            } else {
                stopIndex = dna.indexOf(stopCodon, stopIndex+1);
            }
        }
        return dna.length();
    }

    public String findGene(String dna){
        String result = "";
        String currentGene = "";
        int startIndex = dna.toLowerCase().indexOf("atg");
        //System.out.println("Starting at: " + Integer.toString(startIndex));
        int stopIndex = 0;
        if (startIndex == -1){
            return result;
        } else {
            int stopTAA = findStopCodon(dna, startIndex, "taa");
            System.out.println("At stopCodon: " + stopTAA);
            int stopTAG = findStopCodon(dna, startIndex, "tag");        
            int stopTGA = findStopCodon(dna, startIndex, "tga");
            int end = Math.min(stopTAA, stopTAG);
            end = Math.min(stopTGA, end);
            result = dna.substring(startIndex, end);
            //System.out.println(currentGene);            
            //System.out.println(currentGene);            
        };
       
        return result;
    };

    public int countGenes(String dna){
        int startIndex = dna.toUpperCase().indexOf("ATG");
        String gene = "";
        int endGene = 0;
        int numGenes = 0;
        
        while(startIndex != -1){
            gene = findGene(dna);
            numGenes = numGenes + 1;
            endGene = dna.indexOf(gene);
            dna = dna.substring(endGene + gene.length(), dna.length());
            startIndex = dna.toUpperCase().indexOf("ATG");
        };
        return numGenes;
    }    
    
    public void processGenes(StorageResource sr){
        // takes storage resource that contains list of strings and
        // prints any strings longer than 9
        // counts number of strings longer than 9
        // prints any strings that have cgRatio larger than 0.35
        // counts number of strings with cgRatio larger than 0.35
        // prints the longest string in sr
    }
    
    public String readFile(String filename){
        // open DNA file as FileResource
        // convert file resource to string and return
        FileResource fr = new FileResource(filename);
        String dna = fr.asString();
        System.out.println(dna.length());
        return dna;
    }
    
    public void testProcessGenes(){
        // DNA string with no genes longer than 9 characters
        // DNA string with some genes longer than 9 characters
        // DNA string with cgRatio > 0.35
        // DNA string with cgRatio <= 0.35
        
        
        
    }
    
    public void runThisMethod(){
        String filename = "brca1line.fa";
        String dna = readFile(filename);
        int numGenes = howMany("AGT", dna);
        System.out.println("There are this many startCodons: " + numGenes);
        // TAA stopCodons...
        // int numTAA = howMany("TAA", dna);
        System.out.println("There are this many TAAs: " + howMany("TAA", dna));
        System.out.println("First gene is: " + findGene(dna));
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
    
    public void testCountGenes(){
        System.out.println("\nStart again");
        String testDNA = "ccaaatggtgcgaaggtgaatgtaataacataatccttggtttggccgttatttctataata";
        //System.out.println("stop codon is tga, two genes");
        int geneCount = countGenes(testDNA);
        if (geneCount != 2) System.out.println("error for two genes");
        
        
        // no atg = no gene
        testDNA = "ccaaatagtgcgaaggtgatattggataacataatccttggtttggccgttatttctataata";
        //System.out.println("No startCodon");
        geneCount = countGenes(testDNA);
        if (geneCount != 0) System.out.println("error in nil gene");
        
        System.out.println("All tests run");
    };        
}
