import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.lang.Math.pow;
import java.math.*; //For Big integer

@WebServlet(urlPatterns = {"/Bigcalc"})
public class BigCalc extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            
            int a,b,c=0; String str;
            //Input from the jsp 
            a=Integer.parseInt(request.getParameter("t1"));
            b=Integer.parseInt(request.getParameter("t2"));
            String opr=request.getParameter("opr");  
            
            // Create 3 BigInteger objects 
            // Assign values to bi1, bi2
            BigInteger bi1 = BigInteger.valueOf(a);
            BigInteger bi2 = BigInteger.valueOf(b);
            BigInteger bi3;
            //For power calculation
            int exponent=b;
            
            //To validate numbers a and b
            if((a==(int)a)&&(b==(int)b))
            {   //For addition operation
                if(opr.equals("+"))
                {
                    bi3 = bi1.add(bi2);
                    //Conver bi3 to String
                    str = "Result of addition is " +bi3;
                    // print bi3 value
                    out.println( str );
                }
                //For multiplication operation 
                if(opr.equals("*"))
                {
                    bi3 = bi1.multiply(bi2);
                    //Conver bi3 to String
                    str = "Result of multiplication is " +bi3;
                    // print bi3 value
                    out.println( str );
                }
                //To check whether numbers a and b are relatively prime or not
                if(opr.equals("rp"))
                {
                    if (gcd(a, b) == 1)
                        out.println("The numbers "+a+" and "+b+" are relatively prime"); 
                    else
                        out.println("The numbers "+a+" and "+b+" are not relatively prime");  
                }
                //For modulo operation    
                if(opr.equals("m"))
                {
                    bi3 = bi1.mod(bi2);
                    //Conver bi3 to String
                    str = "Result for modulo (x mod y) is " +bi3;
                    // print bi3 value
                    out.println( str );
                }
                //For modular inverse operation               
                if(opr.equals("mi"))  
                {
                    bi3 = bi1.modInverse(bi2);
                    //Conver bi3 to String
                    str = "Result for modular inverse (x^-1 mod y) is " +bi3;
                    // print bi3 value
                    out.println( str );
                }
                //For power operation 
                if(opr.equals("p"))
                {
                    bi3 = bi1.pow(exponent);
                    //Conver bi3 to String
                    str = "Result for power (x^y) is " +bi3;
                    // print bi3 value
                    out.println( str );
                }
            }
            else
            out.println("The number entered are invalid. Please try again!");
        }
    }
    
    //Function to find gcd of numbers a and b
    public int gcd(int a, int b)
    {
        // Everything divides 0 
        if (a == 0 || b == 0)
            return 0;
         
        // base case
        if (a == b)
            return a;
         
        // a is greater
        if (a > b)
            return gcd(a-b, b);
                 
        return gcd(a, b-a);
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
