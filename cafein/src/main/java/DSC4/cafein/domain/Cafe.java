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

    public int getOccupied_s() {
        return occupied_s;
    }

    public void setOccupied_s(int seat) {
        this.occupied_s = seat;
    }

    public int getTotal_s() {
        return total_s;
    }

    public void setTotal_s(int total_s) {
        this.total_s = total_s;
    }

    public String name;
    public String lati;
    public String longi;
    public int occupied_s;
    public int total_s;
}
