package kerimbiber.kerimovic;


public class Haber {

	public static int COUNT = 0;
    private int id;
    private String haberadi;
    private String icerik;
    public Haber(String haberadi, String icerik) {
        this.id = COUNT;
        this.haberadi = haberadi;
        this.icerik = icerik;
    }
    public String getHaberadi() {
        return haberadi;
    }
    public String getIcerik() {
        return icerik;
    }

}
