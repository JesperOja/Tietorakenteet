package BinarySearch;

import java.util.Arrays;

public class Menu {
    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        char select;
        do {

            System.out.println("\n\t\t\t1. Lisää avain.");
            System.out.println("\t\t\t2. Etsi avaimella.");
            System.out.println("\t\t\t3. Tulosta lista");
            System.out.println("\t\t\t4. Lopetus");
            System.out.print("\n\n"); // tehdään tyhjiä rivejä
            select = Lue.merkki();
            switch (select) {
                case '1':
                    System.out.println("Anna uusi avain (numero)");
                    int data = Lue.kluku();
                    search.add(data);
                    break;
                case '2':
                    System.out.println("Anna etsittävä avain (numero)");
                    data = Lue.kluku();
                    if (search.Search(search.getList(), data, 0, search.getList().length) > -1) {
                        System.out.println("Avain löytyi.");
                    } else
                        System.out.println("Avainta ei löytynyt.");

                    break;
                case '3':
                    int[] list = search.getList();
                    System.out.println("");
                    Arrays.sort(list);
                    for (int i : list) {
                        System.out.println(i +",");
                    }
                    break;
                case '4':
                    break;
            }
        } while (select != '4');

    }
}
