package com.alamkanak.weekview.loaders;

import com.alamkanak.weekview.EventRect;

import android.content.Context;

import java.util.List;

/**
 * Created by Tara on 18/12/2015.
 */
public abstract class AsyncWeekViewEventLoader extends BaseLoader<List<EventRect>> {

    protected int mMonth;

    protected int mYear;

    protected final Context mContext;

    public AsyncWeekViewEventLoader(Context context, int month, int year) {
        super(context);
        this.mContext = context;
        this.mMonth = month;
        this.mYear = year;
    }

    public AsyncWeekViewEventLoader(Context context) {
        super(context);
        this.mContext = context;
    }


}
