package entities;

import java.util.Date;

public class Reservation
{
    private int id;
    private Date dateDebut;
    private Date dateFin;
    private Client client;
    private Chambre chambre;
    private static int cmp = 0;

    public Reservation(Client client, Chambre chambre,Date dateDebut, Date dateFin) {
        this.id = ++cmp;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
        this.chambre = chambre;
    }
    
    public Reservation(int id, Client client, Chambre chambre,Date dateDebut, Date sateFin) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = sateFin;
        this.client = client;
        this.chambre = chambre;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = ++cmp;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

     public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", client=" + client +
                ", chambre=" + chambre +
                '}';
    }
}

