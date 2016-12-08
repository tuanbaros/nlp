package app.nlp.features.display.folders;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by tuannt on 28/11/2016.
 */

public class DisplayFolderPresenter {

    private DisplayFolderView mDisplayFolderView;

    public DisplayFolderPresenter(DisplayFolderView aDisplayFolderView) {
        mDisplayFolderView = aDisplayFolderView;
    }

    public void makeRootFolder() {
        File folder = new File(Environment.getExternalStorageDirectory() +
                File.separator + "NLP");
        if (!folder.exists())
            folder.mkdirs();
        mDisplayFolderView.makeRootFolderDone(folder);
    }

    public void getAllFolder(File rootFolder) {
        ArrayList<String> comicNames = new ArrayList<>();
        File[] files = rootFolder.listFiles();
        for (File inFile : files) {
            if (inFile.isDirectory()) {
                comicNames.add(inFile.getName());
            }
        }
        mDisplayFolderView.getAllFolderDone(comicNames);
    }
}
