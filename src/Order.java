public class Order {
    private String vards;
    private String adrese;
    private String tel;
    private Pizza pica;
    private double piegade;

    public Order(String vards, String adrese, String tel, Pizza pica, double piegade) {
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