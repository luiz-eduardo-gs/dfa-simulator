package app;

import java.io.File;
import dfa.DfaSimulator;

public class Main 
{
    public static void main(String[] args)
    {
        DfaSimulator dfa = new DfaSimulator();
        
        /*Selecionando o arquivo contento a tabela de transicao e imprimindo o arquivo*/
        File tableFile = dfa.selectFile("Table File");
        String[] tableFields = dfa.readFile(tableFile);
        dfa.organizeVariables(tableFields);
        
//        System.out.println(dfa.getTransitions("q3").get(1));
        
        /*Selecionando o arquivo contento as strings teste e imprimindo o arquivo*/
        File stringsFile = dfa.selectFile("Strings File");
        String[] stringsFields = dfa.readFile(stringsFile);
        
        
        dfa.organizeInputs(stringsFields);
        dfa.validate();
    }
}
