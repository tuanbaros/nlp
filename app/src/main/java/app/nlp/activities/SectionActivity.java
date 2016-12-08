package app.nlp.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import app.nlp.R;
import app.nlp.adapters.RuleAdapter;
import app.nlp.adapters.SearchAdapter;
import app.nlp.databinding.ActivitySectionBinding;
import app.nlp.features.check.CheckPresenter;
import app.nlp.features.check.CheckView;
import app.nlp.features.display.sections.DisplaySectionPresenter;
import app.nlp.features.display.sections.DisplaySectionView;
import app.nlp.features.search.SearchPresenter;
import app.nlp.models.RuleResult;
import app.nlp.models.SearchResult;

public class SectionActivity extends MyActivity implements
        DisplaySectionView, app.nlp.features.search.SearchView, CheckView {

    //constans
    protected static final int RESULT_SPEECH = 1;

    //binding
    private ActivitySectionBinding mBinding;

    //presenter
    private DisplaySectionPresenter mDisplaySectionPresenter;

    private SearchPresenter mSearchPresenter;

    private CheckPresenter mCheckPresenter;

    //control
    private SearchView mSearchView;

    //data
    private boolean isSearch = false;

    private ArrayList<String> mSections;

    //android
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_section);
        mDisplaySectionPresenter = new DisplaySectionPresenter(this);
        mSearchPresenter = new SearchPresenter(this);
        mCheckPresenter = new CheckPresenter(this);
        mBinding.fab.attachToListView(mBinding.comicListView);
        mBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "vi-VN");
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                } catch (ActivityNotFoundException a) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Thiết bị của bạn không hỗ trợ nhận dạng giọng nói",
                            Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
        setUpActionBar(getIntent().getStringExtra("comicName"));
        getAllSection();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        mSearchView = (SearchView) menu.findItem(R.id.action_search).getActionView();

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String query) {
                if (query != null && !query.equals(" +") && !query.replaceAll("\\W", "").equals("")) {
                    search(query.trim());
                } else {
                    Toast.makeText(getBaseContext(), "Please type key word!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return false;
            case R.id.action_filter:
                mBinding.comicListView.setVisibility(View.GONE);
                mBinding.comicLoadProgressBar.setVisibility(View.VISIBLE);
                if (mSections != null) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            mCheckPresenter.checkAll(getIntent().getStringExtra("comicName"), mSections);
                        }
                    }).start();
                }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (isSearch) {
            showAllSections();
            isSearch = false;
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String s = text.get(0).toLowerCase();
                    Log.i("tim", s);
                    if (s.contains("tìm kiếm")) {
                        mSearchView.setQuery(s.replace("tìm kiếm", ""), true);
                    } else if (s.contains("quay lại")) {
                        onBackPressed();
                    } else if (s.contains("đọc")) {
                        readComic(s.replace("đọc", "").trim());
                    }


                }
                break;
            }

        }
    }

    //add
    private void getAllSection() {
        mBinding.comicListView.setVisibility(View.GONE);
        mBinding.fab.setVisibility(View.GONE);
        mBinding.comicLoadProgressBar.setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                mDisplaySectionPresenter.getAllSection(getIntent().getStringExtra("comicName"));
            }
        }).start();
    }

    private void search(final String query) {
        isSearch = true;
        mBinding.comicListView.setVisibility(View.GONE);
        mBinding.fab.setVisibility(View.GONE);
        mBinding.comicLoadProgressBar.setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                mSearchPresenter.search(getIntent().getStringExtra("comicName"), query, mSections);
            }
        }).start();
    }

    private void readComic(String sectionName) {
        sectionName = sectionName.replace("phẩy", ",").replaceAll(" +", " ");
        for (String s:
             mSections) {
            if (s.toLowerCase().contains(sectionName)) {
                Intent intent = new Intent(SectionActivity.this, ComicActivity.class);
                intent.putExtra("parent", getSupportActionBar().getTitle());
                intent.putExtra("name", s);
                startActivity(intent);
                break;
            }
        }
    }

    private void showAllSections() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mBinding.comicLoadProgressBar.setVisibility(View.GONE);
                mBinding.comicListView.setVisibility(View.VISIBLE);
                mBinding.fab.setVisibility(View.VISIBLE);
                mBinding.comicListView.setAdapter(
                        new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, mSections));
                mBinding.comicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(SectionActivity.this, ComicActivity.class);
                        intent.putExtra("parent", getSupportActionBar().getTitle());
                        intent.putExtra("name", mSections.get(position));
                        startActivity(intent);
                    }
                });
            }
        });
    }

    //display section view
    @Override
    public void getAllFileDone(final ArrayList<String> sections) {
        mSections = sections;
        showAllSections();
    }

    //search view
    @Override
    public void onSearchDone(final ArrayList<SearchResult> results, final String query) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mBinding.comicLoadProgressBar.setVisibility(View.GONE);
                Log.i("size", ""+results.size());
                mBinding.comicListView.setAdapter(new SearchAdapter(getBaseContext(), results, query));
                mBinding.comicListView.setVisibility(View.VISIBLE);
                mBinding.fab.setVisibility(View.VISIBLE);
                mBinding.comicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(SectionActivity.this, ComicActivity.class);
                        intent.putExtra("parent", getSupportActionBar().getTitle());
                        intent.putExtra("name", results.get(position).getSection());
                        intent.putExtra("line", results.get(position).getLine()-2);
                        intent.putExtra("query", query);
                        startActivity(intent);
                    }
                });
            }
        });
    }

    //check view
    @Override
    public void getAllWordInvalidDone(ArrayList<RuleResult> results) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mBinding.comicListView.setVisibility(View.VISIBLE);
                mBinding.comicLoadProgressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void getAllWordInvalidSuccess(final ArrayList<SearchResult> results) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mBinding.comicLoadProgressBar.setVisibility(View.GONE);
                mBinding.comicListView.setAdapter(new RuleAdapter(getBaseContext(), results));
                mBinding.comicListView.setVisibility(View.VISIBLE);
                mBinding.fab.setVisibility(View.VISIBLE);
                mBinding.comicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(SectionActivity.this, ComicActivity.class);
                        intent.putExtra("parent", getSupportActionBar().getTitle());
                        intent.putExtra("name", results.get(position).getSection());
                        intent.putExtra("line", results.get(position).getLine()-2);
                        intent.putExtra("query", results.get(position).getWord());
                        startActivity(intent);
                    }
                });
            }
        });
    }

    @Override
    public void updateWordInvalidDone(final SearchResult result) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                mRuleAdapter.addItem(result);
//                if (mBinding.comicListView != null && mBinding.comicListView.getVisibility() == View.GONE)
//                    mBinding.comicListView.setVisibility(View.VISIBLE);
//            }
//        });
    }
}
