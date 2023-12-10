package Menu;
import javax.swing.JComponent;
import net.miginfocom.swing.MigLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.net.URL;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;  

public class BiblioMenu extends JComponent {
    private MigLayout layout;
    private MenuEvent event;
    public MenuEvent getEvent(){
        return this.event;
    }
    public void setEvent(MenuEvent event){
        this.event = event;
    }
    private String [] menu = new String[]{
        "Dashboard",
        "Paramètres de profil",
        "Consulter les livres",
        "Ajouter un livre",
        "Supprimer un livre",
        "Emprunter un livre",
        "Retourner un livre",
        "Notifier un utilisateur",
        "Se déconnecter"
    };
    public BiblioMenu(){
        init();
    }
    private void init(){
        layout = new MigLayout("wrap 1,fillx,gapy 0,insets 20 10 2 2",
             "fill"
        );
        setLayout(layout);
        for(int i = 0 ; i < menu.length ; i++){
            addMenu(menu[i],i);
        }
    }
    private void addMenu(String menuName , int index){
        int length = menu[index].length();
        MenuItem item = new MenuItem(menuName,index);
        Icon icon = getIcon(index+10);
        if(icon!=null){
            item.setIcon(icon);
        }
        item.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent ae){
                if(event != null){
                    event.selected(index);
                }
            }
        });
        add(item);
        revalidate();
        repaint();
        
        
    }
    private Icon getIcon(int index){
        URL url = getClass().getResource("/Assets/"+index+".png");
        if(url!=null){
            return new ImageIcon(url);
        }else{
            return null;
        }
    }
    
    protected void paintComponent(Graphics graphics) {
        // Call the superclass implementation to ensure proper behavior
        super.paintComponent(graphics);

        // Set the background color to RGB(26, 26, 26)
        graphics.setColor(new Color(60, 60, 60));
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }
}
