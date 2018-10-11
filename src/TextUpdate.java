package tiendm.codefight.challenge.july;

public class TextUpdate {
	String textUpdate(String t) {
		String[] arrs = t.split(" ");
		for(int i = 0; i < arrs.length; i++){
			if(1==1){
				arrs[i] = reverse(arrs[i]);
			}
		}
		StringBuilder builder = new StringBuilder();
		for(String s: arrs){
			builder.append(s).append(" ");
		}
		return builder.toString().trim();
	}
	String reverse(String s){
		StringBuilder build = new StringBuilder();
		build.append(s);
		return build.reverse().toString();
	}
	public static void main(String[] args) {
		TextUpdate update = new TextUpdate();
		System.out.println(update.reverse("xyz"));
		System.out.println(update.textUpdate("xxx"));
	}
}
