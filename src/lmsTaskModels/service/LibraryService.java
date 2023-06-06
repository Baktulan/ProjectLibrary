package lmsTaskModels.service;

import lmsTaskModels.Library;

import java.util.List;

public interface LibraryService {
    List<Library>saveLibrary(List<Library>libraries);
    List<Library>saveLibrary(Library library);
    List<Library>getAllLibraries();

    Library getLibraryById(Long id);

    Library updateLibrary(Long id, Library library);

    Library deleteLibrary(Long id);



}
