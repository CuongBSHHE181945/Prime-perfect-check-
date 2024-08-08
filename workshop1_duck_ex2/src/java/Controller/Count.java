/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Model.*;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Count extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Count</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Count at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        TestCaseList model = TestCaseList.getInstance();
        ArrayList<TestCase> test = model.list();
        request.setAttribute("testcase", test);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("MyExecution.jsp");
        requestDispatcher.forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        TestCaseList model = TestCaseList.getInstance();
        
        String temp = request.getParameter("integer");
        String type = request.getParameter("type");
        StringTokenizer stk = new StringTokenizer(temp);
        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        boolean invalid = false;
        if (type==null||input==null) invalid = true;
        while (stk.hasMoreElements()){
            try{
                int current = Integer.parseInt(stk.nextToken());
                if (current<0) throw new Exception();
                input.add(current);
            } catch (Exception e){
                invalid = true;
            }  
        }
        
        if (!invalid){
            switch(type){
                case "perfect": for (Integer x:input){
                                    if (isPerfect(x))
                                        result.add(x);
                                }
                                break;
                case "prime":for (Integer x:input){
                                    if (isPrime(x))
                                        result.add(x);
                                }
                                break;
                default: break;
            }
            TestCase current = new TestCase(input, type, result);
            if (model.duped(current)){
                request.setAttribute("existed", true);
            } else {
                model.add(current);
            }
        }
        
        String printResult = "";
        for (Integer s:result){
            printResult += s;
        }
        if (result.isEmpty()) printResult = "";
        request.setAttribute("result", printResult);
        request.setAttribute("invalid", invalid);
        doGet(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
    
    public boolean isPerfect(int n)
    {
        // 1 is not a perfect number
        if (n == 1)
            return false;
 
        // sum will store the sum of proper divisors
        // As 1 is a proper divisor for all numbers
        // initialised sum with 1
        int sum = 1;
 
        // Looping through the numbers to check if they are
        // divisors or not
        for (int i = 2; i < n; i++) {
 
            if (n % i == 0) {
                sum += i;
            }
        }
 
        // If sum of divisors is equal to
        // n, then n is a perfect number
        if (sum == n)
            return true;
 
        return false;
    }
}
