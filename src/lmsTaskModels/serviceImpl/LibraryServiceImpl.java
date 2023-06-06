package lmsTaskModels.serviceImpl;

import lmsTaskModels.DataBase;
import lmsTaskModels.Library;
import lmsTaskModels.service.LibraryService;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {
   private DataBase dataBase;

    public LibraryServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        dataBase.getLibraries().addAll(libraries);
        return dataBase.getLibraries();
    }

    @Override
    public List<Library> saveLibrary(Library library) {
        dataBase.getLibraries().add(library);
        return dataBase.getLibraries();
    }

    @Override
    public List<Library> getAllLibraries() {
        return  dataBase.getLibraries();
    }

    @Override
    public Library getLibraryById(Long id) {
        for (int i = 0; i < dataBase.getLibraries().size(); i++) {
            if (dataBase.getLibraries().get(i).getId().equals(id)){
                return dataBase.getLibraries().get(i);
            }
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        for (int i = 0; i < dataBase.getLibraries().size(); i++) {
            if (dataBase.getLibraries().get(i).getId().equals(id)){
                dataBase.getLibraries().get(i).setName(String.valueOf(library));
                return dataBase.getLibraries().get(i);
            }
        }
        return null;
    }

    @Override
    public Library deleteLibrary(Long id) {
        for (int i = 0; i < dataBase.getLibraries().size(); i++) {
            if (dataBase.getLibraries().get(i).getId().equals(id)) {
                return dataBase.getLibraries().remove(i);
            }

        }  return null;
    }
}
