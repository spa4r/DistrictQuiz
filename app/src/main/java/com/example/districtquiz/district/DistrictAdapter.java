package com.example.districtquiz.district;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.districtquiz.R;

import java.util.ArrayList;

public class DistrictAdapter extends BaseAdapter implements Filterable  {

    private final Context mContext;
    private final ArrayList<District> districts;
    private ArrayList<District> districtsFiltered;

    public DistrictAdapter(Context context, ArrayList<District> districts) {
        this.mContext = context;
        this.districts = districts;
        this.districtsFiltered = districts;
    }

    @Override
    public int getCount() {
        return districtsFiltered.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public District getItem(int position) {
        return this.districtsFiltered.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final District district = this.getItem(position);

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.activity_district_adapter_display_all, null);
        }

        final ImageView imageView = convertView.findViewById(R.id.imageview_district_image);
        imageView.setImageResource(district.getImageResource());

        final TextView nameTextView = convertView.findViewById(R.id.textview_district_name);
        nameTextView.setText(district.getName());

        return convertView;

    }

    public boolean districtInArrayList(String name) {
        for(District district : this.districts) {
            if(district.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Filter getFilter() {

        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                FilterResults results = new FilterResults();

                if(charSequence == null || charSequence.length() == 0) {
                    results.values = districts;
                    results.count = districts.size();
                }
                else {

                    ArrayList<District> filterResultsData = new ArrayList<>();

                    for(District data : districts) {
                        //In this loop, you'll filter through originalData and compare each item to charSequence.
                        //If you find a match, add it to your new ArrayList
                        //I'm not sure how you're going to do comparison, so you'll need to fill out this conditional
                        if(data.getName().equals(charSequence)) {
                            filterResultsData.add(data);
                        }
                    }

                    results.values = filterResultsData;
                    results.count = filterResultsData.size();
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                districtsFiltered = (ArrayList<District>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

}
