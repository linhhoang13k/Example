package companyBots.spaceX;

import java.util.HashMap;
import java.util.Map;

public class CpuEmulator {
	
	/**
	 * Input/Output

	[execution time limit] 3 seconds (java)

	[input] array.string subroutine

	Guaranteed constraints:
	1 ≤ subroutine.length ≤ 1024.

	[output] string

	Return the resulting 32-bit unsigned integer, converted into a string.

	 * @param subroutine
	 * @return
	 */
	static String cpuEmulator(String[] subroutine) {
		Map<String,Long> map = new HashMap<>();
		int length  = subroutine.length;
		for(int i=0; i<length; i++) {
			String sr = subroutine[i];
			String[] srs = sr.split(" ");
			String instruction = srs[0];
			switch(instruction) {
			// MOV Rxx,Ryy - copies the value from register Rxx to register Ryy;
			// MOV d,Rxx - copies the numeric constant d (specified as a decimal) to register Rxx;
			case "MOV":
				String subOperation = srs[1];
				String[] ops = subOperation.split(","); 
				String rxx = ops[0];
				String ryy = ops[1];
				if(rxx.indexOf("R")>=0) {
					Long rxxValue = map.get(rxx);
					Long ryyValue = map.get(ryy);
					rxxValue = (rxxValue == null) ? 0: rxxValue;
					map.put(ryy, getUnsignedInt(rxxValue));
				} else {
					map.put(ryy, getUnsignedInt(Long.valueOf(rxx)));
				}
				break;
			// ADD Rxx,Ryy - calculates (Rxx + Ryy) MOD 232 and stores the result in Rxx;
			case "ADD":
				subOperation = srs[1];
				ops = subOperation.split(","); 
				rxx = ops[0];
				ryy = ops[1];
				Long rxxValue = map.get(rxx);
				Long ryyValue = map.get(ryy);
				rxxValue = (rxxValue == null) ? 0: rxxValue;
				ryyValue = (ryyValue == null) ? 0: ryyValue;
				long kk = (long) ((rxxValue + ryyValue) % Math.pow(2, 32));
				map.put(rxx, getUnsignedInt(kk));
				break;
			// DEC Rxx - decrements Rxx by one. Decrementing 0 causes an overflow and results in 232-1;
			case "DEC":
				subOperation = srs[1];
				Long value = map.get(subOperation);
				if(value== null || value == 0) { 
					value = (long) Math.pow(2, 32)-1;
				} else { 
					value-=1;
				}
				map.put(subOperation,getUnsignedInt(value));
				break;
			// INC Rxx - increments Rxx by one. Incrementing 232-1 causes an overflow and results in 0;
			case "INC":
				subOperation = srs[1];
				value = map.get(subOperation);
				if(value == null) {
					value = 0l;
				}
				if(value == (Math.pow(2, 32)-1)) { 
					value = 0l;
				} else { 
					value+=1;
				}
				map.put(subOperation,getUnsignedInt(value));
				break;
			// INV Rxx - performs a bitwise inversion of register Rxx;
			case "INV":
				subOperation = srs[1];
				value = map.get(subOperation);
				if(value == null) {
					value = 0l;
				}
				long inverted = ~value;
				 map.put(subOperation,getUnsignedInt(inverted));
				break;
			// JMP d - unconditionally jumps to instruction number d (1-based). d is guaranteed to be a valid instruction number;
			case "JMP":
				// Instruction is 1 based and program is 0 based;
				i = Integer.parseInt(srs[1])-1-1;
				break;
			// JZ d - jumps to instruction d (1-based) only if R00 contains 0;
			case "JZ":
				value = map.get("R00");
				if(value ==0) {
					// Instruction is 1 based and program is 0 based;
					i = Integer.parseInt(srs[1])-1-1;
				}
				break;
			// NOP - does nothing.
			case "NOP":
				break;
			}	
		}
		// After the last instruction has been executed, the contents of R42 are considered to be the result of the subroutine.
		Long rValue = map.get("R42");
		if(rValue == null) {
			rValue = 0l;
		}
		return String.valueOf(rValue);

	}

	
	public static long getUnsignedInt(long x) {
	    return x & 0x00000000ffffffffL;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] subroutine = {"ADD R03,R33"};
		String result = cpuEmulator(subroutine); 
		System.out.println(result);
	}

}
