public class InMemoryDB {
    RBT data;

    public InMemoryDB(){
        data= new RBT();
    }
    public void addData(long account, String name, double value){
        data.insertNode(account,name,value);
    }
    public void deleteData(long account){
        data.deleteNode(account);
    }
    public void findDataByAccount(long account){
         Node n= data.searchNode(account);
         System.out.println(n.data.name+ " "+n.data.value);
    }
    public void findDataByName(String name){
        Node n= data.searchNode(name);
        System.out.println(n.data.account+ " "+n.data.value);
    }

    public void print(){
        DFS t= new DFS(data);
        t.traverseInOrder(data.getRoot());
    }
}
