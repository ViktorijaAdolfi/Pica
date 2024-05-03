import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class picaa {
    static class Pizza {
        private String picasName;
        private String izmers;
        private double pamatnesCena;
        private String papildusPiedevas;

        public Pizza(String picasName, String izmers, String papildusPiedevas) {
            this.picasName = picasName;
            this.izmers = izmers;
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
        }

        public String getPicasName() {
            return picasName;
        }

        public String getIzmers() {
            return izmers;
        }

        public double getPamatnesCena() {
            return pamatnesCena;
        }

        public double getKopaCena() {
            return pamatnesCena;
        }

        public void setPapildusPiedevas(String piedevas) {
            this.papildusPiedevas = piedevas;
        }

        @Override
        public String toString() {
            return "Picas veids: " + picasName + "\nIzmērs(diametrs cm): " + izmers +
                    "\nCena €: " + getKopaCena();
        }
    }

    static class Pasutijums {
        private String vards;
        private String adrese;
        private String tel;
        private Pizza pica;
        private double piegade;

        public Pasutijums(String vards, String adrese, String tel, Pizza pica, double piegade) {
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

        public double getKopaCena() {
            return pica.getKopaCena() + piegade;
        }

        @Override
        public String toString() {
            return "Vārds: " + vards + "\nAdrese: " + adrese + "\nTel. num: " + tel + "\n" + pica +
                    "\nPapildus izmaksas €: " + piegade + "\nKopējā cena €: " + getKopaCena();
        }
    }

    public static void veiktPasutijumu() {
        double piegadesCena;
        String vards = JOptionPane.showInputDialog("Ievadiet savu vārdu:");
        String adrese = JOptionPane.showInputDialog("Ievadiet savu mājas adrese, uz kuru sūtīt:");
        String telnum;

        do {
            telnum = JOptionPane.showInputDialog("Ievadiet savu tel.num (8 cipari, pirmais ir 2):");
        } while (!pareizsNum(telnum));

        if (adrese.equalsIgnoreCase("uz vietas"))
            piegadesCena = 0.0;
        else
            piegadesCena = 2.0;

        System.out.println(piegadesCena);
        

        String[] pizzas = {"Margherita", "Pepperoni", "Veģetārā", "Hawaiian", "Meat Lovers"};
        String picaName = (String) JOptionPane.showInputDialog(null, "Izvēlies picas veidu:", "Menu",
                JOptionPane.QUESTION_MESSAGE, null, pizzas, pizzas[0]);

        String[] izmeri = {"Small", "Medium", "Large"};
        String izmeruIzv = (String) JOptionPane.showInputDialog(null, "Select pizza size:", "Pizza Size",
                JOptionPane.QUESTION_MESSAGE, null, izmeri, izmeri[0]);

        Pizza piza = new Pizza(picaName, izmeruIzv, null);
        
        double papildusCena = 0.0;
        String[] piedevas = {"Sēnes", "Sīpoli", "Siers"};
        
  		  ImageIcon bilde1 = new ImageIcon("https://static.wikia.nocookie.net/fliplinestudios/images/b/ba/Mushroom_Pizzeria_HD.png/revision/latest/scale-to-width-down/220?cb=20170807090951");
          piedevas[0] = "<html><body><img width='100' height='100' src='" + bilde1 + "'></body></html>";
          ImageIcon bilde2 = new ImageIcon("https://b.thumbs.redditmedia.com/_plclbTLaVBkt8SdweAQFfOPQqAojsfRdRssDSNrpBY.png");
          piedevas[1] = "<html><body><img width='100' height='100' src='" + bilde2 + "'></body></html>";
          ImageIcon bilde3 = new ImageIcon("https://static.wikia.nocookie.net/fliplinestudios/images/4/4e/Unlocking_provolone_cheese.jpg/revision/latest/smart/width/250/height/250?cb=20150612154216");
          piedevas[2] = "<html><body><img width='100' height='100' src='" + bilde3 + "'></body></html>";
          
        int res = JOptionPane.showConfirmDialog(null,"Vai vēlaties papildus piedevas?", "Piedevas",
        	      JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        	if(res == 0) {
        		System.out.println("YES");
        		int choice = JOptionPane.showOptionDialog(null, "Izvēlaties papildus piedevas!", "Piedevas",
        	                 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, piedevas, piedevas[0]);
        	         if (choice != JOptionPane.CLOSED_OPTION) {
        	             papildusCena = 2.0;
        	             piza.setPapildusPiedevas(piedevas[choice]);
        	         }
        	    }else if (res == 1){
        	         System.out.println("Pressed NO");
        	         papildusCena = 0.0;
        	    }
        	
        double mercesCena = 0.0;
        String[] merces = {"Kečups", "Ķiploku mērce", "Majonēze"};
        
        ImageIcon bilde4 = new ImageIcon("https://static.wikia.nocookie.net/fliplinestudios/images/3/32/KetchupBottleBurgeriaHD.png/revision/latest?cb=20230610135252");
        merces[0] = "<html><body><img width='100' height='100' src='" + bilde4 + "'></body></html>";
        ImageIcon bilde5 = new ImageIcon("https://static.wikia.nocookie.net/faefarm/images/c/cc/Garlic.png/revision/latest?cb=20230926153212");
        merces[1] = "<html><body><img width='100' height='100' src='" + bilde5 + "'></body></html>";
        ImageIcon bilde6 = new ImageIcon("https://rimibaltic-res.cloudinary.com/image/upload/b_white,c_fit,f_auto,h_480,q_auto,w_480/d_ecommerce:backend-fallback.png/MAT_212319_PCE_LV");
        merces[2] = "<html><body><img width='100' height='100' src='" + bilde6 + "'></body></html>";
        
        int res2 = JOptionPane.showConfirmDialog(null,"Vai vēlaties mērci klāt?", "Mērces",
            	      JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null);
        	if(res2 == 0) {
        		System.out.println("YES");
        		int choice2 = JOptionPane.showOptionDialog(null, "Izvēlaties mērci!", "Mērces",
            	                 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, merces, merces[0]);
            		if (choice2 != JOptionPane.CLOSED_OPTION) {
            			mercesCena = 1.0;
            			piza.setPapildusPiedevas(merces[choice2]);
            			}
            		}
            	      else if (res == 1){
            	         System.out.println("Pressed NO");
            	         mercesCena = 0.0;
            	      }
        	 

        Pasutijums order = new Pasutijums(vards, adrese, telnum, piza, piegadesCena+papildusCena+mercesCena);
        orders.add(order);

        saglabatFaila(order);

        JOptionPane.showMessageDialog(null, "Veicam Jūsu pasūtījumu!", "Vika's Pizzeria.", JOptionPane.INFORMATION_MESSAGE);

    }

    public static boolean pareizsNum(String telnum) {
        return telnum.matches("2\\d{7}");
    }

    public static void apskatitPas() {
        if(orders.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nav Pasūtījumu.", "",JOptionPane.WARNING_MESSAGE);
        } else {
            JTextArea textArea = new JTextArea(20, 40);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);

            StringBuilder message = new StringBuilder("__________________Pasūtījumi__________________\n");
            for (Pasutijums order : orders) {
                message.append(order).append("\n________________________________________________________\n");
            }
            textArea.setText(message.toString());

            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(null, scrollPane, "Pasūtījumi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void saglabatFaila(Pasutijums order) {
        try {
            FileWriter writer = new FileWriter("pasutijumi.txt", true);
            writer.write(order.toString() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void apskatitPasutijumuFaila() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("pasutijumi.txt")));
            JOptionPane.showMessageDialog(null, content, "Visi pasūtījumi", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Pasutijums> orders = new ArrayList<>();

    public static void main(String[] args) throws MalformedURLException{
    	
    	final ImageIcon pizza = new ImageIcon(new URL("https://www4.minijuegosgratis.com/v3/games/thumbnails/202095_1.jpg"));
    	final ImageIcon starts = new ImageIcon(new URL("https://media.tenor.com/ZzMG3GSJdbQAAAAM/papa-louie-cooking.gif"));
        ImageIcon vikasPizzeria = new ImageIcon(picaa.class.getResource("/img/vikasPizzeria.png"));
        String izvele;
        String[] saakums = {"Veikt pasūtījumu", "Apskatīt pasūtījumus","Apkalpot klientu", "Apturēt programmu"};

        JOptionPane.showMessageDialog(null, "", "Laipni lūgti.. ",
                JOptionPane.QUESTION_MESSAGE, vikasPizzeria);

        do {
            izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību!", "Start!",
                    JOptionPane.QUESTION_MESSAGE, starts, saakums, saakums[0]);
            if (izvele == null)
                izvele = "Apturēt programmu";

            switch (izvele) {
                case "Veikt pasūtījumu":
                    veiktPasutijumu();
                    break;
                case "Apskatīt pasūtījumus":
                    apskatitPas();
                    break;
                case "Apkalpot klientu":
                    if (!orders.isEmpty()) {
                        orders.remove(0);
                        try {
                            FileWriter writer = new FileWriter("pasutijumi.txt");
                            for (Pasutijums order : orders) {
                                writer.write(order.toString() + "\n");
                            }
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null, "Klients apkalpots!", "Apkalpošana", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nav veikts neviens pasūtījums.", "Nav pasūtījumu", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case "Apturēt programmu":
                    JOptionPane.showMessageDialog(null, "Paldies, par pasūtījumu. Uzredzēšanos!", "Byeee!!",JOptionPane.ERROR_MESSAGE,pizza);
                    break;
            }
        } while (!izvele.equals("Apturēt programmu"));
    }
}