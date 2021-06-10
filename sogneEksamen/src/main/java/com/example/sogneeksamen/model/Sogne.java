package com.example.sogneeksamen.model;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sogne")
public class Sogne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sognekode;
    private String navn;
    private boolean erNedlukket;

    @OneToOne
    @JoinColumn(name = "kommune_id", nullable = false)
    private Kommune kommune;
    private double smittetryk;
    private Date nedlukningsDato;

    public Sogne() {
    }

    public Sogne(int id, int sognekode, String navn, Kommune kommune, double smittetryk, Date nedlukningsDato, boolean erNedlukket) {
        this.id = id;
        this.sognekode = sognekode;
        this.navn = navn;
        this.kommune = kommune;
        this.smittetryk = smittetryk;
        this.nedlukningsDato = nedlukningsDato;
        this.erNedlukket = erNedlukket;
    }

    public Sogne(int sognekode, String navn, Kommune kommune, double smittetryk, Date nedlukningsDato) {
        this.sognekode = sognekode;
        this.navn = navn;
        this.kommune = kommune;
        this.smittetryk = smittetryk;
        this.nedlukningsDato = nedlukningsDato;
    }

    public boolean getErNedlukket() {
        return erNedlukket;
    }

    public void setErNedlukket(boolean erNedlukket) {
        this.erNedlukket = erNedlukket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSognekode() {
        return sognekode;
    }

    public void setSognekode(int sognekode) {
        this.sognekode = sognekode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Kommune getKommune() {
        return kommune;
    }

    public void setKommune(Kommune kommune) {
        this.kommune = kommune;
    }

    public double getSmittetryk() {
        return smittetryk;
    }

    public void setSmittetryk(double smitteryk) {
        this.smittetryk = smitteryk;
    }

    public Date getNedlukningsDato() {
        return nedlukningsDato;
    }

    public void setNedlukningsDato(Date nedlukningStart) {
        this.nedlukningsDato = nedlukningStart;
    }

    @Override
    public String toString() {
        return "Sogne{" +
                "id=" + id +
                ", sognekode=" + sognekode +
                ", navn='" + navn + '\'' +
                ", kommune='" + kommune + '\'' +
                ", smitteryk=" + smittetryk +
                ", nedlukningStart=" + nedlukningsDato +
                '}';
    }
}