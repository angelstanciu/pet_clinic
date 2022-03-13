package repository;

import models.Consult;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

// TODO: De implementat interfata Serializable pentru entitatile noastre.

public class BackupRepository {

    private ConsultRepository consultRepository;

    public BackupRepository(){
        this.consultRepository = new ConsultRepositoryImpl();
    }

    public void backUpConsult(){
        List<Consult> consultList = this.consultRepository.findAll();
        StringBuilder backUpStr = new StringBuilder();
        for (int i = 0; i <consultList.size() ; i++) {
            System.out.println(consultList.get(i));
            backUpStr.append(consultList.get(i)).append(" ");

        }
        try {
            Files.write(Path.of("backupconsult.txt"),backUpStr.toString().getBytes(),StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

