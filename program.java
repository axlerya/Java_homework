import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * program
 */
public class program {
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();

        Notebook oneNotebook = new Notebook();
        oneNotebook.setRam(4);
        oneNotebook.setMemory(100);
        oneNotebook.setOs("Linux");
        oneNotebook.setColor("Black");

        Notebook twoNotebook = new Notebook();
        twoNotebook.setRam(6);
        twoNotebook.setMemory(150);
        twoNotebook.setOs("Windows");
        twoNotebook.setColor("White");

        Notebook threeNotebook = new Notebook();
        threeNotebook.setRam(8);
        threeNotebook.setMemory(200);
        threeNotebook.setOs("Windows");
        threeNotebook.setColor("White");

        Notebook fourNotebook = new Notebook();
        fourNotebook.setRam(6);
        fourNotebook.setMemory(250);
        fourNotebook.setOs("Windows");
        fourNotebook.setColor("Black");

        Notebook fiveNotebook = new Notebook();
        fiveNotebook.setRam(12);
        fiveNotebook.setMemory(500);
        fiveNotebook.setOs("Linux");
        fiveNotebook.setColor("White");

        notebooks.add(oneNotebook);
        notebooks.add(twoNotebook);
        notebooks.add(threeNotebook);
        notebooks.add(fourNotebook);
        notebooks.add(fiveNotebook);
        
        System.out.println(findByOrder(notebooks, selectOrder()));
    }

    static Set<Notebook> findByOrder(Set<Notebook> notebooks, HashMap<Integer, String> order) {
        int findRam = 1;
        int findMemory = 1;
        String findOs = order.get(3);
        String findColor = order.get(4);
        Set<Notebook> res = new HashSet<Notebook>();
        if (order.get(1) != null)
            findRam = Integer.parseInt(order.get(1));
        if (order.get(2) != null)
            findMemory = Integer.parseInt(order.get(2));
        if (order.get(3) != null)
            findOs = order.get(3);
        if (order.get(4) != null)
            findColor = order.get(4);

        for (Notebook notebook : notebooks) {
            if (order.get(3) != null && order.get(4) == null) { // если есть ОС и нет цвета
                if (notebook.getRam() >= findRam && notebook.getMemory() >= findMemory && notebook.getOs().equals(findOs)){
                    res.add(notebook);
                }
            }
            if (order.get(3) == null && order.get(4) != null) { // если нет ОС и есть цвет
                if (notebook.getRam() >= findRam && notebook.getMemory() >= findMemory && notebook.getColor().equals(findColor)){
                    res.add(notebook);
                }
            }
            if (order.get(3) != null && order.get(4) != null) { // если есть ОС и есть цвет 
                if (notebook.getRam() >= findRam && notebook.getMemory() >= findMemory &&
                    notebook.getColor().equals(findColor) && notebook.getOs().equals(findOs)){
                    res.add(notebook);
                }
            }
            if (order.get(3) == null && order.get(4) == null) { // если нет ОС и нет Цвета
                if (notebook.getRam() >= findRam && notebook.getMemory() >= findMemory){
                    res.add(notebook);
                }
            }
        }
        return res;
    }

    static HashMap<Integer, String> selectOrder() {
        HashMap<Integer, String> res = new HashMap<>();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Введите цифру, соответствующую необходимому критерию:\r\n" + //
                    "1 - ОЗУ\r\n" + //
                    "2 - Объем ЖД\r\n" + //
                    "3 - Операционная система\r\n" + //
                    "4 - Цвет\r\n" + //
                    "5 - Поиск");
            int select = in.nextInt();
            switch (select) {
                case 1:
                    System.out.println("Введите кол-во оперативной памяти: ");
                    res.put(1, in.next());
                    break;
                case 2:
                    System.out.println("Введите объем ЖД");
                    res.put(2, in.next());
                    break;
                case 3:
                    System.out.println("Введите операционную систему");
                    res.put(3, in.next());
                    break;
                case 4:
                    System.out.println("Введите цвет");
                    res.put(4, in.next());
                    break;
                case 5:
                    in.close();
                    return res;
            }
        }
    }
}