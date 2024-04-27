import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class picaa {
	
	class Pizza {
		private String picasName;
	    private String izmers;
	    private ArrayList<String> tops;
	    private ArrayList<String> sauce;
	    private double pamatnesCena;
	    private double topsCena;
        private double sauceCena;

	    public Pizza(String picasName, String izmers, ArrayList<String> tops, ArrayList<String> sauce) {
	    	this.picasName = picasName;
	    	this.izmers = izmers;
	        this.tops = tops;
	        this.sauce = sauce;
	        aprekinatCenu();
	    }
	    private void aprekinatCenu() {
            switch (izmers) {
                case "Small":
                	pamatnesCena = 5.0;
                    break;
                case "Medium":
                	pamatnesCena = 7.0;
                    break;
                case "Large":
                	pamatnesCena = 9.0;
                    break;
                default:
                	pamatnesCena = 0.0;
                    break;
            }
            topsCena = tops.size()*1.5;
            sauceCena = sauce.size()*0.5;
        }
	    public String getPicasName() {
	    	return picasName;
	    }
		public String getIzmers() {
			return izmers;
		}
		public ArrayList<String> getTops() {
	        return tops;
	    }
		public ArrayList<String> getSauce() {
	        return sauce;
	    }
		public double getPamatnesCena() {
			return pamatnesCena;
		}
		public double getTopsCena() {
	        return topsCena;
	    }
		public double getSauceCena() {
	        return sauceCena;
		}
	    public double getKopaCena() {
	        return pamatnesCena + topsCena + sauceCena;
	    }
	    
		@Override
	    public String toString() {
	        return "Picas veids: "+picasName+"\nIzmērs(diametrs cm): "+izmers+
	        	   "\nPiedevas: "+tops+"\nMērce: "+sauce+"\nCena €: "+getKopaCena();
	    }
	}
		
	class Pasutijums{
		private String vards;
		private String adrese;
	    private String tel;
	    private Pizza pica;
	    private double piegade;
	    
	    public Pasutijums (String vards, String adrese, String tel, Pizza pica, double piegade) {
	        this.vards = vards;
	        this.adrese = adrese;
	        this.tel = tel;
	        this.pica = pica;
	        this.piegade = piegade;
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
	    public double getPiegade() {
	    	return piegade;
	    }
	    
	    @Override
	    public String toString() {
	        return "Vārds: "+vards+"\nAdrese: "+adrese+"\nTel. num: "+tel+"\nPica: "+pica;
	    }
	}
	
	public static void veiktPasutijumu() {
		/*double piegadesCena;
		String vards = JOptionPane.showInputDialog("Ievadiet savu vārdu:");
        String adrese = JOptionPane.showInputDialog("Ievadiet savu mājas adrese, uz kuru sūtīt:");
        String telnum = JOptionPane.showInputDialog("Ievadiet savu tel.num:");
        
        if(adrese.equalsIgnoreCase("uz vietas"))
        	piegadesCena = 0;
        else
        	piegadesCena = 2;
        
        System.out.println(piegadesCena);
        
        String[] izmeri = {"20 ∅","30 ∅","50 ∅"};
        String izmeruIzv = (String) JOptionPane.showInputDialog(null, "Select pizza size:", "Pizza Size",
                JOptionPane.QUESTION_MESSAGE, null, izmeri, izmeri[0]);*/
	}

	public static void main(String[] args) {
		ImageIcon vikasPizzeria = new ImageIcon(picaa.class.getResource("/img/vikasPizzeria.png"));
		String izvele;
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
    			veiktPasutijumu();   
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
