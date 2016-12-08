package app.nlp.features.search;

import java.util.ArrayList;

import app.nlp.models.SearchResult;

/**
 * Created by tuannt on 28/11/2016.
 */

public interface SearchView {
    void onSearchDone(ArrayList<SearchResult> results, String query);
}
