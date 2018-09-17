import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Palin"})
public class Palin extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            //Convert entered input to string
            String a = request.getParameter("t1");
            //Checks if entered string is a palindrome
            if(isPalindrome(a))
                out.println("String '"+a+"' is a palindrome!");
            else
                out.println("String '"+a+"' is not a palindrome!");
      
        }
    }
    static boolean isPalindrome(String str)
    {    
        int l = 0;
        int h = str.length()-1;
        // Lowercase string
        str = str.toLowerCase();
        // Compare character until they are equal
        while(l <= h)
        {
            char getAtl = str.charAt(l);
            char getAth = str.charAt(h);  
            // If there is another symbol in left of string
            if (!(getAtl >= 'a' && getAtl <= 'z'))
                l++;  
            // If there is another symbol in right of string
            else if(!(getAth >= 'a' && getAth <= 'z'))
                h--;
            // If characters are equal
            else if( getAtl == getAth)
            {
                l++;
                h--;
            }
            // If characters are not equal then string is not palindrome
            else
                return false;
        }
        // Returns true if string is a palindrome
        return true;    
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
