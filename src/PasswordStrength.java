package tiendm.codefight.challenge.april;

import java.util.ArrayList;
import java.util.List;

public class PasswordStrength {
//	double passwordStrength(String password) {
//		double[] growth_factor = {0.25,0.4,0.4,0.5};
//		double[] max_group_size = {26,26,10,32};
//		double[] group = new double[4];
//		List<Character> lsCheck = new ArrayList<>();
//		for(int i = 0; i < password.length(); i++){
//			char c = password.charAt(i);
//			if(!lsCheck.contains(c)){
//				if(c >= 'a' && c <= 'z' ) {
//					group[0] = group[0] + 1;
//					lsCheck.add(c);
//				}else if (c >= 'A' && c <= 'Z') {
//					group[1] = group[1] + 1;
//					lsCheck.add(c);
//				}else if (c >= '0' && c <= '9') {
//					group[2] = group[2] + 1;
//					lsCheck.add(c);
//				}else {
//					group[3] = group[3] + 1;
//					lsCheck.add(c);
//				}
//			}
//		}
//		double[] rep_factor  = new double[4];
//		for(int i = 0; i < 4; i++){
//			rep_factor[i] = 1 - Math.pow((1-growth_factor[i]), group[i]);
//		}
//		double strength  = 0;
//		for(int i = 0; i < 4; i++){
//			strength += rep_factor[i] * max_group_size[i];
//		}
//		strength = Math.pow(strength, password.length());
//		return Math.log(strength) / Math.log(2);
//	}
	
	double passwordStrength(String p) {
		double[] g_f = {0.25,0.4,0.4,0.5}, m_g_s = {26,26,10,32}, g = new double[4],r_f  = new double[4];;
		List<Character> l = new ArrayList<>();
		for(int i = 0; i < p.length(); i++){
			char c = p.charAt(i);
			if(!l.contains(c)){
				if(c >= 'a' && c <= 'z' ) {
					g[0] = g[0] + 1;
					l.add(c);
				}else if (c >= 'A' && c <= 'Z') {
					g[1] = g[1] + 1;
					l.add(c);
				}else if (c >= '0' && c <= '9') {
					g[2] = g[2] + 1;
					l.add(c);
				}else {
					g[3] = g[3] + 1;
					l.add(c);
				}
			}
		}
		double x  = 0;
		for(int i = 0; i < 4; i++){
			r_f[i] = 1 - Math.pow((1-g_f[i]), g[i]);
			x += r_f[i] * m_g_s[i];
		}
		x = Math.pow(x, p.length());
		return Math.log(x) / Math.log(2);
	}
	public static void main(String[] args) {
		PasswordStrength test = new PasswordStrength();
		System.out.println(test.passwordStrength("abcc73?"));
	}
}
