public class Main {
    public static void main(String[] args) {
        InMemoryDB db= new InMemoryDB();
        db.addData(1,"v2",1.2);
        db.addData(2,"v2",1.4);
        db.addData(3,"v3",1.2);
        db.addData(4,"v4",1.2);
        db.addData(5,"v4",1.7);
        db.addData(6,"v2",1.1);
        db.addData(12,"v4",1.3);
        db.deleteData(12);
        db.editData(6,"newV",222.2);
        db.findDataByAccount(6);
        db.findDataByName("v4");
        db.findDataByValue(1.2);

    }
}