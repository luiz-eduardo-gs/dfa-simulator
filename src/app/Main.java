package app;

import java.io.File;
import dfa.DfaSimulator;

public class Main 
{
    public static void main(String[] args)
    {
        DfaSimulator dfa = new DfaSimulator();
        
        /*Selecionando o arquivo contento a tabela de transicao e imprimindo o arquivo*/
        File tableFile = dfa.selectFile();
        String[] tableFields = dfa.readFile(tableFile);
        
        /*Selecionando o arquivo contento as strings teste e imprimindo o arquivo*/
        File stringsFile = dfa.selectFile();
        String[] stringsFields = dfa.readFile(stringsFile);
    }
}
