package MyClasses;

import java.util.Date;

public class Emprunt {
    private String idEmprunt;
    private String idUtilisateur;
    private String idLivre;
    private Date dateEmprunt;
    private Date dateRetour;
    private String statut;

    public Emprunt(String idEmprunt, String idUtilisateur, String idLivre, Date dateEmprunt, Date dateRetour, String statut) {
        this.idEmprunt = idEmprunt;
        this.idUtilisateur = idUtilisateur;
        this.idLivre = idLivre;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.statut = statut;
    }

    public String getIdEmprunt() {
        return idEmprunt;
    }

    public void setIdEmprunt(String idEmprunt) {
        this.idEmprunt = idEmprunt;
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

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
    
}
