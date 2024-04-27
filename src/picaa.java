import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class picaa {
	
	class Pizza {
	    private String izmers;
	    private ArrayList<String> tops;
	    private ArrayList<String> sauce;
	    private double cena;

	    public Pizza(String izmers, ArrayList<String> tops, ArrayList<String> sauce) {
	        this.izmers = izmers;
	        this.tops = tops;
	        this.sauce = sauce;
	        this.cena = aprekinatCenu();
	    }
	    
	class Pasutijums{
		private String vards;
		private String adrese;
	    private String tel;
	    private Pizza pica;
	    
	    public Pasutijums (String vards, String adrese, String tel, Pizza pica) {
	        this.vards = vards;
	        this.adrese = adrese;
	        this.tel = tel;
	        this.pica = pica;
	    }
	    
	    public String getVards() {
	    	return vards;
	    }
	    public String getAdrese() {
	    	return adrese;
	    }
	    public String getTel() {
	    	return tel;
	    }
	    public Pizza getPica() {
	    	return pica;
	    }
	    
	    @Override
	    public String toString() {
	        return "Vārds: "+vards+"\nAdrese: "+adrese+"\nTel. num: "+tel+"\nPica: "+pica;
	    }
	}

	public static void main(String[] args) {
		ImageIcon vikasPizzeria = new ImageIcon(picaa.class.getResource("/img/vikasPizzeria.png"));
		String izvele;
		int caseS;
		String[] saakums = {"Veikt pasūtījumu","Apskatīt pasūtījumus","Apturēt programmu"};
		
		JOptionPane.showMessageDialog(null, "", "Laipni lūgti.. ", 
                JOptionPane.QUESTION_MESSAGE, vikasPizzeria);
		
		do {
    		izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību!", "Start!",
					JOptionPane.QUESTION_MESSAGE, null, saakums, saakums[0]);
    		
    		if(izvele == null)
    			izvele = "Apturēt programmu";
    		
    		switch(izvele) {
    		case "Veikt pasūtījumu":
    			//pasutit();
    			break;
    			
    		case "Apskatīt pasūtījumus":
    			//pasūtījumi
    			break;
    			
    		case "Apturēt programmu":
    			JOptionPane.showMessageDialog(null, "Paldies, par pasūtījumu. Uzredzēšanos!");
    			break;
    		}
    		
		}while(!izvele.equals("Apturēt programmu"));

	}

}
