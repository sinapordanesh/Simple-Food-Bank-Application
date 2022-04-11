package edu.ucalgary.ensf409;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public interface TextFile {
    default public void generateFile(String Order, String output)
    {
        try {
            BufferedWriter wr = new BufferedWriter(new FileWriter(output));
            wr.write(Order);
            wr.close();

        } catch (IOException e) {
            System.out.println("Cannot create output file");
        }
        
    }
}
