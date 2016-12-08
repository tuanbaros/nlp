package app.nlp.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import app.nlp.R;
import app.nlp.databinding.ItemSearchResultBinding;
import app.nlp.models.SearchResult;
import app.nlp.utils.TextColorUtils;

/**
 * Created by tuannt on 29/11/2016.
 */

public class SearchAdapter extends BaseAdapter {

    private ArrayList<SearchResult> results;

    private LayoutInflater mInflate;

    private String query;

    public SearchAdapter(Context mContext, ArrayList<SearchResult> results, String query) {
        this.results = results;
        this.query = query;
        mInflate = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Object getItem(int position) {
        return results.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflate.inflate(R.layout.item_search_result, null);
            holder.mBinding = DataBindingUtil.bind(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mBinding.titleTextView.setText(results.get(position).getSection());
        holder.mBinding.contentTextView.setText(TextColorUtils.changeTextColor(query, results.get(position).getContent()));
        return convertView;
    }

    private static class ViewHolder {
        private ItemSearchResultBinding mBinding;
    }
}
