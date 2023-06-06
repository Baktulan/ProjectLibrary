package lmsTaskModels.serviceImpl;

import lmsTaskModels.DataBase;
import lmsTaskModels.Library;
import lmsTaskModels.Reader;
import lmsTaskModels.service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private DataBase dataBase;

    public ReaderServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void saveReader(Reader reader) {
        dataBase.getReaders().add(reader);
        System.out.println(dataBase.getReaders());

    }

    @Override
    public List<Reader> getAllReaders() {
        return dataBase.getReaders();
    }

    @Override
    public Reader getReaderById(Long id) {
        for (int i = 0; i < dataBase.getReaders().size(); i++) {
            if (dataBase.getReaders().get(i).getId().equals(id)) {
                return dataBase.getReaders().get(i);
            } else {
                System.out.println("Reader not found");
            }
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (int i = 0; i < dataBase.getReaders().size(); i++) {
            if (dataBase.getReaders().get(i).getId().equals(id)) {
                dataBase.getReaders().get(i).setFullName(reader.getFullName());
                dataBase.getReaders().get(i).setEmail(reader.getEmail());
                dataBase.getReaders().get(i).setGender(reader.getGender());
                dataBase.getReaders().get(i).setPhoneNumber(reader.getPhoneNumber());
            }
        }
        return reader;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
//        for (int i = 0; i < dataBase.getReaders().size(); i++) {
//            if (dataBase.getReaders().get(i).getId().equals(readerId)){
//                for (int j = 0; j < dataBase.getLibraries().size(); j++) {
//                    if (dataBase.getLibraries().get(j).getId().equals(libraryId)){
//                        dataBase.getLibraries().get(j).getReaders().add(getReaderById(readerId));
//                    }
//                }
        Reader reader= getReaderById(readerId);
        for (int i = 0; i < dataBase.getLibraries().size(); i++) {
            if (dataBase.getLibraries().get(i).getId().equals(libraryId)){
               dataBase.getLibraries().get(i).getReaders().add(reader);
                System.out.println(dataBase.getLibraries());
            }
        }
        }
        }




