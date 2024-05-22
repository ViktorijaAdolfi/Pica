@SuppressWarnings("unused")
public class Pizza {
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