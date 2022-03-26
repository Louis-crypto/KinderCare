package com.moringaschool.kindercare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class VaccineListAdapter extends ArrayAdapter<VaccineModel> {
    private Context mcontext;
    int mResource;
    public VaccineListAdapter(@NonNull Context context, int resource, @NonNull List<VaccineModel> objects) {
        super(context, resource, objects);
        mcontext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String vaccineName = getItem(position).getVaccineName();
        String vaccineDescription = getItem(position).getDescription();
        Integer vaccineDoses = getItem(position).getDoses();
        String noOfDoses = vaccineDoses.toString();
        String vaccineAgeLimit = getItem(position).getAgeLimit();
        boolean vaccineAvailability = getItem(position).isAvailable();

        VaccineModel vaccineModel = new VaccineModel(vaccineName, vaccineDescription, vaccineDoses, vaccineAgeLimit, vaccineAvailability);

        LayoutInflater inflater = LayoutInflater.from(mcontext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView displayName = (TextView) convertView.findViewById(R.id.displayName);
        TextView displayDescription = (TextView) convertView.findViewById(R.id.displayDescription);
        TextView displayDoses = (TextView) convertView.findViewById(R.id.displayDoses);
        TextView displayAgeLimit = (TextView) convertView.findViewById(R.id.displayAgeLimit);

        displayName.setText(vaccineName);
        displayDescription.setText(vaccineDescription);
        displayDoses.setText(noOfDoses);
        displayAgeLimit.setText(vaccineAgeLimit);
        return convertView;
    }
}
