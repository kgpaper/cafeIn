package DSC4.cafein.domain;

public class Cafe {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLati() {
        return lati;
    }

    public void setLati(String lati) {
        this.lati = lati;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String name;
    public String lati;
    public String longi;
    public int seat;
}
