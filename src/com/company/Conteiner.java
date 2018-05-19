package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@SaveToFile(path = "1.txt")
public class Conteiner{
    private  String msg;

    public Conteiner(String msg) {
        this.msg = msg;
    }

    @Save
    public void saveMsg (String path) throws IOException {

        try (FileWriter fw = new FileWriter(path)) {
            fw.write(msg);
        }
    }

}
