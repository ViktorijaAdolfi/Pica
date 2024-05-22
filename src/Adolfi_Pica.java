import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Adolfi_Pica {
	public static ArrayList<Order> orders = new ArrayList<>();
	private static ImageIcon pizza, starts, vikasPizzeria;
	
	static {
		try {
			pizza = new ImageIcon(new URL("https://www4.minijuegosgratis.com/v3/games/thumbnails/202095_1.jpg"));
			starts = new ImageIcon(new URL("https://media.tenor.com/ZzMG3GSJdbQAAAAM/papa-louie-cooking.gif"));
			vikasPizzeria = new ImageIcon(Pizza.class.getResource("/img/vikasPizzeria.png"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
    private static String izvele;
    private static String[] saakums = {"Veikt pasūtījumu", "Apskatīt pasūtījumus","Apkalpot klientu","Pasūtījumu Vēsture", "Apturēt programmu"};
	
    public static void main(String[] args){   	
        JOptionPane.showMessageDialog(null, "", "Laipni lūgti.. ",
                JOptionPane.QUESTION_MESSAGE, vikasPizzeria);
        do {
            izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību!", "Start!",
                    JOptionPane.QUESTION_MESSAGE, starts, saakums, saakums[0]);
            if (izvele == null)
                izvele = "Apturēt programmu";

            switch (izvele) {
                case "Veikt pasūtījumu":
                    orders = Metodes.veiktPasutijumu(orders);
                    break;
                case "Apskatīt pasūtījumus":
                    Metodes.apskatitPas(orders);
                    break;
                case "Apkalpot klientu":
                    Metodes.apkalpot(orders);
                    break;
                case "Pasūtījumu Vēsture":
                	Metodes.vesture();
                	break;
                case "Apturēt programmu":
                    JOptionPane.showMessageDialog(null, "Paldies, par pasūtījumu. Uzredzēšanos!", "Byeee!!",JOptionPane.ERROR_MESSAGE,pizza);
                    break;
            }
        } while (!izvele.equals("Apturēt programmu"));
    }
}
