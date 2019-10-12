package app;

import java.io.File;
import dfa.DfaSimulator;
import nfa.NfaSimulator;

public class Main 
{
    public static void main(String[] args)
    {
        DfaSimulator dfa = new DfaSimulator();
        NfaSimulator nfa = new NfaSimulator();
        
        /*Selecionando o arquivo contento a tabela de transicao e imprimindo o arquivo*/
        File tableFileDFA = dfa.selectFile("Table File DFA");
        String[] tableFieldsDFA = dfa.readFile(tableFileDFA);
        dfa.organizeVariables(tableFieldsDFA);
        
        /*Selecionando o arquivo contento as strings teste e imprimindo o arquivo*/
        File stringsFileDFA = dfa.selectFile("Strings File");
        String[] stringsFieldsDFA = dfa.readFile(stringsFileDFA);
        
        dfa.organizeInputs(stringsFieldsDFA);
        dfa.validate();
        
        /*Selecionando o arquivo contento a tabela de transicao e imprimindo o arquivo*/
        File tableFileNFA = nfa.selectFile("Table File NFA");
        String[] tableFieldsNFA = nfa.readFile(tableFileNFA);
        nfa.organizeVariables(tableFieldsNFA);
        
//        /*Selecionando o arquivo contento as strings teste e imprimindo o arquivo*/
//        File stringsFileNFA = nfa.selectFile("Strings File");
//        String[] stringsFieldsNFA = nfa.readFile(stringsFileNFA);
//        
//        nfa.organizeInputs(stringsFieldsNFA);
//        nfa.validate();
    }
}
