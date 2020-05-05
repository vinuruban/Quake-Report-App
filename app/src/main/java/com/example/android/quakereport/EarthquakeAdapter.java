package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Here we are overriding a method from the ArrayAdapter class!
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView magTextView = (TextView) listItemView.findViewById(R.id.mag_textView);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        magTextView.setText(currentEarthquake.getMagnitude());


        //Below draws the circle and adds colour
        double magAsDouble = Double.parseDouble(currentEarthquake.getMagnitude());
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground(); //THIS IS NEEDED TO DRAW THE CIRCLE
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(magAsDouble);
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        //Splits text into 2 textfield depending on the text
        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView disTextView = (TextView) listItemView.findViewById(R.id.distance_textView);
        TextView locTextView = (TextView) listItemView.findViewById(R.id.location_textView);
        if (currentEarthquake.getDistance() == "") {
            disTextView.setVisibility(View.GONE);
            locTextView.setText(currentEarthquake.getLocation());
        }
        else {
            disTextView.setVisibility(View.VISIBLE);
            // Get the version number from the current AndroidFlavor object and
            // set this text on the number TextView
            disTextView.setText(currentEarthquake.getDistance());
            locTextView.setText(currentEarthquake.getLocation());
        }

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_textView);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        dateTextView.setText(currentEarthquake.getDate());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_textView);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        timeTextView.setText(currentEarthquake.getTime());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude); //remember floor ROUNDS DOWN TO A WHOLE NUMBER
        switch (magnitudeFloor) {
            case 0: //no break since it share the logic of case 1 (0 <= magnitudeColorResourceId < 2)
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2; // (2 <= magnitudeColorResourceId < 3)
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3; // (3 <= magnitudeColorResourceId < 4)
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4; // (4 <= magnitudeColorResourceId < 5)
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5; // (5 <= magnitudeColorResourceId < 6)
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6; // (6 <= magnitudeColorResourceId < 7)
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7; // (7 <= magnitudeColorResourceId < 8)
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8; // (8 <= magnitudeColorResourceId < 9)
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9; // (9 <= magnitudeColorResourceId < 10)
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus; // (magnitudeColorResourceId > 10)
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }


}
