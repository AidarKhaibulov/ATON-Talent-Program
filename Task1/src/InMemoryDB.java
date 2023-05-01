public class InMemoryDB {
    RBT data;

    public InMemoryDB() {
        data = new RBT();
    }

    /**
     * Добавляет новую запись в базу с указанными параметрами
     * @param account
     * @param name
     * @param value
     */
    public void addData(long account, String name, double value) {
        data.insertNode(account, name, value);
    }
    /**
     * Удаляет из базы запись по ключу - account
     */
    public void deleteData(long account) {
        data.deleteNode(account);
    }

    /**
     * Изменяет существующую запись в базе по предоставленному ключу.
     * @param account предоставленный ключ-account
     * @param newName новое поле name
     * @param newValue новое поле value
     */

    public void editData(long account, String newName, double newValue) {
        data.editNode(account, newName, newValue);
    }

    /**
     * Поиск по указанному ключу-account
     * @param account
     */
    public void findDataByAccount(long account) {
        System.out.print("Found by account:");
        Node n = data.searchNode(account);
        System.out.println(n.data.name + " " + n.data.value);
    }
    /**
     * Поиск всех данных по указанному полю name
     * @param name
     */
    public void findDataByName(String name) {
        System.out.println("Found by name");
        Traverse t = new Traverse(data);
        t.findByName(data.getRoot(), name);
    }
    /**
     * Поиск всех данных по указанному полю value
     * @param value
     */
    public void findDataByValue(double value) {
        System.out.println("Found by value:");
        Traverse t = new Traverse(data);
        t.findByValue(data.getRoot(), value);
    }

    /**
     * Вывод на печать всей базы
     */
    public void print() {
        Traverse t = new Traverse(data);
        t.traverseInOrder(data.getRoot());
    }
}
