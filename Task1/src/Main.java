public class Main {
    public static void main(String[] args) {
        InMemoryDB db= new InMemoryDB();
        db.addData(1,"s",200.3);
        db.addData(2,"f",200.3);
        db.addData(3,"d",200.3);
        db.addData(4,"s",200.3);
        db.addData(5,"aa",200.3);
        db.addData(6,"v",200.3);
        db.addData(7,"v",200.3);
        db.addData(12,"b",200.3);
        db.findDataByAccount(5);
        db.findDataByName("a");
    }
}