
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        String result = "";
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1){
            return result;
        }
        
        int stopIndex = dna.indexOf(stopCodon, startIndex+3);
        if (stopIndex == -1){
            return result;
        }       
        result = dna.substring(startIndex, stopIndex+3);

        return result;
    }
    
    public void testSimpleGene(){
        // contains complete gene
        String dna1 = "TCGCCCTAGATGATAGATTTCTGCTACTCTCCTCATAAGCAGTAAGGTGTATCGAAAGTACAAGACTAGCCTTGCTAGCAA";
        String result = findSimpleGene(dna1, "ATG", "TAA");
        System.out.println("Gene 1: " + result);
        
        // No ATG
        String dna2 = "TCGCCCTAGATAATAGATTTCTGCTACTCTCCTCATAAGCAGTAAGGTGTATCGAAAGTACAAGACTAGCCTTGCTAGCAA";
        result = findSimpleGene(dna2, "ATG", "TAA");
        System.out.println("Gene 2: " + result);        
        
        // Starts but does not end
        String dna3 = "TCGCCCTAGATGATAGATTTCTGCTACTCTCCTCATAGGCAGTAGGGTGTATCGAAAGTACAAGACTAGCCTTGCTAGCAA";
        result = findSimpleGene(dna3, "ATG", "TAA");
        System.out.println("Gene 3: " + result);
        
        String dna4 = "TCGCCCTAGATGATAGATTTCTGCTACTCTCCTCATAAGCAGTAAGGTGTATCGAAAGTACAAGACTAGCCTTGCTAGCAA";
        dna4 = dna4.toLowerCase();
        result = findSimpleGene(dna4, "atg", "taa");
        System.out.println("Gene 4: " + result);        
    } 
}
