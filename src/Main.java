public class Main {
    public static void main(String[] args) {
        DbSQL dbSQL = new DbSQL();
        Studerende studerende = new Studerende(1,"Simon","Heegaard","Østervej","4640","24999288","Datamatiker");
        Studerende studerende1 = new Studerende(3,"Hej","Ok","Gikvej","4940","23432347","Datamatiker");

       // dbSQL.opretTabelStuderende();
        //dbSQL.opretTabelFag();
        //dbSQL.opretTabelStudfag();
        //dbSQL.indsaetStud(studerende);
        dbSQL.indsaetStud(studerende1);

    }
}
