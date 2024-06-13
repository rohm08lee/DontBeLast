import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("notlast.in"));
        PrintWriter pw = new PrintWriter("notlast.out");
        int n = sc.nextInt();
        if (n >= 7) {
            HashMap<String, Integer> cowList = new HashMap<>();
            String[] names = {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                int prod = sc.nextInt();
                if (cowList.containsKey(name)) {
                    int temp = cowList.get(name);
                    cowList.remove(name);
                    cowList.put(name, temp + prod);
                } else {
                    cowList.put(name, prod);
                }
            }
            int[] cowCount = new int[7];
            for (int i = 0; i < cowCount.length; i++) {
                cowCount[i] = cowList.get(names[i]);
            }
            Arrays.sort(cowCount);
            int min = cowCount[0];
            boolean same = true;
            for (int i = 0; i < 7; i++) {
                if (cowCount[i] != min) {
                    min = cowCount[i];
                    same = false;
                    break;
                }
            }
            if (same) {
                pw.println("Tie");
                pw.close();
            }
            for (int i = 0; i < 7; i++) {
                if (cowList.get(names[i]) == min) {
                    pw.println(names[i]);
                    break;
                }
            }

            pw.close();
        } else {
            HashMap<String, Integer> cowList = new HashMap<>();
            ArrayList<String> names = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                if (!names.contains(name)) {
                    names.add(name);
                }
                int prod = sc.nextInt();
                if (cowList.containsKey(name)) {
                    int temp = cowList.get(name);
                    cowList.remove(name);
                    cowList.put(name, temp + prod);
                } else {
                    cowList.put(name, prod);
                }
            }
            int[] cowCount = new int[names.size()];
            for (int i = 0; i < cowCount.length; i++) {
                cowCount[i] = cowList.get(names.get(i));
            }
            Arrays.sort(cowCount);
            int min = cowCount[0];
            boolean same = true;
            for (int i = 0; i < cowCount.length; i++) {
                if (cowCount[i] != min) {
                    min = cowCount[i];
                    same = false;
                    break;
                }
            }
            if (same && names.size() != 1) {
                pw.println("Tie");
                pw.close();
            }
            for (int i = 0; i < cowCount.length; i++) {
                if (cowList.get(names.get(i)) == min) {
                    pw.println(names.get(i));
                    break;
                }
            }

            pw.close();
        }
    }
}
