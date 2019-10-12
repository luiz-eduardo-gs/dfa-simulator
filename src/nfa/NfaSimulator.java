package nfa;

import app.SimulatorInterface;
import java.util.Arrays;

public class NfaSimulator extends app.Simulator implements SimulatorInterface
{
    /*Faz com que as strings lidas como entrada sejam organizadas em uma lista*/
    @Override
    public void organizeInputs(String[] inputs)
    {
        this.inputs.addAll(Arrays.asList(inputs));
    }
    
    /*Valida se o automato aceita a string ou nao*/
    @Override
    public void validate() {
        
    }
    
    /*Associa estados e transicoes a variaveis*/
    @Override
    public void organizeVariables(String[] tableString) {
        
    }
    
}
