package MyClasses;

import java.util.Date;
import java.sql.*;
import java.util.ArrayList;
import MyFrames.*;


public class Reservation {
    private String idReservation;
    private String idUtilisateur;
    private String idLivre;
    private Date dateReservation;
    private String statut;

    public Reservation(String idReservation, String idUtilisateur, String idLivre, Date dateReservation, String statut) {
        this.idReservation = idReservation;
        this.idUtilisateur = idUtilisateur;
        this.idLivre = idLivre;
        this.dateReservation = dateReservation;
        this.statut = statut;
    }

    public String getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(String idLivre) {
        this.idLivre = idLivre;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
    public static ArrayList<Reservation> AffReserv(String id_utilisateur){
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        ArrayList<Reservation> reserv = new ArrayList();
        try{
            connection = DBConnection.openConnection();
            pst = connection.prepareStatement("SELECT * FROM reservation WHERE id_utilisateur = ?");
            pst.setString(1, id_utilisateur);
            res = pst.executeQuery();
            while(res.next()){
                reserv.add(new Reservation(
                        res.getString("id_reservation"),
                        res.getString("id_utilisateur"),
                        res.getString("id_livre"),
                        res.getDate("date_reservation"),
                        res.getString("statut")
                
                ));
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
                
                
            }catch(SQLException e){
                e.getMessage();
            }
        }
        return reserv;
    }
    public static void AnnulerReservation(String idReservation){
        Connection connection = null;
        PreparedStatement pst = null;
        try{
            connection = DBConnection.openConnection();
            pst = connection.prepareStatement("DELETE FROM reservation WHERE id_reservation = ?");
            pst.setString(1,idReservation);
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
}
