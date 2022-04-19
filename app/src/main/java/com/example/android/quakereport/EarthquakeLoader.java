package com.example.android.quakereport;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;


import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private final String mUrl;

    public EarthquakeLoader(@NonNull Context context, @NonNull String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        // To trigger loadInBackground() to execute
        forceLoad();
    }

    @Nullable
    @Override
    public List<Earthquake> loadInBackground() {
        if(mUrl == null)
            return null;

        return QueryUtils.fetchEarthquakeData(mUrl);
    }
}
