import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigInteger;
import sun.misc.BASE64Encoder;
import java.util.Base64;

@WebServlet(urlPatterns = {"/ComputeHashes"})
public class ComputeHashes extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {   //String entered on the browser         
            String str = request.getParameter("t1");
            //Option from jsp
            String opr=request.getParameter("opr");
            //Performs MD5 hash
            if(opr.equals("md5"))
            {
                md5_func(response,str);
            }
            //Performs SHA-1 hash
            if(opr.equals("sha"))
            {
                sha_func(response,str);
            }
        }        
    }
    //Function to perform MD5 hash
    public void md5_func(HttpServletResponse response,String plainText)throws ServletException, IOException
    {     
            String input;
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            MessageDigest mdAlgorithm;
            try {
                mdAlgorithm = MessageDigest.getInstance("MD5");
          
            mdAlgorithm.update(plainText.getBytes());
            
            byte[] digest = mdAlgorithm.digest();
            
            StringBuffer hexString = new StringBuffer();
            
            //For loop to get the Hex value using MD5 hash
            for (int i = 0; i < digest.length; i++) {
                plainText = Integer.toHexString(0xFF & digest[i]);

                if (plainText.length() < 2) {
                    plainText = "0" + plainText;
                }

                hexString.append(plainText);
            }
            
            input=hexString.toString().toUpperCase( );
            //Hex output
            out.print("<br>MD5: (Hex): "+input);
            //Base 64 output
            out.print("<br>MD5: (Base 64): "+hextobase64_md5(input));
          
             } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ComputeHashes.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    //Function to perform SHA-1 hash    
    public void sha_func(HttpServletResponse response, String value)throws ServletException, IOException
    {       
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            String sha1 = "";
            try {
                    MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(value.getBytes("utf8"));
            //Compute equivalent Hex value using SHA-1 hash
            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
            } catch (Exception e){
                    e.printStackTrace();
            }
            //Convert the result to string
            String sha_op=sha1.toUpperCase( );
            //Hex value
            out.println("<br>SHA-1 (Hex): "+sha_op);
            //Base 64 output
            out.println("<br>SHA-1 (Base 64): "+hextobase64_sha(sha_op));
          
    }
    //Function to compute Base 64 value for MD5 function
    public static String hextobase64_md5(String input) 
    {    
        byte barr[] = new byte[16];
        int bcnt = 0;
        for (int i = 0; i < 32; i += 2) {
            char c1 = input.charAt(i);
            char c2 = input.charAt(i + 1);
            int i1 = intFromChar(c1);
            int i2 = intFromChar(c2);

            barr[bcnt] = 0;
            barr[bcnt] |= (byte) ((i1 & 0x0F) << 4);
            barr[bcnt] |= (byte) (i2 & 0x0F);
            bcnt++;
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(barr);
    }
    private static int intFromChar(char c) 
    {
        char[] carr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        char clower = Character.toLowerCase(c);
        for (int i = 0; i < carr.length; i++) {
            if (clower == carr[i]) {
                return i;
            }
        }

        return 0;
    }

    //Function to compute Base 64 value for SHA-1 function   
    public static String hextobase64_sha(String input) 
    {    
        byte barr[] = new byte[20];
        int bcnt = 0;
        for (int i = 0; i < 40; i += 2) {
            char c1 = input.charAt(i);
            char c2 = input.charAt(i + 1);
            int i1 = intFromChar(c1);
            int i2 = intFromChar(c2);

            barr[bcnt] = 0;
            barr[bcnt] |= (byte) ((i1 & 0x0F) << 4);
            barr[bcnt] |= (byte) (i2 & 0x0F);
            bcnt++;
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(barr);
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
