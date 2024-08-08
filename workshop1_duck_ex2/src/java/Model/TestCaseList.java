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
public class TestCaseList {
    
    private static TestCaseList instance = new TestCaseList();
    
    public static TestCaseList getInstance(){
        return instance;
    }

    private ArrayList<TestCase> StoreList;
    
    private TestCaseList() {
        StoreList = new ArrayList();
    }
    
    public boolean duped(TestCase testcase){
        for (TestCase temp:list()){
            if (temp.printInput().equals(testcase.printInput()) && temp.getType().equals(testcase.getType()))
            return true;
        }
        return false;
    }
    
    public void add(TestCase u){
        StoreList.add(u);
    }
    
    public ArrayList<TestCase> list() {
        return StoreList;
    }
}
