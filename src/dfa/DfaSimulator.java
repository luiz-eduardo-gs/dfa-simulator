package dfa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DfaSimulator
{
    private String[] alphabet;
    private String currentState;
    private final ArrayList<String> inputs = new ArrayList<>();
    private String initialState;
    private String[] finalStates;
    private final ArrayList<String> states = new ArrayList();
    private final Map<String, List<String>> transitions = new HashMap<>();
    
    /*Faz com que as strings lidas como entrada sejam organizadas em uma lista*/
    public void organizeInputs(String[] inputs)
    {
        this.inputs.addAll(Arrays.asList(inputs));
    }
    
    
    /*Valida se o automato aceita a string ou nao*/
    public void validate()
    {
        StringBuilder sb = new StringBuilder();
        for(String test : inputs)
        {
            sb.append(test).append(": ");
            currentState = getInitialState();
            System.out.printf(currentState + "->");
            sb.append(currentState).append("->");
            for(String c : test.split(","))
            {
                currentState = transitions.get(currentState).get(Integer.parseInt(c));
                System.out.printf(currentState + "->");
                sb.append(currentState).append("->");
            }
            sb.append("  ");
            /*Valida se o automato aceita a string teste*/
            for(String finalState : getFinalStates())
            {
                if(currentState.equals(finalState)){
                    System.out.println("ACEITA");
                    sb.append("ACEITA");
                }
                else{
                    System.out.println("NAO ACEITA");
                    sb.append("NAO ACEITA");
                }
            }
            sb.append(System.lineSeparator());
        }
        saveFile(sb.toString());
    }
    
    /*Associa estados e transicoes a variaveis*/
    public void organizeVariables(String[] tableString)
    {
        /*Coloca o alfabeto do automato em inputSimbols*/
        setAlphabet(tableString[0].split(","));
        
        /*Coloca o estado inicial do automato em initialState*/
        setInitialState(tableString[1].replace(">", ""));
        
        /*Coloca os estados finais do automato em finalStates*/
        setFinalStates(tableString[2].replace("*", "").split(","));
        
        /*Coloca os estados do automato na lista states*/
        String[] tableStringAux = tableString;
        tableStringAux[0] = null;
        tableStringAux[1] = null;
        tableStringAux[2] = null;
        
        for(String obj : tableStringAux)
        {
            if(obj != null)
                states.add(obj.split(":")[0]);
        }
        
        /*Coloca as transicoes do automato no map transitions*/
        tableStringAux = tableString;
        tableStringAux[0] = null;
        tableStringAux[1] = null;
        tableStringAux[2] = null;
        
        ArrayList<String> auxList = new ArrayList<>();
        
        for (String str : tableStringAux) {
            if (str != null) {
                auxList.add(str.split(":")[1]);
            }
        }
        
        for(int i=0;i<states.size();i++)
        {
            transitions.put(states.get(i), Arrays.asList(auxList.get(i).split(",")));
        }
        
//        /*Imprime cada atributo da classe*/
//        for(String obj : getInputSimbols()){
//            System.out.printf("Alphabet:" + obj + "\n");
//        }
//        
//        System.out.println("Initial State: " + getInitialState());
//        
//        for(String obj : getFinalStates()){
//            System.out.printf("Final states: " + obj + "\n");
//        }
//        for(String obj : states){
//            System.out.printf("States: " + obj + "\n");
//        }
//        
//        for(String key : transitions.keySet())
//            System.out.println(transitions.get(key));
    }
    
    /*Salvar o arquivo de validacao dos testes*/
    public void saveFile(String content)
    {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showSaveDialog(null);
        if(returnValue == JFileChooser.APPROVE_OPTION)
        {
            try(FileWriter fw = new FileWriter(jfc.getSelectedFile()+".txt")) {
                fw.write(content);
            }
            catch(IOException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    
    /*Seleciona o arquivo de texto atraves de um JFileChooser*/
    public File selectFile(String dialogTitle)
    {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Open " + dialogTitle);
        File selectedFile = null;
        int returnValue = jfc.showOpenDialog(null);
        if(returnValue == JFileChooser.APPROVE_OPTION)
        {
            selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
//            JOptionPane.showMessageDialog(null, selectedFile.getAbsolutePath());
        }
        if(selectedFile != null)
            return selectedFile;
        else
            return null;
    }
    
    /*Le o arquivo texto*/
    public String[] readFile(File selectedFile)
    {
        StringBuilder content = new StringBuilder();

        if(selectedFile != null)
        {
            try(BufferedReader br = new BufferedReader(new FileReader(selectedFile.getAbsolutePath())))
            {
                String line;

                while((line = br.readLine()) != null)
                {
                    content.append(line);
                    content.append(System.lineSeparator());
                }

//                JOptionPane.showMessageDialog(null, content.toString());
            }
            catch(FileNotFoundException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            catch(IOException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        /*Organiza o arquivo em variavel*/
        String[] fields = content.toString().split(System.lineSeparator());
//        for(String linha : fields)
//        {
//            System.out.println(linha);
//        }
        
        return fields;
    }
    
    public List<String> getTransitions(String key)
    {
        return transitions.get(key);
    }
    
    public String[] getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String[] alphabet) {
        this.alphabet = alphabet;
    }

    public String getInitialState() {
        return initialState;
    }

    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }

    public String[] getFinalStates() {
        return finalStates;
    }

    public void setFinalStates(String[] finalStates) {
        this.finalStates = finalStates;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
    
    
}
