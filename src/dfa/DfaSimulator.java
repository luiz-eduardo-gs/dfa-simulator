package dfa;

import java.util.ArrayList;
import java.util.Arrays;

public class DfaSimulator extends app.Simulator
{    
    /*Faz com que as strings lidas como entrada sejam organizadas em uma lista*/
    @Override
    public void organizeInputs(String[] inputs)
    {
        this.inputs.addAll(Arrays.asList(inputs));
    }
     
    /*Valida se o automato aceita a string ou nao*/
    @Override
    public void validate()
    {
        StringBuilder sb = new StringBuilder();
        boolean isValid = false;
        for(String test : inputs)
        {
            sb.append(test).append(": ");
            currentState = getInitialState();
            System.out.printf(currentState + "->");
            sb.append(currentState).append("->");
            for(String c : test.split(","))
            {
                currentState = transitionsDFA.get(currentState).get(Integer.parseInt(c));
                if(currentState.equals("{}"))
                {
                    break;
                }
                System.out.printf(currentState + "->");
                sb.append(currentState).append("->");
            }
            sb.append("  ");
            /*Valida se o automato aceita a string teste*/
            for(String finalState : getFinalStates())
            {
                if(currentState.equals(finalState)){
                    isValid = true;
                    System.out.println("ACEITA");
                    sb.append("ACEITA");
                }
            }
            if(!isValid)
            {
                System.out.println("NAO ACEITA");
                sb.append("NAO ACEITA");
            }
            isValid = false;
            sb.append(System.lineSeparator());
        }
        saveFile(sb.toString());
    }
    
    /*Associa estados e transicoes a variaveis*/
    @Override
    public void organizeVariables(String[] tableString)
    {
        /*Coloca o alfabeto do automato em Alphabet*/
        setAlphabet(tableString[0].split(","));
        
        /*Coloca o estado inicial do automato em initialState*/
        setInitialState(tableString[1].replace(">", "").trim());
        
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
            transitionsDFA.put(states.get(i), Arrays.asList(auxList.get(i).split(",")));
        }
        
//        /*Imprime cada atributo da classe*/
//        for(String obj : getAlphabet()){
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
}
