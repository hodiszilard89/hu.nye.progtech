package hu.nye.progtech.service;

import java.io.File;


public class FileService {

    public void delete(String fileNev) {
        File f = new File(fileNev);
        f.delete();
    }
}
