package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connexion.Connexion;
import dao.IDAO;
import entities.Categorie;
import entities.Chambre;

public class ChambreService implements IDAO<Chambre> {
    
    private CategorieService cs = new CategorieService();
    
    @Override
    public boolean create(Chambre o) {
        String req = "insert into chambre values(null,?,?)";
        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ps.setString(1, o.getTelephone());
            ps.setInt(2, o.getCategorie().getId());
            if (ps.executeUpdate()==1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Chambre o) {
        String req = "update chambre set telephone=?, idcategorie=? where id=?";
        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ps.setString(1, o.getTelephone());
            ps.setInt(2, o.getCategorie().getId());
            ps.setInt(3, o.getId());
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
    public boolean delete(Chambre o) {
        String req = "delete from chambre where id=?";
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
    }

    @Override
    public Chambre findById(int id) {
          String req = "select * from chambre where id=?";
        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Chambre(rs.getInt(1), rs.getString(2), cs.findById(rs.getInt(3)));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Chambre> findAll() {
        String req="select * from chambre";
        List<Chambre> liste=new ArrayList<Chambre>();
        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                liste.add(new Chambre(rs.getInt(1), rs.getString(2), cs.findById(rs.getInt(3))));
            }
            return liste;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Chambre> findChambreByCategorie(Categorie c){
		String req="select * from chambre where idCategorie= ?";
		List<Chambre> C = new ArrayList<Chambre>();
		try {
			PreparedStatement ps= Connexion.getCon().prepareStatement(req);
			ps.setInt(1, c.getId());
			ResultSet E =ps.executeQuery();
			CategorieService cs = new CategorieService();
			while(E.next())
				C.add(new Chambre(E.getInt(1),E.getString(2),cs.findById(E.getInt(3))));
			return C;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
