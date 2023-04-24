package services;

import Connexion.Connexion;
import dao.IDAO;
import entities.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientService implements IDAO<Client> {
    //List<Client> clients;

    //public ClientService() {
    //    clients=new ArrayList<Client>();
    //}


    @Override
    public boolean create(Client o) {
        String req = "insert into client values (null,?,?,?,?)";
        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getTel());
            ps.setString(4, o.getEmail());
            if (ps.executeUpdate()==1) {
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Client o) {
        String req = "delete from client where id=?";
        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate()==1) {
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        //return clients.remove(o);
    }

    @Override
    public boolean update(Client o) {
        String req = "update client set nom=?, prenom=?, telephone=?, email=? where id=?";
        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            System.out.println("id = " + o.getId());
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getTel());
            ps.setString(4, o.getEmail());
            ps.setInt(5, o.getId());
            if (ps.executeUpdate()==1) {
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
//        Scanner scan = new Scanner(System.in);
//        for(Client c:clients) {
//            if (c.getId() == o.getId()) {
//                System.out.println("Le nom: ");
//                c.setNom(scan.nextLine());
//                System.out.println("Le prenom: ");
//                c.setPrenom(scan.nextLine());
//                System.out.println("Le telephone: ");
//                c.setTel(scan.nextLine());
//                System.out.println("L'email': ");
//                c.setEmail(scan.nextLine());
//                return true;
//            }
//        }
//        return false;
    }

    @Override
    public Client findById(int id) {
        String req = "select * from client where id=?";
        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
//        for(Client c:clients)
//        {
//            if(c.getId()==id) {
//                return c;
//            }
//        }
    }

    @Override
    public List<Client> findAll() {
        String req="select * from client ";
        List<Client> liste=new ArrayList<Client>();
        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                liste.add(new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("telephone"), rs.getString("email")));
            }
            return liste;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
//        return clients;
    }
}
