import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Metodes {
	
	public static ArrayList<Order> veiktPasutijumu(ArrayList<Order> orders) {
        double piegadesCena;
        String vards = JOptionPane.showInputDialog("Ievadiet savu vārdu:");
        String adrese = JOptionPane.showInputDialog("\nIevadot 'uz vietas', pasūtījumu varēsiet izņemt uz vietas."
        		+ "\nIevadiet savu mājas adrese, uz kuru sūtīt:");
        String telnum;

        do {
            telnum = JOptionPane.showInputDialog("Ievadiet savu tel.num (8 cipari, pirmais ir 2):");
        } while (!pareizsNum(telnum));

        if (adrese.equalsIgnoreCase("uz vietas"))
            piegadesCena = 0.0;
        else
            piegadesCena = 2.0;
        
        JOptionPane.showMessageDialog(null, "Sazvanīsim Jūs, kad pica būs gatava..");

        System.out.println(piegadesCena);
        

        String[] pizzas = {"Margherita", "Pepperoni", "Veģetārā", "Hawaiian", "Meat Lovers"};
        String picaName = (String) JOptionPane.showInputDialog(null, "Izvēlies picas veidu:", "Menu",
                JOptionPane.QUESTION_MESSAGE, null, pizzas, pizzas[0]);

        String[] izmeri = {"Small", "Medium", "Large"};
        String izmeruIzv = (String) JOptionPane.showInputDialog(null, "Small 5EUR"
        		+ "\nMedium 7EUR"
        		+ "\nLarge 9EUR"
        		+ "\nSelect pizza size:", "Pizza Size",
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
          
          
        int res = JOptionPane.showConfirmDialog(null,"Vai vēlaties papildus piedevas?"
        		+ "\nPiedevu cena 2EUR", "Piedevas",
        	      JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        	if(res == 0) {
        		System.out.println("YES");
        		int choice = JOptionPane.showOptionDialog(null, "Izvēlaties papildus piedevas!", "Piedevas",
        	                 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, piedevas, piedevas[0]);
        	         if (choice != JOptionPane.CLOSED_OPTION) {
        	             papildusCena = 2.0;
        	             piza.setPapildusPiedevas(piedevas[choice]);
        	         }
        	         int res1 = JOptionPane.showConfirmDialog(null,"Vai vēlaties vēl kādu papildus piedevu?"
        	         		+ "\n(+2EUR)", "Piedevas",
        	         	      JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        	         	if(res1 == 0) {
        	         		System.out.println("YES");
        	         		int choice1 = JOptionPane.showOptionDialog(null, "Izvēlaties papildus piedevas!", "Piedevas",
        	         	                 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, piedevas, piedevas[0]);
        	         	         if (choice1 != JOptionPane.CLOSED_OPTION) {
        	         	             papildusCena = papildusCena + 2.0;
        	         	             piza.setPapildusPiedevas(piedevas[choice1]);
        	         	         }
        	         	    }else if (res1 == 1){
        	         	         System.out.println("Pressed NO");
        	         	         papildusCena = 2.0;
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
        
        int res2 = JOptionPane.showConfirmDialog(null,"Vai vēlaties mērci klāt?"
        		+ "\nMērces cena 1EUR", "Mērces",
            	      JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null);
        	if(res2 == 0) {
        		System.out.println("YES");
        		int choice2 = JOptionPane.showOptionDialog(null, "Izvēlaties mērci!", "Mērces",
            	                 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, merces, merces[0]);
            		if (choice2 != JOptionPane.CLOSED_OPTION) {
            			mercesCena = 1.0;
            			piza.setPapildusPiedevas(merces[choice2]);
            			}
            		
            		int res2_2 = JOptionPane.showConfirmDialog(null,"Vai vēlaties vēl kādu mērci klāt?"
            				+ "(+1EUR)", "Mērces",
                  	      JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null);
              	if(res2_2 == 0) {
              		System.out.println("YES");
              		int choice2_2 = JOptionPane.showOptionDialog(null, "Izvēlaties mērci!", "Mērces",
                  	                 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, merces, merces[0]);
                  		if (choice2_2 != JOptionPane.CLOSED_OPTION) {
                  			mercesCena = mercesCena + 1.0;
                  			piza.setPapildusPiedevas(merces[choice2_2]);
                  			}
                  		}
                  	      else if (res2_2 == 1){
                  	         System.out.println("Pressed NO");
                  	         mercesCena = 1.0;
                  	      }
            		}
            	      else if (res2 == 1){
            	         System.out.println("Pressed NO");
            	         mercesCena = 0.0;
            	      }
        	

        Order order = new Order(vards, adrese, telnum, piza, piegadesCena+papildusCena+mercesCena);
        orders.add(order);

        saglabatFaila(order);

        JOptionPane.showMessageDialog(null, "Veicam Jūsu pasūtījumu!", "Vika's Pizzeria.", JOptionPane.INFORMATION_MESSAGE);
        return orders;
    }
	public static boolean pareizsNum(String telnum) {
        return telnum.matches("2\\d{7}");
    }

    public static void apskatitPas(ArrayList<Order> orders) {
        if(orders.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nav Pasūtījumu.", "",JOptionPane.WARNING_MESSAGE);
        } else {
            JTextArea textArea = new JTextArea(20, 40);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);

            StringBuilder message = new StringBuilder("__________________Pasūtījumi__________________\n");
            for (Order order : orders) {
                message.append(order).append("\n________________________________________________________\n");
            }
            textArea.setText(message.toString());

            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(null, scrollPane, "Pasūtījumi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void saglabatFaila(Order order) {
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
    
    public static void vesture() {
    	try (BufferedReader reader = new BufferedReader(new FileReader("pasutijumi.txt"))){
			String line = reader.readLine();
			JTextArea textArea = new JTextArea(20, 40);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            JScrollPane scrollPane = new JScrollPane(textArea);             
            StringBuilder message = new StringBuilder("__________________Pasūtījumi__________________\n");
			int counter = 1;
			while (line != null) {
				if (counter <= 8) {
					System.out.println(line);
    				message.append(line + "\n");
    				line = reader.readLine();
    				counter++;
				} else {
					message.append("______________________________________________\n");
					counter = 1;
				}
			}
			textArea.setText(message.toString());
			JOptionPane.showMessageDialog(null, scrollPane, "Pasūtījumi", JOptionPane.INFORMATION_MESSAGE);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public static void apkalpot(ArrayList<Order> orders) {
    	if (!orders.isEmpty()) {
            orders.remove(0);        
            JOptionPane.showMessageDialog(null, "BZzZZzzz.. bZZzzz.. BzZZz", "Telefons", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Apkalpojam klientu.", "Apkalpošana", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Klients apkalpots!", "Apkalpošana", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nav veikts neviens pasūtījums.", "Nav pasūtījumu", JOptionPane.WARNING_MESSAGE);
        }
    }
}