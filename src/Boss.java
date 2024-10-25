import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class Boss extends Admin {
    private int lucratori;
    private ArrayList<Admin> lista_lucatori =  new ArrayList<Admin>();

    public Boss() {
        super();
        statut_social++;
        drepturi_list.add("Concedierea lucratorilor");
        drepturi_list.add("Angajarea lucratorilor");
        drepturi_list.add("Modificara salariul al lucratorilor");

    }

    public Boss(int height, float weight, String eyes_color, boolean is_man, ArrayList<String> drepturi_list, float lene, float iq, float salariu) {
        super(height, weight, eyes_color, is_man, drepturi_list, lene, iq, salariu);
    }

    public int getLucratori() {
        return lucratori;
    }

    public ArrayList<Admin> getLista_lucratori() {
        return lista_lucatori;
    }

    public void setLucratori( ArrayList<Admin> lista) {
        lista_lucatori = lista;
        lucratori = lista_lucatori.size();
    }

    public final void addLucratori(Admin admin) {
        lista_lucatori.add(admin);
        lucratori++;
    }

    public void concediereLucratori(Admin admin) {
        lista_lucatori.remove(admin);
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Lucratori: " + lucratori);
        for (Admin admin : lista_lucatori) {
            System.out.println("Admin -> " + admin.getIq() + "iq");
        }

    }

    public void recalculareSalariuForAdmin(Admin admin) {           //setarea salariului pentru un subalten
        float iq = admin.getIq();
        float salariu = admin.getSalariu();
        float lene = admin.getLene();

        if (lista_lucatori.contains(admin)) {

            if (iq * lene <=1) {
                admin.setSalariu(salariu * 1.1f);    //pribavca 10% :)
                System.out.println("Salariul a fost ridicat cu " + (salariu*1.1f) + "$");

            }
            else {
                admin.setSalariu(salariu * 0.9f);
                System.out.println("Salariul a fost scazut cu " + (salariu*0.9f) + "$");
            }
        }
        else {
            System.out.println("Adminul nu este subalten acestui Boss!");
        }
    }

    public static void concediereAdmin(Admin admin, Boss boss) {
        float iq = admin.getIq();
        float salariu = admin.getSalariu();
        float lene = admin.getLene();

        if (boss.lista_lucatori.contains(admin)) {
            if (iq * lene >=100) {
                boss.lista_lucatori.remove(admin);
                boss.lucratori--;
                System.out.println("Adminul a fost concediat !");
            }
            else {
                System.out.println("Acest admin nu poate fi concediat! (lucreaza prea bine :) )");
            }
        }
        else {
            System.out.println("Adminul nu este subalten acestui Boss!");
        }
    }


    public Boss combineBosses(Boss boss) {
        Boss new_boss = new Boss();
        ArrayList<Admin> temp = new ArrayList<Admin>();
        temp.addAll(lista_lucatori);                //implem lista cu subaltenii primului bos
        for (Admin admin : boss.lista_lucatori) {
            if (!temp.contains(admin)) {   //verificam daca nu se repeta adminii in lista
                temp.add(admin);
            }
        }
        new_boss.setLucratori(temp);
        return new_boss;

    }

    @Override
    public void saveObjectToFile(String nameFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile))) {
            writer.write("Statut Social: " + drepturi[statut_social] + "\n");
            writer.write("Lucratori: " + lucratori+ "\n");
            for (Admin admin : lista_lucatori) {
                writer.write("Admin -> " + admin.getIq()+ " IQ"+ "\n");
            }


        } catch (IOException e) {
            System.out.println("A aparut o eroare la scrierea în fisier: " + e.getMessage());

        }
    }

}
