/*
Reverse the order of the bits in a given integer.

Example

    For a = 97, the output should be
    mirrorBits(a) = 67.

    97 equals to 1100001 in binary, which is 1000011 after mirroring, and that is 67 in base 10.

    For a = 8, the output should be
    mirrorBits(a) = 1.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] integer a

    Guaranteed constraints:
    5 ≤ a ≤ 105.

    [output] integer

*/

int mirrorBits(int a) {
    
    // Int To Binary Form
    String binaryForm = Integer.toBinaryString(a);
    
    // Binary form to String Builder
    StringBuilder sb = new StringBuilder(binaryForm);
    
    // Reverse binary form
    String reversedBinaryForm = sb.reverse().toString();
    
    // Binary form back to int
    int reversedA = Integer.parseInt(reversedBinaryForm, 2);
    
    return reversedA;
}