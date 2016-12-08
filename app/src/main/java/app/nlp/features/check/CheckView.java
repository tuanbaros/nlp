package app.nlp.features.check;

import java.util.ArrayList;

import app.nlp.models.RuleResult;
import app.nlp.models.SearchResult;

/**
 * Created by tuannt on 29/11/2016.
 */

public interface CheckView {
    void getAllWordInvalidDone(ArrayList<RuleResult> results);

    void getAllWordInvalidSuccess(ArrayList<SearchResult> results);

    void updateWordInvalidDone(SearchResult result);
}
