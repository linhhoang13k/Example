package boot.kik;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by JavierSainz on 1/22/17.
 * Kik Codes are the fastest, easiest way to add friends and join groups on Kik. Just scan the code with your device, and a chat with the corresponding user starts automatically. You can see an example of the Kik Code in the image below:
 * <p>
 * <p>
 * <p>
 * As a part of your preparation for an interview at Kik, you decide to implement an algorithm that will automatically build a Kik Code given a userId. As you can see, a code consists of 6 circles with their circumferences partly colored. You're going to take the binary representation of userId, extend it by leading zeros if necessary (there should be 52 bits in its binary representation), reverse it, and then map it to the Code as follows:
 * <p>
 * CIRCUMFERENCE	1	2	3	4	5	6
 * BITS	first 3	next 4	next 8	next 10	next 12	last 15
 * Each circumference will be split into sectors. The number of sectors for each circumference is equal to the number of bits mapped onto it. The contiguous sets of 1s in the corresponding bits of userId will be colored white.
 * <p>
 * Now you need to implement a function that, given userId, returns the list of colored segments' coordinates in the polar coordinate system with the center at the center of the circumferences. Each segment should be returned as an array of two elements, representing the coordinates of its edges in a counterclockwise direction.
 * <p>
 * Example
 * <p>
 * For userId = "1851027803204441", the output should be
 * <p>
 * kikCode(userId) = [
 * [[1, 0], [1, 120]],
 * [[2, 270], [2, 540]],
 * [[3, 45], [3, 135]], [[3, 180], [3, 225]], [[3, 270], [3, 360]],
 * [[4, 0], [4, 72]], [[4, 108], [4, 180]],
 * [[4, 216], [4, 252]], [[4, 288], [4, 324]],
 * [[5, 0], [5, 360]],
 * [[6, 0], [6, 48]], [[6, 72], [6, 120]], [[6, 168], [6, 192]],
 * [[6, 240], [6, 264]], [[6, 288], [6, 336]]
 * ]
 * The binary representation of userId with additional leading zeros is
 * <p>
 * 0110100100110111111111111110101011011110101101011001.
 * <p>
 * After reversing it and splitting, the following sets of bits for each circumference is obtained:
 * <p>
 * 100 1101 01101011 1101101010 111111111111 110110010010110.
 * <p>
 * Which means that:
 * <p>
 * circumference 1: three sectors, one segment
 * first sector, coordinates [[1, 0], [1, 120]]
 * circumference 2: four sectors, one segment
 * sectors 1, 2 and 4, coordinates [[2, 270], [2, 540]] (note how it is treated as a single sector)
 * circumference 3: eight sectors, three segments
 * sectors 2 and 3, coordinates [[3, 45], [3, 135]]
 * sector 5, coordinates [[3, 180], [3, 225]]
 * sectors 7 and 8, coordinates [[3, 270], [3, 360]]
 * circumference 4: ten sectors, four segments
 * sectors 1 and 2, coordinates [[4, 0], [4, 72]]
 * sectors 4 and 5, coordinates [[4, 108], [4, 180]]
 * sector 7, coordinates [[4, 216], [4, 252]]
 * sector 9, coordinates [[4, 288], [4, 324]]
 * circumference 5: twelve sectors, one segment
 * all sectors, coordinates [[5, 0], [5, 360]]
 * circumference 6: fifteen sectors, five segments
 * sectors 1 and 2, coordinates [[6, 0], [6, 48]]
 * sectors 4 and 5, coordinates [[6, 72], [6, 120]]
 * sector 8, coordinates [[6, 168], [6, 192]]
 * sector 11, coordinates [[6, 240], [6, 264]]
 * sectors 13 and 14, coordinates [[6, 288], [6, 336]]
 * <p>
 * <p>
 * Input/Output
 * <p>
 * [time limit] 3000ms (java)
 * [input] string userId
 * <p>
 * A string representing user id.
 * <p>
 * Constraints:
 * <p>
 * 0 ≤ int(userId) < 252.
 * <p>
 * [output] array.array.array.integer
 * <p>
 * An array of Code segments sorted by the coordinates of their first points. Each segment should be returned in the format [[r, start_angle], [r, end_angle]], where r is the circumference number starting from the innermost, start_angle is the N8 coordinate of the starting point, end_angle is the N8 coordinate of the last point, and start_angle < end_angle.
 * <p>
 * All coordinates should be non-negative. If a sector covers all segments, it should have the coordinates [[r, 0], [r, 360]], where r is the circumference number.
 */
public class KikCode {
    int[] circumferencesSize = new int[]{3, 4, 8, 10, 12, 15};

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new KikCode().kikCode("1851027803204441")));
    }

    int[][][] kikCode(String userId) {
        StringBuilder binary = new StringBuilder(String.format("%52s",
                new BigInteger(userId).toString(2)).replace(' ', '0')).
                reverse();
        ArrayList<int[][]> sectors = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < circumferencesSize.length; i++) {
            StringBuilder circumference = new StringBuilder(
                    binary.substring(index, index + circumferencesSize[i]));
            //move head to tail
            if (circumference.charAt(circumference.length() - 1) == '1' &&
                    circumference.charAt(0) == '1' && circumference.indexOf("0") > -1) {
                for (int ci = 0; ci < circumference.length() - 1; ci++) {
                    if (circumference.charAt(ci) == '1') {
                        circumference.setCharAt(ci, '0');
                        circumference.append('1');
                    } else {
                        break;
                    }
                }
            }
            int sectorSize = 360 / circumferencesSize[i];
            int angle = 0;
            for (int ci = 0; ci < circumference.length(); ci++) {
                int startAngle = angle;
                while (ci < circumference.length() && circumference.charAt(ci) == '1') {
                    ci++;
                    angle += sectorSize;
                }
                if (startAngle != angle) {
                    sectors.add(new int[][]{{i + 1, startAngle}, {i + 1, angle}});
                }
                angle += sectorSize;
            }
            index += circumferencesSize[i];
        }
        int[][][] sectorsArray = new int[sectors.size()][][];
        for (int i = 0; i < sectors.size(); i++) {
            sectorsArray[i] = sectors.get(i);
        }
        return sectorsArray;
    }
}
