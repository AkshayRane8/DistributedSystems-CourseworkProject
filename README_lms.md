# DistributedSystems-CourseworkProject
The project was done as a part of course work for the course - Distributed Systems in the month of April, 2018.

Steps to run the project tasks:

1) Open NetBeans IDE.

2) Import the files all the three zip files one by one.

3) Run the index.jsp file for Project1Task1 and Project1Task2 to execute and to get the output through the browser.

4) For Project1Task3, I have used BlueStacks Android simulator to open the Android browser. Run the file index.jsp and use the address http://10.0.2.2:8080/Project1Task3/ to get the output. 

Tasks:

Task 1
Use the NetBeans Project Name: Project1Task1
You do not need to use an MVC framework for this project.
Write an index.jsp page that asks the user to enter a string of text data, and to make
a choice of two hash functions using radio buttons. The hash function choices should
be MD5 and SHA-1, with MD5 being the default. When the submit button is pressed a
servlet is executed. The servlet must be named ComputeHashes.java. The servlet will
compute the appropriate cryptographic hash value from the text transmitted by the
browser. You will need to employ the Java crypto API to compute the MD5 or SHA-1
hash of the text. The original text will be echoed back to the browser along with the
name of the hash, and the hash value. The hash values sent back to the browser
should be displayed in two forms: as hexadecimal text and as base 64 notation. We
will discuss the use of such hash values later in the course.
To compute the MD5 and SHA-1 hashes, use these standard java packages:
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
To compute the Base64 encoding, use the following package:
import sun.misc.BASE64Encoder;
The BASE64Encoder class is an internal non-documented class. BASE64Encoder
objects have a method with the signature String encode(byte[]). It returns a base 64
string encoding of an array of bytes.
To compute the hexadecimal representation of a byte array, use the following code:
// From the web site "Real's How To"
public String getHexString(byte[] b) throws Exception {
String result = "";
for (int i=0; i < b.length; i++) {
result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring( 1 );
}
return result;
}
Be sure to provide a user friendly and attractive user interface.
So that you may test your program, here are example hashes.
Hashes of the string "Hello":SHA-1 (Hex):F7FF9E8B7BB2E09B70935A5D785E0CC5D9D0ABF0
SHA-1 (Base 64): 9/+ei3uy4Jtwk1pdeF4MxdnQq/A=
MD5: (Hex): 8B1A9953C4611296A827ABF8C47804D7
MD5: (Base 64): ixqZU8RhEpaoJ6v4xHgE1w==


Task 2
Use the NetBeans Project Name: Project1Task2
You do not need to use an MVC framework for this project.
Later in the semester when we are studying the RSA algorithm, it will be useful to be
able to do math operations on some arbitrarily large integers. Therefore Task 2 is to
create a useful calculator app for this purpose.
Write a simple web application that allows a user to perform one of six operations on
two, possibly very large, integers (x, y). The operations will include
1. Addition (x+y)
2. Multiplication (x*y)
3. An operation to determine if x and y are relatively prime
4. Modulo (x mod y)
5. A modular inverse (x-1 mod y)
6. Raise x to the power of y (i.e. xy)
A JSP page will present three input fields to the user. The first two will be used to
collect the two integers, x and y. The third will be used to collect the operation type.
The operations supported will be "add", "multiply", "relativelyPrime", "mod",
"modInverse", and "power". Use drop down boxes in XHTML. A submit button will be
provided and when it is hit a servlet will be visited. The servlet will be named
BigCalc.java and will use the BigInteger class to perform the conversions from strings
and the appropriate computation. The servlet will return the result to the browser
marked up in HTML. You need to validate both integers and the operation. In the case
of invalid input return an error message to the browser - but don't crash the server.
The BigInteger class has multiply, add, modInverse, mod, and pow methods to use. For
the operation that determines if the two integers are relatively prime use the gcd()
method of the BigInteger class. If the greatest common divisor of the two integers is
one then the two integers are relatively prime. And finally, note that the exponent for
the pow method takes an integer, not a BigInteger.
Be sure to provide a user friendly and attractive user interface.


Task 3
Use the NetBeans Project Name: Project1Task3
You do not need to use an MVC framework for this project.
Write another web application using NetBeans. This application will determine if a
string entered into a browser is a palindrome. A string is a palindrome if it is empty,
has a single character, or reads the same when reading from left to right or from right
to left. Name your servlet Palin.java. Use an appropriate doctype for an Android
mobile.
Download and install the Android simulator from Google. Use the browser on the
simulator to visit this web application.
Produce a screen shot showing the simulator working on your web application.
Note:
• You will not be able to connect to the servlet from the Android simulator using
the IP address of “localhost” because "localhost" will refer to the Android device
itself (not your laptop). Android provides a loopback address of 10.0.2.2 that
refers to the system that the simulator is running on.
• For judging a palindrome, only consider letters. Disregard case, punctuation and
white space. For example "Madam I'm Adam" is a palindrome
