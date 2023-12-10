package MyClasses;

import MyFrames.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class Livre {
    private String idLivre;
    private String titre;
    private String auteur;
    private String genre;
    private String dispo;
    public Livre(){}
    public Livre(String idLivre,String titre,String auteur,String genre,String dispo){
        this.idLivre = idLivre;
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.dispo = dispo;
    }
    public String getidLivre(){
        return this.idLivre;
    }
    public void setidLivre(String idLivre){
        this.idLivre = idLivre;
    }
    public String getTitre(){
        return this.titre;
    }
    public void setTitre(String titre){
        this.titre = titre;
    }
    public String getAuteur(){
        return this.auteur;
    }
    public void setAuteur(String auteur){
        this.auteur = auteur;
    }
    public String getGenre(){
        return this.genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public String getDispo(){
        return this.dispo;
    }
    public void setDispo(String dispo){
        this.dispo = dispo;
    }
    public String toString(){
        return "Livre" + "id : " +this.idLivre+ 
                "titre : " +this.titre + 
                "auteur : " +this.auteur + 
                "genre : " +this.genre +  
                "dispo : " +this.dispo;
    }
    public static void SuppLivre(String idLivre){
        Connection connection = null;
        PreparedStatement pst = null;
        try{
                connection = DBConnection.openConnection();
                pst = connection.prepareStatement("DELETE FROM livre WHERE id_livre = ?");
                pst.setString(1, idLivre);
                pst.executeUpdate();
        }catch(SQLException e){
                e.getMessage();
        }finally {
            try{
                if(pst!=null){
                    DBConnection.closeConnection();        
                    pst.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    public static void AjoutLivre(String titre,String auteur,String genre,String dispo){
        Connection connection = null;
        PreparedStatement pst = null;
        try{
            connection = DBConnection.openConnection();
            pst = connection.prepareStatement("INSERT INTO livre VALUES(?,?,?,?,?)");
            pst.setString(1, "L"+UUID.randomUUID().toString());
            pst.setString(2, titre);
            pst.setString(3, auteur);
            pst.setString(4, genre);
            pst.setString(5, dispo);
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
    public static ArrayList<Livre> ConsulterCatalgoue(){
        Connection connection  = null;
        Statement st = null;
        ResultSet res = null;
        ArrayList <Livre> livres = new ArrayList();
        try{
            connection = DBConnection.openConnection();
            st = connection.createStatement();
            res = st.executeQuery("SELECT * FROM livre");
            while(res.next()){
                livres.add(new Livre(
                        res.getString("id_livre"),
                        res.getString("titre"),
                        res.getString("auteur"),
                        res.getString("genre"),
                        res.getString("dispo")
                ));
            }
            return livres;
        }catch(SQLException e){
            e.getMessage();
        }finally{
            try{
                if(st!=null&&res!=null){
                    DBConnection.closeConnection();        
                    st.close();
                    res.close();
                }
            }catch(SQLException e){
                e.getMessage();
            }}
        return null;
    }
}