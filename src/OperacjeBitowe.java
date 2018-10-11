public class OperacjeBitowe {
	
		static void operacje(){
		String[] table = {"0000","0001","0010","0011"};
		byte a = 3;
		byte b = 6;
		byte c = (byte) (a|b); //Wyniki s¹ domyœlnie w int dlatego dokonujemy konwersji
		int c1 = (a|b);
		byte d = (byte) (a&b);
		//byte e = (byte) (a~b);
		byte f = (byte) (a^b);
		byte g = (byte) ((~a&b) | (a&~b));
		byte h = (byte) (~a);
		byte i = (byte) (~a&0x0F);
		
		System.out.println(" a "+a);
		System.out.println(" b "+b);
		System.out.println(" c "+c);
		System.out.println(" c1 "+c1);
		System.out.println(" d "+d);
		
		System.out.println(" f "+f);
		System.out.println(" g "+g);
		System.out.println(" h "+h);
		System.out.println(" i "+i);
		}
}
