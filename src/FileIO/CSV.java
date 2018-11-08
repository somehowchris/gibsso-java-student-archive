/*
 * Demo f�r mehrdimensionale Arrays und enums
 */
package FileIO;
import java.io.*;
import java.util.ArrayList;

import ChainedList.ChainedList;
import Models.Student;

/**
 *
 * @author Mosimann
 */

public class CSV {

    public static ChainedList read(String filename) throws IOException {

        BufferedReader f1=null;
        String line=null;
        int count=0;
        ChainedList students = new ChainedList();
        try {
            f1  = new BufferedReader( new FileReader(filename));
            f1.readLine();
        } catch ( FileNotFoundException e) {
            System.out.println("CSV Datei nicht gefunden!");
            System.exit(1);
        }

        while ( (line = f1.readLine()) != null ) {
            Student s = null;
            String[] split = line.split(";");
            s = new Student(split[1], split[2], split[0], split[3]);
            if (split.length > 4) s.setKlasse2(split[4]);
            students.add(s);
        }

        return students;
    }
    public static void write(ArrayList<Student> students,String path,String seperator,String header) throws IOException {
        File f = new File(path);
        if(!f.exists()){
            f.createNewFile();
        }else{
            f.delete();
            f.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.append(header);
        for(Student student : students){
            String s = student.getBenutzername()+seperator+student.getName()+seperator+student.getVorname()+seperator+student.getKlasse1();
            if(!student.getKlasse2().equals("")){
                s+=seperator+student.getKlasse2();
            }
            bw.newLine();
            bw.append(s);
        }
        bw.flush();
        bw.close();
        System.err.println(f.getAbsolutePath());
    }
}



