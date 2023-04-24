package services;
import java.sql.Date;

import Connexion.Connexion;
import dao.IDAO;
import entities.Chambre;
import entities.Client;
import entities.Reservation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationService implements IDAO<Reservation> {
    List<Reservation> reservations;

    public ReservationService() {
        reservations = new ArrayList<Reservation>();
    }

    @Override
    public boolean create(Reservation o) {
        //for(Reservation r:reservations) { // je fais un test seulement pour les chambres qui sont réservées
            //if(o.getChambre().getId() == r.getChambre().getId()) {
                 //if ((o.getDateDebut().after(r.getDateFin()) || o.getDateFin().before(r.getDateDebut())) && (o.getDateDebut().before(o.getDateFin())))  {
                     String req = "insert into reservation values(null, ?, ?, ?, ?)";
                     try {
                         PreparedStatement ps = Connexion.getCon().prepareStatement(req);
                         ps.setInt(1, o.getClient().getId());
                         ps.setInt(2, o.getChambre().getId());
                         ps.setDate(3, new Date(o.getDateDebut().getTime()));
                         ps.setDate(4, new Date(o.getDateFin().getTime()));

                         if (ps.executeUpdate()==1)
                             return true;
                     }
                     catch (SQLException e) {
                         e.printStackTrace();
                     }
                //}
            //}
        //}
        return false;
    }

    @Override
    public boolean delete(Reservation o) {
        String req="delete from reservation where id=?";
        try {
            PreparedStatement stmt = Connexion.getCon().prepareStatement(req);
            stmt.setInt(1,o.getId());
            if(stmt.executeUpdate()==1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Reservation o) {
        if(o.getDateDebut().after(o.getDateFin())) {
            System.out.println("Erreur: date debut depasse date fin!");
            return false;
        }

        boolean test = true;
        List<Reservation> reservations = this.findAll();
        for(Reservation r : reservations) {
            if (r.getId() != o.getId()) {
                if(r.getChambre().getId() == o.getChambre().getId()) {
                    if(!(o.getDateDebut().before(r.getDateDebut()) && o.getDateFin().before(r.getDateDebut())
                            || o.getDateDebut().after(r.getDateFin()) && o.getDateFin().after(r.getDateFin()))) {
                        test = false;
                        break;
                    }
                }
            }
        }

        if(test) {
            String req="update reservation set idClient=?,idChambre=?,dateDebut=?,dateFin=? where id=?";
            try {
                PreparedStatement stmt = Connexion.getCon().prepareStatement(req);
                stmt.setInt(1,o.getClient().getId());
                stmt.setInt(2,o.getChambre().getId());
                stmt.setDate(3,new Date(o.getDateDebut().getTime()));
                stmt.setDate(4,new Date(o.getDateFin().getTime()));
                stmt.setInt(5,o.getId());
                if (stmt.executeUpdate()==1)
                    return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Reservation findById(int id) {
        ClientService cls = new ClientService();
        ChambreService chs = new ChambreService();
        String req="select * from reservation where id=?";
        try {
            PreparedStatement stmt=Connexion.getCon().prepareStatement(req);
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()) {
                return new Reservation (rs.getInt(1),cls.findById(rs.getInt(2)),chs.findById(rs.getInt(3)),rs.getDate(4),rs.getDate(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
//        for(Reservation r:reservations)
//        {
//            if(r.getId()==id) {
//                return r;
//            }
//        }
//        return null;
    }

    @Override
    public List<Reservation> findAll() {
        ClientService cls = new ClientService();
        ChambreService chs = new ChambreService();
        String req = "select * from reservation";
        List<Reservation> Reservations=new ArrayList<Reservation>();
        try {
            PreparedStatement stmt = Connexion.getCon().prepareStatement(req);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                Reservations.add(new Reservation(rs.getInt(1),cls.findById(rs.getInt(2)),chs.findById(rs.getInt(3)),rs.getDate(4),rs.getDate(5)));
            }
            return Reservations;
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return null;
        //return reservations;
    }
    
    public List<Chambre> findChambreBetweenDates(Client clt, java.util.Date dateDebut, java.util.Date dateFin){
        String req;
        req = "select c.id,c.telephone,c.idcategorie from chambre c,reservation "
                + "where reservation.idChambre = c.id and reservation.idClient = ? and reservation.dateDebut>=? and reservation.dateFin<=?";
        List<Chambre> cham = new ArrayList<Chambre>();
        try {
            CategorieService cs = new CategorieService();
            PreparedStatement stmt = Connexion.getCon().prepareStatement(req);
            stmt.setInt(1, clt.getId());
            stmt.setDate(2, new Date(dateDebut.getTime()));
            stmt.setDate(3, new Date(dateFin.getTime()));
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                cham.add(new Chambre(res.getInt(1), res.getString(2), cs.findById(res.getInt(3))));
            }
            return cham;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
