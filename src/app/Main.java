package app;

import java.io.File;
import dfa.DfaSimulator;
import javax.swing.JOptionPane;
import nfa.NfaSimulator;

public class Main 
{
    public static void main(String[] args)
    {
        DfaSimulator dfa = new DfaSimulator();
        NfaSimulator nfa = new NfaSimulator();

        try
        {
            File tableFileDFA = dfa.selectFile("Table File DFA");
            if(tableFileDFA != null)
            {
                /*Selecionando o arquivo contento a tabela de transicao e imprimindo o arquivo*/
                String[] tableFieldsDFA = dfa.readFile(tableFileDFA);
                dfa.organizeVariables(tableFieldsDFA);
                
                File stringsFileDFA = dfa.selectFile("Strings File");
                if(stringsFileDFA != null)
                {
                    /*Selecionando o arquivo contento as strings teste e imprimindo o arquivo*/
                    String[] stringsFieldsDFA = dfa.readFile(stringsFileDFA);
                    dfa.organizeInputs(stringsFieldsDFA);
                    dfa.validate();
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Não foi possível realizar essa operação no momento,"
                        + " pois a tabela do autômato não foi selecionada."); 
        }
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try
        {
            File tableFileNFA = nfa.selectFile("Table File NFA");
            if(tableFileNFA != null)
            {
                /*Selecionando o arquivo contento a tabela de transicao e imprimindo o arquivo*/
                String[] tableFieldsNFA = nfa.readFile(tableFileNFA);
                nfa.organizeVariables(tableFieldsNFA);
                
                File stringsFileNFA = nfa.selectFile("Strings File");
                if(stringsFileNFA != null)
                {
                    /*Selecionando o arquivo contento as strings teste e imprimindo o arquivo*/
                    String[] stringsFieldsNFA = nfa.readFile(stringsFileNFA);
                    nfa.organizeInputs(stringsFieldsNFA);
                    nfa.validate();
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Não foi possível realizar essa operação no momento,"
                        + " pois a tabela do autômato não foi selecionada.");  
        }
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
    }
}
