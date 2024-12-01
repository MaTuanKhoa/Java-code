package XauKiTu;

import java.util.Scanner;

public class XauKiTu {
    private String st;


    public XauKiTu() {}

    public void nhapXau() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter String: ");
        st = input.nextLine();
    }
    public void ChuanHoaXau() {

    	st = st.trim();
    	st = st.replaceAll("\\s{2,}", " ");
    	String[] words = st.split(" ");
        StringBuilder stri = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                stri.append(Character.toUpperCase(word.charAt(0)))
                                .append(word.substring(1).toLowerCase())
                                .append(" ");
            }
        }

        // Convert StringBuilder to String and trim the trailing space
        String result = stri.toString().trim();
    }
    
    public int demSoTu() {
    	
    }
    
    public int demTuKetThucBoiKiTuG() {
    	
    }
    
    public int demKiTuChuSo() {
    	
    }
    

    public static void main(String[] args) {
    	XauKiTu a = new XauKiTu ();
    	a.nhapXau();
	}
}
