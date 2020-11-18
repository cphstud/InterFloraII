import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ordre {
    int id;
    int phone;
    List<Buket> buketter;
    LocalDate ld;
    String status;

    public Ordre(int id, int phone, List<Buket> buketter, LocalDate ld) {
        this.phone = phone;
        this.buketter = buketter;
        this.id = id;
        this.ld = ld;
        this.status = "CREATED";
    }
    public Ordre(int id, int phone, LocalDate ld) {
        this.phone = phone;
        this.buketter = new ArrayList<>();
        this.id = id;
        this.ld = ld;
        this.status = "CREATED";
    }



    public int getId() {
        return this.id;
    }

    public int getPhone() {
        return this.phone;
    }

    public void addBuketToOrder(Buket buket) {
        buketter.add(buket);
    }

    public void setStatus(String status) {
        // CREATED,INPROGRES,DONE,CANCELED
        this.status = status;
    }
    public String getStatus() {
        return this.status;
    }
    public String printToCsv2() {
        //0;212121;@3,Mix bundt med 7 stilke pastel hortensia,275@5,Arranger selv bundt,22513,Queen blomsterbuket,275@;775;DONE
        String retVal = "";
        retVal += id;
        retVal += ";" + phone;
        retVal += ";";
        for (Buket b : buketter) {
            //retVal += "@" + b.getId();
            retVal += "@" + b;
        }
        retVal += "@";
        retVal += ";" + calcPrice();
        retVal += ";" + status;
        return retVal;
    }

    public String printToCsv() {
        //0;212121;@3,Mix bundt med 7 stilke pastel hortensia,275@5,Arranger selv bundt,22513,Queen blomsterbuket,275@;775;DONE
        String retVal = "";
        retVal += id;
        retVal += ";" + phone;
        retVal += ";@";
        for (Buket b: buketter ) {
            retVal += "@" + b.toString();
        }
        retVal += ";@";
        retVal += ";" + calcPrice();
        retVal += ";" + status;
        return retVal;
    }

    public int calcPrice() {
        int retVal = 0;
        for (Buket b:buketter) {
            retVal += b.getPrice();
        }
        return retVal;
    }
}