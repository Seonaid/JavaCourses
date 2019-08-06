import edu.duke.*;
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
            System.out.println("Found TAA" + currentGene);
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
    
    public StorageResource getAllGenes(String dna){
        int startIndex = dna.toUpperCase().indexOf("ATG");
        String gene = "";
        int endGene = 0;
        StorageResource allGenes = new StorageResource();
        System.out.println("start again");
        while(startIndex != -1){
            gene = findGene(dna);
            System.out.println(gene);
            allGenes.add(gene);
            endGene = dna.indexOf(gene);
            dna = dna.substring(endGene + gene.length(), dna.length());
            //System.out.println("New DNA: " + dna);
            startIndex = dna.toUpperCase().indexOf("ATG");
        }
        return allGenes;
    }
    
    public int howMany(String stringa, String stringb){
        int num = 0;
        int startIndex = stringb.indexOf(stringa);
        //System.out.println(stringa + " in " + stringb);
        stringa = stringa.toLowerCase();
        stringb = stringb.toLowerCase();        
        while (startIndex != -1){
            num = num+1;
            //System.out.println("total counted: ");
            //System.out.println(num);
            startIndex = stringb.indexOf(stringa, startIndex + stringa.length());
            //System.out.println(startIndex);
        }
        return num;
    } 
    
    public double cgRatio(String dna){
        String searchChar = "c";
        double numCs = howMany(searchChar, dna.toLowerCase());
        searchChar = "g";
        double numGs = howMany(searchChar, dna.toLowerCase());
        
        return (numCs + numGs)/dna.length();
    }
    
    public int countCTG(String dna){
        return howMany("ctg", dna.toLowerCase());
    }
    
    public void processGenes(StorageResource sr){
        int numItems = 0;
        int numHighCG = 0;
        int numLong = 0;
        int longest = 0;
        for (String s: sr.data()){
            numItems = numItems + 1;
            if (s.length() > longest) longest = s.length();
            if(s.length() > 9){
               System.out.println("Gene longer than 9: " + s);
               numLong = numLong + 1;
            }
            
            if (cgRatio(s) > 0.35){
                System.out.println("high cgRatio: " + s);
                numHighCG = numHighCG + 1;
            }
        }
        System.out.println("Total number of lines: " + numItems);
        System.out.println("Number of long genes: " + numLong);
        System.out.println("Total number of highCG ratios: " + numHighCG);
        System.out.println("longest gene is: " + longest);
    }
    
    public void processDNAFile(){
        FileResource fr = new FileResource("dna/brca1line.fa");
        String dna = fr.asString();
        System.out.println(howMany("atg", dna));
        StorageResource sr = getAllGenes(dna);
        //processGenes(sr);
    }
    
    public void testGetAllGenes(){
        String testDNA = "ccaaatggtgcgaaggtgaatgtaataacataatccttggtttggccgttatttctataata";
        System.out.println("stop codon is tga, two genes");
        getAllGenes(testDNA);
        
        // no atg = no gene
        testDNA = "ccaaatagtgcgaaggtgatattggataacataatccttggtttggccgttatttctataata";
        System.out.println("No startCodon");
        StorageResource genes = getAllGenes(testDNA);
        for (String g: genes.data()){
            System.out.println(g);
        }
        
        // second atg in BRCA1
        testDNA = "atgttcccaatagtagacataaaagtcttcgcacagtgaaaactaaa";
        genes = getAllGenes(testDNA);        
        for (String g: genes.data()){
            System.out.println("BRCA1: " + g + g.length());
        }
        
        // first ATG doesn't actually have a gene, then it has to jump to
        // next ATG
        testDNA = "atgcctattggatccaaagagaggccaacattttttgaatgttcccaatagtagacataaaagtcttcgcacagtgaaaactaaa";
        System.out.println("Looking for gene: " + findGene(testDNA));
        
        System.out.println("All tests run");
    }
    
    public void testCgRatio(){
        System.out.println("\nStart testCgRatio");
        String testDNA = "ATGCCATAG";
        System.out.println("ATGCCATAG expects 4/9 = 0.44444... " + cgRatio(testDNA));
        
        
        System.out.println("All tests run");
    }
    
    public void testCountCTG(){
        System.out.println("\nStart testCountCTG");
        String testDNA = "CTGAAATAGCTGAAGGTA";
        System.out.println("CTGAAATAGCTGAAGGTA expects 2... " + countCTG(testDNA));
    }
    
    public void testProcessGenes(){
        System.out.println("\nStart testProcessGenes");        
        
        StorageResource sr = new StorageResource();
        sr.add("CTGAAATAGCTGAAGGTA");
        sr.add("ATGCCATAG");
        sr.add("atggtgcgaaggtga");
        sr.add("atgtaa");
        
        processGenes(sr);
    }
    
    public void lookForGene(){
        System.out.println(findGene("atgttcccaatagtagacataaaagtcttcgcacagtgaaaactaaa"));
    }
}
