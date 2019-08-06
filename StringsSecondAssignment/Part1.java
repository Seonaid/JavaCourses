
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public int findStopCodon(String dna,int startIndex, String stopCodon){
        int stopIndex = dna.toUpperCase().indexOf(stopCodon.toUpperCase(), startIndex+1);
        //System.out.println(dna.length());
        while (stopIndex != -1){
            int geneLength = stopIndex - startIndex;
            if (geneLength % 3 == 0){
                //System.out.println("returning index of");
                //System.out.println(stopIndex + 3);
                return stopIndex + 3;
            } else {
                //System.out.println("updating stopCodon location");
                stopIndex = dna.indexOf(stopCodon, stopIndex+1);
            }
        }
        return dna.length();
    }
    
    public String findGene(String dna){
        String result = "";
        String currentGene = "";
        int startIndex = dna.toUpperCase().indexOf("ATG");
        //System.out.println("Starting at: " + Integer.toString(startIndex));
        int stopIndex = 0;
        if (startIndex == -1){
            return result;
        } else {
            stopIndex = findStopCodon(dna, startIndex, "TAA");
            currentGene = dna.substring(startIndex, stopIndex);
            //System.out.println(currentGene);
            stopIndex = findStopCodon(dna, startIndex, "TAG");
            String nextGene = dna.substring(startIndex, stopIndex);
            if (nextGene.length() < currentGene.length()){
                currentGene = nextGene;
            };
            //System.out.println(currentGene);            
            stopIndex = findStopCodon(dna, startIndex, "TGA");
            nextGene = dna.substring(startIndex, stopIndex);
            if (nextGene.length() < currentGene.length()){
                currentGene = nextGene;
            };
            //System.out.println(currentGene);            
            //System.out.println(currentGene);            
        };
       
        return currentGene;
    };
    
    public void printAllGenes(String dna){
        int startIndex = dna.toUpperCase().indexOf("ATG");
        String gene = "";
        int endGene = 0;
        System.out.println("start again");
        while(startIndex != -1){
            gene = findGene(dna);
            System.out.println(gene);
            endGene = dna.indexOf(gene);
            dna = dna.substring(endGene + gene.length(), dna.length());
            //System.out.println("New DNA: " + dna);
            startIndex = dna.toUpperCase().indexOf("ATG");
        };
    };
    
    public void testFindStopCodon(){
        String testDNA = "ccaaatggtgcgaaggtgatgttggataacataatccttggtttggccgttatttctataata";
        int stopIndex = findStopCodon(testDNA, 4, "taa");
        System.out.println(testDNA.substring(4, stopIndex));
        
        stopIndex = findStopCodon(testDNA, 4, "tag");
        System.out.println(testDNA.substring(4, stopIndex));
        
    }
    
    public void testFindGene(){
        String testDNA = "";
        String gene = "";
        // no atg = no gene
        testDNA = "ccaaatagtgcgaaggtgatattggataacataatccttggtttggccgttatttctataata";
        gene = findGene(testDNA);
        System.out.println("No ATG test: " + gene);
 
        // no stopCodon = no gene
        testDNA = "ccaaatagtgcgaaggtcatattggagaacatcatccttggtttggccgttatttctatcata";
        gene = findGene(testDNA);
        System.out.println("No stopCodon: " + gene);
        
        // Multiple valid nested stopCodons
        testDNA = "ccaaatggtgcgaaggtgatgttggataacataatccttggtttggccgttatttctataata";
        gene = findGene(testDNA);
        System.out.println("Multiple valid genes: " + gene);
        
        // One gene at start
        testDNA = "atgtaataacataatccttggtttggccgttatttctataata";
        gene = findGene(testDNA);
        System.out.println("One gene at start: " + gene); 
        
        testDNA = "AATGCTAACTAGCTGACTAAT";
        gene = findGene(testDNA);
        System.out.println("Quiz question 1: " + gene);
    };
    
    public void testPrintAllGenes(){
        String testDNA = "ccaaatggtgcgaaggtgaatgtaataacataatccttggtttggccgttatttctataata";
        System.out.println("stop codon is tga, two genes");
        printAllGenes(testDNA);
        
        // no atg = no gene
        testDNA = "ccaaatagtgcgaaggtgatattggataacataatccttggtttggccgttatttctataata";
        System.out.println("No startCodon");
        printAllGenes(testDNA);
        
        // from 
        testDNA = "atgcctattggatccaaagagaggccaacattttttga";
        System.out.println("BRAC excerpt: ");
        printAllGenes(testDNA);
        
        System.out.println("All tests run");
    };   
}
