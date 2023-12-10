package MyClasses;

import java.sql.*;
import MyFrames.*;
import java.util.UUID;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;


public class Utilisateur {
    private String id;
    private String nom;
    private String prenom;
    private String login;
    private String pwd;
    private String role;

    public Utilisateur(String id, String nom, String prenom, String login, String pwd, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.pwd = pwd;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }

    public String getRole() {
        return role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public static ArrayList<Livre> RechercheUnLivre(String titre){
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        ArrayList<Livre> livres = new ArrayList<>();
        try{
            connection = DBConnection.openConnection();
            pst = connection.prepareStatement("SELECT * FROM livre WHERE titre = ?");
            pst.setString(1,titre);
            res = pst.executeQuery();
            while(res.next()){
                Livre livre = new Livre(
                    res.getString("id_livre"),
                    res.getString("titre"),
                    res.getString("auteur"),
                    res.getString("genre"),
                    res.getString("dispo")
                );
                livres.add(livre);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(pst!=null && res!=null ){
                    connection.close();
                    pst.close();
                    res.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return livres;
    }
    public void Emprunter(String idLivre,String idUser){
        
        Connection connection = null;
        PreparedStatement pst = null;
        PreparedStatement pst1 = null;
        PreparedStatement pst3 = null;
        PreparedStatement pst4 = null;
        ResultSet res = null;
        ResultSet res1 = null;
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, 21);
        
        try{
            connection = DBConnection.openConnection();
            pst4 = connection.prepareStatement("SELECT * FROM livre WHERE id_livre = ? and dispo = 'Disponible'");
            pst4.setString(1, idLivre);
            res1 = pst4.executeQuery();
            if(res1.next()){
                pst = connection.prepareStatement("INSERT INTO emprunt VALUES(?,?,?,?,?,?)");
                pst.setString(1,  "E"+UUID.randomUUID().toString());
                pst.setString(2, idUser);
                pst.setString(3, idLivre);
                pst.setDate(4,new java.sql.Date(today.getTime()));
                pst.setDate(5, new java.sql.Date(calendar.getTimeInMillis()));
                pst.setString(6,  "En cours");
                pst.executeUpdate();
                javax.swing.JOptionPane.showMessageDialog(null, "Livre emprunté avec succé");
                pst3 = connection.prepareStatement("UPDATE livre set dispo = ? WHERE id_livre = ? ");
                pst3.setString(1,"Indisponible");
                pst3.setString(2, idLivre);
                pst3.executeUpdate();
                pst1 = connection.prepareStatement("SELECT id_livre FROM reservation WHERE id_livre = ?");
                pst1.setString(1, idLivre);
                res = pst1.executeQuery();
                
                if(res.next()){
                    PreparedStatement pst2 = connection.prepareStatement("update reservation set statut = 'Confirmé' WHERE id_livre = ?");
                    pst2.setString(1,idLivre);
                    pst2.executeUpdate();
                    pst2.close();
                }
            }else {
                javax.swing.JOptionPane.showMessageDialog(null, "Livre inexistant ou livre indosponible!");
            }
            

        }catch(SQLException e){
            
            e.printStackTrace();
            
        }finally {
            try{
                if(pst!=null && res!=null&&pst1!=null){
                connection.close();
                pst.close();
                res.close();
                pst1.close();
                
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    public boolean LivreEstReserve(String idLivre) {
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        try {
            connection = DBConnection.openConnection();
            pst = connection.prepareStatement("SELECT * FROM reservation WHERE id_utilisateur = ? AND id_livre = ? AND statut = 'En Attente'");
            pst.setString(1, this.getId());
            pst.setString(2, idLivre);
            res = pst.executeQuery();
            return res.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null && res != null) {
                    connection.close();
                    pst.close();
                    res.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    public void ReservationLivreEnLigne(String idLivre){
        Connection connection = null;
        PreparedStatement pst = null;
        Calendar calendar = Calendar.getInstance();
        
            try{
            connection = DBConnection.openConnection();
            pst = connection.prepareStatement("INSERT INTO reservation VALUES(?,?,?,?,?)");
            pst.setString(1, "R"+UUID.randomUUID().toString());
            pst.setString(2, this.getId());
            pst.setString(3, idLivre);
            pst.setTimestamp(4, new java.sql.Timestamp(calendar.getTime().getTime()));
            pst.setString(5,"En Attente");
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }finally {
            try{
                if(pst!=null&&connection!=null){
                connection.close();
                pst.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        
        
    }
    public ArrayList<Emprunt> HistoriqueEmprunts(){
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        ArrayList<Emprunt> emprunts = new ArrayList();
        
        try{
            
            connection = DBConnection.openConnection();
            pst = connection.prepareStatement("SELECT * FROM emprunt WHERE id_utilisateur = ? ");
            pst.setString(1,this.getId());
            res = pst.executeQuery();
            while(res.next()){
                
                emprunts.add(new Emprunt(
                    res.getString("id_emprunt"),
                    res.getString("id_utilisateur"),
                    res.getString("id_livre"),
                    res.getDate("date_emprunt"),
                    res.getDate("date_retour"),
                    res.getString("statut")));
            }
        }catch(SQLException e){
            e.getMessage();
        }finally{
            try{
                if(pst!=null&&res!=null){
                    DBConnection.closeConnection();
                    pst.close();
                    res.close();
                }
                return emprunts;
                
            }catch(SQLException e){
                e.getMessage();
            }
        }
        return emprunts;
    }
    public void DemandeRetourLivre(String idLivre){
        Connection connection = null;
        PreparedStatement pst = null;
        try{
            connection = DBConnection.openConnection();
            pst = connection.prepareStatement("INSERT INTO demretliv VALUES(?,?,?)");
            pst.setString(1, UUID.randomUUID().toString());
            pst.setString(2, idLivre);
            pst.setString(3, this.getId());
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }finally{
            try{
                if(pst!=null){
                    DBConnection.closeConnection();
                    pst.close();
                }
            }catch(SQLException e){  
                e.getMessage();
            }}
    }
    public void RetourLivre(String idLivre,String idDem){
        Connection connection = null;
        PreparedStatement pst = null;
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        PreparedStatement pst3 =null;
        ResultSet res = null;
        try{
            connection = DBConnection.openConnection();
            pst2 = connection.prepareStatement("SELECT * FROM emprunt WHERE id_livre = ? ");
            pst2.setString(1, idLivre);
            res = pst2.executeQuery();
            if (res.next()) { // This line is added
                String idEmpr = res.getString("id_emprunt");
                pst = connection.prepareStatement("UPDATE emprunt set statut = ? WHERE id_emprunt = ? ");
                pst.setString(2, idEmpr);
                pst.setString(1,"Terminé");
                pst.executeUpdate();
                pst1 = connection.prepareStatement("UPDATE livre set dispo = ? WHERE id_livre = ? ");
                pst1.setString(1,"Disponible");
                pst1.setString(2,idLivre);
                this.NotifierUtilisateur("Livre" +idLivre +"a ete retourné avec succé", res.getString("id_utilisateur"));
                javax.swing.JOptionPane.showMessageDialog(null, "Livfe a été retourné avec succé!");
                pst1.executeUpdate();
                pst3 = connection.prepareStatement("DELETE FROM demretliv WHERE id_demande = ?");
                pst3.setString(1,idDem);
                pst3.executeUpdate();
            }else{
                javax.swing.JOptionPane.showMessageDialog(null, "Ce livre n'a pas été emprunté ");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Erreur!");
        }finally{
            try{
                if(pst!=null && pst1!=null && pst2!=null && res!=null){
                    DBConnection.closeConnection();
                    pst.close();
                    pst1.close();
                    pst2.close();
                    res.close();
                }
            }catch(SQLException e){  
                e.getMessage();
            }}
    }
    public void NotifierUtilisateur(String notif_text,String idUtil) {
    Connection connection = null;
    PreparedStatement pst = null;

    try {
        connection = DBConnection.openConnection();
        pst = connection.prepareStatement("INSERT INTO notification VALUES (?, ?, ?)");

        pst.setString(1, "N"+UUID.randomUUID().toString());
        pst.setString(2, idUtil);
        pst.setString(3, notif_text);

        pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (connection != null) {
                    DBConnection.closeConnection();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void AjoutEE(String Nom,String PR,String Login,String MP){
        Connection connection = null;
        PreparedStatement pst = null;
        try{
            connection = DBConnection.openConnection();
            pst = connection.prepareStatement("INSERT INTO utilisateur VALUES(?,?,?,?,?)");
            pst.setString(1, "U"+UUID.randomUUID().toString());
            pst.setString(2, Nom);
            pst.setString(3, PR);
            pst.setString(4, Login);
            pst.setString(5, MP);
            pst.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }finally{
           try{
                if(pst!=null){
                    DBConnection.closeConnection();        
                    pst.close();
                }
            }catch(SQLException e){
                e.getMessage();
            }
        }
    }
   

}
