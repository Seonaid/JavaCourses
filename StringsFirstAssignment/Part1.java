
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        int startIndex = dna.indexOf("ATG");
        
        return "gene goes here";
    }
    
    public void testSimpleGene(){
        // contains complete gene
        String dna1 = "TCGCCCTAGATGATAGATTTCTGCTACTCTCCTCATAAGCAGTAAGGTGTATCGAAAGTACAAGACTAGCCTTGCTAGCAA";
        String dna2 = "TCGCCCTAGATGATAGATTTCTGCTACTCTCCTCATAGGCAGTAGGGTGTATCGAAAGTACAAGACTAGCCTTGCTAGCAA";
    } 
}
