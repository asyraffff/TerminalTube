package other;

import java.io.*;

public class JavaIO {
    public static void main(String[] args) {
        try {
             BufferedReader br = new BufferedReader(
                     new FileReader("/Users/amirulasyraf/Documents/output/test1.txt"));
//            BufferedWriter bw = new BufferedWriter(
//                    new FileWriter("/Users/amirulasyraf/Documents/output/test1.txt"));
//            bw.write("meh\n");
//            bw.write("haha\n");
//            bw.write("hihi");
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
