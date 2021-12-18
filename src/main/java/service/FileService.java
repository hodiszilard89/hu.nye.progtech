package service;

import java.io.File;
import java.io.IOException;

public class FileService {

    public void delete(String fileNev)  {
        File f=new File(fileNev);
        f.delete();
    }
}
