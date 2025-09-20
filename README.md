# Recursive Class (Based on Onion Routing)

`Goals:`
<li>Write a recursive class that its constructor takes an odd number of binary digits as its field.</li>
<li>The constructor of this class calls the recursive method. This recursive method creates an object of the same class with smaller binary number by taking the two outer digits and passing the binary number that is left.</li>
<li>Once no more object can be created (the base case) the binary digit is flipped. Remember in the example white turned into red? With this, I am sure you know what flip does.</li>
<li>When the process is done, the flipped version of the original binary number is returned.</li>
