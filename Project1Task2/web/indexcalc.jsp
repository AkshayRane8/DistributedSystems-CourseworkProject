<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project1Task2</title>
    </head>
    <body>
        <form action="Bigcalc" method ="post" name="f1">
            <table>
                <tr><td><br>
                        Please enter the 1st number: <input type="text" name="t1" /> </td>
                </tr>
                <tr><td><br>
                        Please enter the 2nd number: <input type="text" name="t2" /> </td>
                </tr>
                <!-- Drop down box for operations-->
                <tr>
                    <td><br>Please select your choice from following operations: 
                        <select name="opr">
                            <option value=""></option>
                            <option value="+">add</option>
                            <option value="*">multiply</option>
                            <option value="rp">relativelyPrime</option>
                            <option value="m">mod</option>
                            <option value="mi">modInverse</option>
                            <option value="p">power</option>                           

                        </select>
                    </td>
                </tr>
                <!--To submit the result -->
                <tr><td><br> <input type="submit" value="Submit" /></td></tr>
                    
        </form>
    </body>
</html>
