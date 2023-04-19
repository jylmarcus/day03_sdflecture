package sg.edu.nus.iss;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            for (String arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("No arguments");
        }

        String dirPath = args[0];
        String fileName = args[1];
        String dirPathFileName = dirPath + File.separator + fileName;

        // use file object to check if directory exists
        // create directory if not
        // Slide 3
        File newDirectory = new File(dirPath);
        if (newDirectory.exists()) {
            System.out.println("Directory" + dirPath + " already created/exists");
        } else {
            newDirectory.mkdir();
        }

        File newFile = new File(dirPathFileName);

        if (newFile.exists()) {
            System.out.println(dirPathFileName + " already created/exists");
        } else {
            newFile.createNewFile();
        }

        //example 1
        String content = "I will like to go home early to rest and start coding practice again.";
        String content2 = "let's keep on coding coding coding";
        FileWriter fileWriter = new FileWriter(dirPathFileName, true);
        fileWriter.write(content);
        fileWriter.write("\n");
        fileWriter.write(content2);
        fileWriter.flush();
        fileWriter.close();

        //example 2
        String content3 = "Quick brown fox";
        FileWriter fw2 = new FileWriter(dirPathFileName, true);
        BufferedWriter bw = new BufferedWriter(fw2);
        bw.append(content3);
        bw.flush();
        bw.close();
        fw2.close();

        //example 3
        String content4 = "420 blaze it";
        FileOutputStream fos = new FileOutputStream(dirPathFileName, true);
        byte[] byteContent = content4.getBytes();
        fos.write(byteContent);
        fos.flush();
        fos.close();

        //example 4 decorator pattern
        String content5 = "I need more sleep";
        FileOutputStream fos2 = new FileOutputStream(dirPathFileName, true);
        DataOutputStream dos2 = new DataOutputStream(fos2);
        dos2.writeUTF(content5);
        dos2.flush();
        dos2.close();
        fos2.close();

        //reading from file
        File file2 = new File(dirPathFileName);
        FileReader fr = new FileReader(file2);
        int dataRead = fr.read();
        while (dataRead != -1) {
            System.out.print((char)dataRead);
            dataRead = fr.read();
        }
        fr.close();

        //another example - using BufferedReader
        FileReader fr2 = new FileReader(file2);
        BufferedReader br = new BufferedReader(fr2);
        String line = "";
        line = br.readLine();

        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }

        br.close();
        fr2.close();

        //another example - FileInputStream and DataInputStream
        FileInputStream fis = new FileInputStream (file2);
        DataInputStream dis = new DataInputStream(fis);
        int disData = dis.read();

        while(disData != -1) {
            System.out.print((char)disData);
            disData = dis.read();
        }
        dis.close();
        fis.close();
    }

}
