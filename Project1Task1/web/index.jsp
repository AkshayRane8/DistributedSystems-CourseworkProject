
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project1Task1</title>
    </head>
    <body>
        <form action="ComputeHashes" method ="post" name="f1">
            <table>
                <tr>
                    <td>Please select an option from following hash functions:<br> 
                       <input type = "radio" name = "opr" onclick = \"getAnswer('md5') value="md5" checked="checked">MD5<br>
                       <input type = "radio" name = "opr" onclick = \"getAnswer('sha') value="sha">SHA-1<br>
                    </td>
                </tr>
                <tr><td><br>
                        Please enter the string to be hashed: <input type="text" name="t1"  /> </td>
                </tr>
                <tr><td><br> <input type="submit" value="Submit" /></td></tr>                  
        </form>
    </body>
</html>
