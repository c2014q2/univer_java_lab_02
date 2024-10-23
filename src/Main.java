import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        User user0 = new User();
        User user1 = new User();
        User user2 = new User();

        Admin admin0 = new Admin();
        Admin admin1 = new Admin();
        Admin admin2 = new Admin();

        Boss boss0 = new Boss();
        Boss boss1 = new Boss();

        Om[] planctons = new Om[]{user0, user1, user2, admin0, admin1, admin2, boss0, boss1};

        for(Om om : planctons){
          //  om.printDetails();
        }

        System.out.println(user0.getDrepturi_list());  //drepturile userului 0
        admin0.removeDrepturiForUser(user0,1);   //stergerea drepturilor
        admin0.removeDrepturiForUser(user0,0);   //stergerea drepturilor
        System.out.println(user0.getDrepturi_list());  //drepturile userului 0 dupa ce au fst sterse de admin0

        admin0.addDrepturiForUser(user0, "Sa inchida programul");  //adminul de asemenea poate si sa adauge drepturi
        System.out.println(user0.getDrepturi_list());

        boss0.recalculareSalariuForAdmin(admin0);     //bossul nu poate sa modifice salariile sau sa concedieze adminii
                                                        // daca acestia nu sunt subaltenii lui!

        boss0.addLucratori(admin0);   //adaugam in adminul in lista pentru ai putea modifica salariul/concedia
        boss0.recalculareSalariuForAdmin(admin0);  //acum putem folosi aceasta metoda catre admin0


        boss0.concediereAdmin(admin0);  //bossul vrea sa il concedieze pe admin0! (daca adminul este lazy va fi concediat!)

        admin2 = admin0.combineAdmins(admin1);   //admin2 devine rezulatul combinarii a amin0 si admin1 ;)

        boss1.addLucratori(admin2);
        boss1.addLucratori(admin1);

        Boss boss2 = boss0.combineBosses(boss1); //combinam 2 bosi in unul singur, astfel boss2 are subalternii celor 2 bosi impreuna
        boss2.printDetails(); //detaliile boss2 cu 3 subalteni de la bosii

        boss2.saveObjectToFile("boss2.txt");








    }
}

