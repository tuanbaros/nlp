package app.nlp.features.display.folders;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by tuannt on 28/11/2016.
 */

public interface DisplayFolderView {
    void makeRootFolderDone(File rootFolder);
    void getAllFolderDone(ArrayList<String> folderNames);
}
