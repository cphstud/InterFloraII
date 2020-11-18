public class Buket {
    private int buketID;
    private String buketIndhold;
    private int buketPris;

    public Buket(int buketID, String buketIndhold, int buketPris) {
        this.buketID = buketID;
        this.buketIndhold = buketIndhold;
        this.buketPris = buketPris;
    }

    public int getBuketID() {
        return buketID;
    }

    public String getBuketIndhold() {
        return buketIndhold;
    }

    public int getBuketPris() {
        return buketPris;
    }
}
