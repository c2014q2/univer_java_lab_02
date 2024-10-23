import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class User extends Om implements FileSave {

    protected ArrayList<String> drepturi_list;

    public User() {
        super();
        statut_social++;
        drepturi_list = new ArrayList<String>();
        drepturi_list.add("Introducerea datelor in sistem");
        drepturi_list.add("Stergerea datelor introduse");

    }

    public User(int height, float weight, String eyes_color, boolean is_man, ArrayList<String> drepturi_list) {
        super(height, weight, eyes_color, is_man);
        this.drepturi_list = drepturi_list;
        statut_social++;

    }



    public ArrayList<String> getDrepturi_list() {
        return drepturi_list;
    }

    public void setDrepturi_list(ArrayList<String> drepturi_list) {
        if (drepturi_list != null) {
            this.drepturi_list = drepturi_list;
        }
        else throw new IllegalArgumentException(drepturi[statut_social]+" trebuie sa aiba drepturi!");
    }


    public void removeDrepturiFromList(int index){
        drepturi_list.remove(index);
    }

    public void addDrepturiInList(String drept){
        drepturi_list.add(drept);
    }

    @Override
    public void printDetails(){
        super.printDetails();
        System.out.println("Statut Social: " + drepturi[statut_social]);
        System.out.println("Drepturile:");
        for(String detaliu:drepturi_list){
            System.out.println(" -> "+detaliu);
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
        } catch (IOException e) {
            System.out.println("A aparut o eroare la scrierea în fisier: " + e.getMessage());
        }
    }

}




