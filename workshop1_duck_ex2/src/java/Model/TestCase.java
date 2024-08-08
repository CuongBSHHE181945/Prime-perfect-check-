/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TestCase {
    public ArrayList<Integer> input;
    public String type;
    public ArrayList<Integer> result;

    
    public String printInput(){
        String result = "";
        for (Integer temp:this.input){
            result += temp + " ";
        }
        return result;
    }
    
    public String printResult(){
        String result = "";
        for (Integer temp:this.result){
            result += temp + " ";
        }
        return result;
    }

    public TestCase() {
    }

    public TestCase(ArrayList<Integer> input, String type, ArrayList<Integer> result) {
        this.input = input;
        this.type = type;
        this.result = result;
    }

    public ArrayList<Integer> getInput() {
        return input;
    }

    public void setInput(ArrayList<Integer> input) {
        this.input = input;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Integer> getResult() {
        return result;
    }

    public void setResult(ArrayList<Integer> result) {
        this.result = result;
    }

    
}
