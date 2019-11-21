package vn.poly.toanthptqg.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

import vn.poly.toanthptqg.R;

public class YearSpinnerAdapter implements SpinnerAdapter {
    private Context context;
    private List<String> listYear;

    public YearSpinnerAdapter(Context context, List<String> listYear) {
        this.context = context;
        this.listYear = listYear;
    }

    @Override
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.spinner_year,viewGroup,false);
        TextView tv_year_spinner=view.findViewById(R.id.tv_year_spinner);
        tv_year_spinner.setText(listYear.get(i));

        return view;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return listYear.size();
    }

    @Override
    public String getItem(int i) {
        return listYear.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.spinner_year,viewGroup,false);
        TextView tv_year_spinner=view.findViewById(R.id.tv_year_spinner);
        tv_year_spinner.setText(listYear.get(i));

        return view;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
