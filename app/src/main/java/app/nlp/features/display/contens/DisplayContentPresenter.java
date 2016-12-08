package app.nlp.features.display.contens;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tuannt on 28/11/2016.
 */

public class DisplayContentPresenter {

    private DisplayContentView mDisplayContentView;

    public DisplayContentPresenter(DisplayContentView aDisplayContentView) {
        mDisplayContentView = aDisplayContentView;
    }

    public void getAllContent(String path) {
        File file = new File(Environment.getExternalStorageDirectory() +
                File.separator + "NLP/" + path);
        ArrayList<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
//                if (!line.equals("")) {
//                    lines.add(line);
//                } else {
//                    if (lines.size() > 1 && !lines.get(lines.size() - 1).equals(""))
//                        lines.add(line);
//                }
                lines.add(line);
            }
            br.close();
        }
        catch (IOException e) {
            //You'll need to add proper error handling here
        }
        mDisplayContentView.getAllContentDone(lines);
    }

}
