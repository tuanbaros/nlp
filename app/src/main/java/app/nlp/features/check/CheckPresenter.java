package app.nlp.features.check;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import org.apache.commons.codec.binary.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import app.nlp.models.RuleResult;
import app.nlp.models.SearchResult;

/**
 * Created by tuannt on 29/11/2016.
 */

public class CheckPresenter {

    private CheckView mCheckView;

    public CheckPresenter(CheckView aCheckView) {
        mCheckView = aCheckView;
    }

    public void check(ArrayList<String> contents) {
        ArrayList<RuleResult> results = new ArrayList<>();
        Rules2 rules = new Rules2();
        Rule rule = new Rule();
        for (String line : contents) {
            if (!line.equals("")) {
                String[] array = line.toLowerCase().trim().replaceAll("[-?+;,.!:\\(\\)'*\"\\[\\]«»…，。；？！ ]", " ").split(" ");
                for (String s : array) {
                    String after = s.trim();
                    if (after.length() > 1) {
                        if (!TextUtils.isDigitsOnly(after)) {
                            if ((!after.equals("") && !rule.checkVowelTotal(after))) {
                                RuleResult ruleResult = new RuleResult();
                                ruleResult.setContent(line);
                                ruleResult.setWord(s);
                                results.add(ruleResult);
                                Log.i("timkiem", after);
                                continue;

                            }
                            if (!after.equals("") && !rules.check(after)) {
                                RuleResult ruleResult = new RuleResult();
                                ruleResult.setContent(line);
                                ruleResult.setWord(s);
                                results.add(ruleResult);
                                Log.i("timkiem", after);
//                                        mCheckView.updateWordInvalidDone(ruleResult);
                            }
                        }

                    } else if (array.length == 1) {
                        if (!after.equals("") && !rules.checkInvalid2(after) ) {
                            RuleResult ruleResult = new RuleResult();
                            ruleResult.setContent(line);
                            ruleResult.setWord(s);
                            results.add(ruleResult);
                            Log.i("timkiem", after);
//                                    mCheckView.updateWordInvalidDone(ruleResult);
                        }
                    }

                }
            }
        }
        mCheckView.getAllWordInvalidDone(results);
    }

    public void checkAll(String comicName, ArrayList<String> sections) {
        ArrayList<SearchResult> results = new ArrayList<>();
        File file;
        Rules2 rules = new Rules2();
        Rule rule = new Rule();
        for (String sectioneName : sections) {
            file = new File(Environment.getExternalStorageDirectory() +
                    File.separator + "NLP" + "/" + comicName + "/" + sectioneName);
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                int count = 0;
                while ((line = br.readLine()) != null) {
                    count++;
                    if (!line.equals("")) {
                        String[] array = line.toLowerCase().trim().replaceAll("[-?+;,.!:\\(\\)'*\"\\[\\]«»…，。；？！ ]", " ").split(" ");
                        for (String s : array) {
                            String after = s.trim();
                            if (after.length() > 1) {
                                if (!TextUtils.isDigitsOnly(after)) {
                                    if ((!after.equals("") && !rule.checkVowelTotal(after))) {
                                        SearchResult ruleResult = new SearchResult();
                                        ruleResult.setContent(line);
                                        ruleResult.setWord(s);
                                        ruleResult.setSection(sectioneName);
                                        ruleResult.setLine(count);
                                        results.add(ruleResult);
                                        Log.i("timkiem", after);
                                        continue;

                                    }
                                    if (!after.equals("") && !rules.check(after)) {
                                        SearchResult ruleResult = new SearchResult();
                                        ruleResult.setContent(line);
                                        ruleResult.setWord(s);
                                        ruleResult.setSection(sectioneName);
                                        ruleResult.setLine(count);
                                        results.add(ruleResult);
                                        Log.i("timkiem", after);
                                    }
                                }

                            } else if (array.length == 1) {
                                if (!after.equals("") && !rules.checkInvalid2(after) ) {
                                    SearchResult ruleResult = new SearchResult();
                                    ruleResult.setContent(line);
                                    ruleResult.setWord(s);
                                    ruleResult.setSection(sectioneName);
                                    ruleResult.setLine(count);
                                    results.add(ruleResult);
                                    Log.i("timkiem", after);
                                }
                            }

                        }
                    }
                }
                br.close();
            }
            catch (IOException e) {
                //You'll need to add proper error handling here
            }
        }
        mCheckView.getAllWordInvalidSuccess(results);
    }
}
