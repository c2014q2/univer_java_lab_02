import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Admin extends User{
    private float lene;
    private float iq;
    private float salariu;

    public Admin() {
        super();
        drepturi_list.add("Administrarea sistemului");
        drepturi_list.add("Limiatarea drepturilor userilor");
        drepturi_list.add("Modificara codului-sursa");
        statut_social++;
        Random rand = new Random();

        lene = rand.nextFloat(1);
        iq = rand.nextFloat(200)+50;
        salariu = rand.nextFloat(2000)+500;
    }

    public Admin(int height, float weight, String eyes_color, boolean is_man, ArrayList<String> drepturi_list, float lene, float iq, float salariu) {
        super(height, weight, eyes_color, is_man, drepturi_list);
        statut_social++;
        if (lene >0 && lene <=1 ) {
            this.lene = lene;
        }
        if (iq >0 && iq<200) {
            this.iq = iq;
        }
        if (salariu > 0) {
            this.salariu = salariu;
        }

    }


    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Lene : " + lene);
        System.out.println("IQ : " + iq);
        System.out.println("Salariu : " + salariu+" $");
    }

    public Admin combineAdmins(Admin admin) {
        Admin new_admin = new Admin();
        new_admin.setLene( (this.lene + admin.getLene())/2 );
        new_admin.setIq( (this.iq + admin.getIq())/2 );

        ArrayList<String> templist = new ArrayList<>();  //cream un arratlist nou ca ulterior sa il setam noului admin
        templist.addAll(admin.getDrepturi_list());

        for(String t : drepturi_list) {
            if (drepturi_list.contains(t)) {                //Facem reuniunea intre cei doi admini

            }
            else {
                templist.add(t);
            }
        }
        new_admin.setDrepturi_list(templist);
        return new_admin;                                //returnam adminul nou
    }


    public void addDrepturiForUser(User user, String drept){
        if (user instanceof Admin) {
            throw new IllegalArgumentException("Un admin nu poate modifica drepturile altui admin");

        }
        else {
            user.addDrepturiInList(drept);
        }
    }


    public void removeDrepturiForUser(User user, int index){
        user.removeDrepturiFromList(index);
    }


    public float getLene() {
        return lene;
    }

    public void setLene(float lene) {
        if (lene >0 && lene<1) {

            this.lene = lene;
        }
    }

    public float getIq() {
        return iq;
    }

    public void setIq(float iq) {
        if (iq >0 && iq<200) {

            this.iq = iq;
        }
    }

    public float getSalariu() {
        return salariu;
    }

    public void setSalariu(float salariu) {
        if (salariu >= 500) {
            this.salariu = salariu;
        }
    }


    @Override
    public void saveObjectToFile(String nameFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile))) {
            writer.write("Statut Social: " + drepturi[statut_social] + "\n");
            writer.write("Height: " + height + " cm\n");
            writer.write("Weight: " + weight + " kg\n");
            writer.write("Eyes Color: " + eyes_color + "\n");
            writer.write("Is Man: " + (is_man ? "Yes" : "No") + "\n");
            writer.write("Lene : " + lene+ "\n");
            writer.write("IQ : " + iq+ "\n");
            writer.write("Salariu : " + salariu+" $"+ "\n");
        } catch (IOException e) {
            System.out.println("A aparut o eroare la scrierea în fisier: " + e.getMessage());
        }
    }




}
