package app.nlp.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.io.File;
import java.util.ArrayList;

import app.nlp.R;
import app.nlp.databinding.ActivityMainBinding;
import app.nlp.features.display.folders.DisplayFolderPresenter;
import app.nlp.features.display.folders.DisplayFolderView;

public class MainActivity extends AppCompatActivity implements DisplayFolderView{

    private ActivityMainBinding mBinding;

    private DisplayFolderPresenter mDisplayFolderPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mDisplayFolderPresenter = new DisplayFolderPresenter(this);
        mDisplayFolderPresenter.makeRootFolder();
    }

    @Override
    public void makeRootFolderDone(File rootFolder) {
        mDisplayFolderPresenter.getAllFolder(rootFolder);
    }

    @Override
    public void getAllFolderDone(final ArrayList<String> folderNames) {
        mBinding.comicLoadProgressBar.setVisibility(View.GONE);
        mBinding.comicListView.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, folderNames));
        mBinding.comicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SectionActivity.class);
                intent.putExtra("comicName", folderNames.get(position));
                startActivity(intent);
            }
        });
    }
}
