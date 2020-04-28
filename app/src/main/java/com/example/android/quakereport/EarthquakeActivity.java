/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquakes.
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        final EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);
        ListView earthquakeListView = (ListView) findViewById(R.id.list);
        earthquakeListView.setAdapter(adapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Earthquake currentEarthquake = adapter.getItem(position); //the 'adapter' refers to "final EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);" above
                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(currentEarthquake.getUrl()));
                startActivity(implicit);
            }
        });
    }
}
