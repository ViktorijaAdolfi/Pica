import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class picaa {

	public static void main(String[] args) {
		ImageIcon vikasPizzeria = new ImageIcon(picaa.class.getResource("/img/vikasPizzeria.png"));
		String izvele;
		int caseS;
		String[] saakums = {"Veikt pasūtījumu","Apturēt programmu"};
		
		JOptionPane.showMessageDialog(null, "", "Laipni lūgti.. ", 
                JOptionPane.QUESTION_MESSAGE, vikasPizzeria);
		
		do {
    		izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību!", "Start!",
					JOptionPane.QUESTION_MESSAGE, null, saakums, saakums[0]);
    		
    		if(izvele == null)
    			izvele = "Apturēt programmu";
    		
    		switch(izvele) {
    		case "Veikt pasūtījumu":
    			
    			break;
    			
    		case "Apturēt programmu":
    			JOptionPane.showMessageDialog(null, "Paldies, par pasūtījumu. Uzredzēšanos!");
    			break;
    		}
    		
		}while(!izvele.equals("Apturēt programmu"));
		//beidz programmas darbību!!	

	}

}
