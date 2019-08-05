
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return result;
        }
        
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        if (stopIndex == -1){
            return result;
        }       
        result = dna.substring(startIndex, stopIndex+3);

        return result;
    }
    
    public void testSimpleGene(){
        // contains complete gene
        String dna1 = "TCGCCCTAGATGATAGATTTCTGCTACTCTCCTCATAAGCAGTAAGGTGTATCGAAAGTACAAGACTAGCCTTGCTAGCAA";
        String result = findSimpleGene(dna1);
        System.out.println("Gene 1: " + result);
        
        // No ATG
        String dna2 = "TCGCCCTAGATAATAGATTTCTGCTACTCTCCTCATAAGCAGTAAGGTGTATCGAAAGTACAAGACTAGCCTTGCTAGCAA";
        result = findSimpleGene(dna2);
        System.out.println("Gene 2: " + result);        
        
        // Starts but does not end
        String dna3 = "TCGCCCTAGATGATAGATTTCTGCTACTCTCCTCATAGGCAGTAGGGTGTATCGAAAGTACAAGACTAGCCTTGCTAGCAA";
        result = findSimpleGene(dna3);
        System.out.println("Gene 3: " + result);
        
        //Quiz question 1
        String dna4 = "AAATGCCCTAACTAGATTAAGAAACC";
        result = findSimpleGene(dna4);
        System.out.println("Gene 4 Quiz: " + result);
    } 
}
