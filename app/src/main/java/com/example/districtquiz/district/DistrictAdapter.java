package com.example.districtquiz.district;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.districtquiz.R;

import java.util.ArrayList;

public class DistrictAdapter extends BaseAdapter {

    private final Context mContext;
    private final ArrayList<District> districts;

    public DistrictAdapter(Context context, ArrayList<District> districts) {
        this.mContext = context;
        this.districts = districts;
    }

    @Override
    public int getCount() {
        return districts.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public District getItem(int position) {
        return this.districts.get(position);
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

}
