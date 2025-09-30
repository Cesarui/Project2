# Recursive Class (Based on Onion Routing)

## Goals (Written by Professor)
- Write a recursive class whose constructor takes an **odd number of binary digits** as its field.
- The constructor calls a recursive method. This method creates an object of the same class with a **smaller binary number**, by removing the two outer digits and passing the remaining digits.
- Once no more object can be created (the base case), the **binary digit is flipped**. (Think of it like turning white into red.)
- After recursion completes, the **flipped version of the original binary number** is returned.

## Results

Here is an example output from the program:

`Enter an odd-length binary number: 100`

`Flipped: [0, 1, 1]`

