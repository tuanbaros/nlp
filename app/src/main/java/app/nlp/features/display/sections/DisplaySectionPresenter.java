package app.nlp.features.display.sections;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tuannt on 28/11/2016.
 */

public class DisplaySectionPresenter {

    private DisplaySectionView mDisplaySectionView;

    public DisplaySectionPresenter(DisplaySectionView aDisplaySectionView) {
        mDisplaySectionView = aDisplaySectionView;
    }

    public void getAllSection(String comicName) {
        ArrayList<String> comicNames = new ArrayList<>();
        File folder = new File(Environment.getExternalStorageDirectory() +
                File.separator + "NLP/" + comicName);
        File[] files = folder.listFiles();
        for (File inFile : files) {
            if (inFile.isFile()) {
                comicNames.add(inFile.getName());
            }
        }
        Collections.sort(comicNames, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                Matcher matcher1 = Pattern.compile("\\d+").matcher(s1);
                matcher1.find();
                String sectionString1 = matcher1.group();
                Matcher matcher2 = Pattern.compile("\\d+").matcher(s2);
                matcher2.find();
                String sectionString2 = matcher2.group();
                if ("".equals(sectionString1) || "".equals(sectionString2)) {
                    return sectionString1.compareTo(sectionString2);
                } else {
                    Integer sectionInt1 = Integer.valueOf(sectionString1);
                    Integer sectionInt2 = Integer.valueOf(sectionString2);
                    return sectionInt1.compareTo(sectionInt2);
                }
            }
        });
        mDisplaySectionView.getAllFileDone(comicNames);
    }

}
