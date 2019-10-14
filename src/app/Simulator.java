package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simulator extends fileManager.FileManager implements SimulatorInterface
{
    protected String[] alphabet;
    protected String currentState;
    protected final ArrayList<String> inputs = new ArrayList<>();
    protected String initialState;
    protected String[] finalStates;
    protected final ArrayList<String> states = new ArrayList();
    protected final Map<String, List<String>> transitionsDFA = new HashMap<>();

    public List<String> getTransitions(String key)
    {
        return transitionsDFA.get(key);
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

    @Override
    public void organizeInputs(String[] inputs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void organizeVariables(String[] tableString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
