package com.alamkanak.weekview.sample;

import com.alamkanak.weekview.EventListBuilder;
import com.alamkanak.weekview.EventRect;
import com.alamkanak.weekview.WeekViewEvent;
import com.alamkanak.weekview.loaders.AsyncWeekViewEventLoader;

import android.content.Context;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Tara on 02/02/2016.
 */
public class SampleLoader extends AsyncWeekViewEventLoader {

    public SampleLoader(Context context, int month, int year) {
        super(context, month, year);
    }

    @Override
    public List<EventRect> loadInBackground() {
        // Populate the week view with some events.
        List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();

        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, mMonth - 1);
        startTime.set(Calendar.YEAR, mYear);
        Calendar endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 1);
        endTime.set(Calendar.MONTH, mMonth - 1);
        WeekViewEvent<String, String> event = new WeekViewEvent<>(1, getEventTitle(startTime), startTime, endTime);
        event.setColor(mContext.getResources().getColor(R.color.event_color_01));
        event.putValueInMap("key", "custom value 1");
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, mMonth-1);
        startTime.set(Calendar.YEAR, mYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 4);
        endTime.set(Calendar.MINUTE, 30);
        endTime.set(Calendar.MONTH, mMonth-1);
        event = new WeekViewEvent<>(10, getEventTitle(startTime), startTime, endTime);
        event.setColor(mContext.getResources().getColor(R.color.event_color_02));
        event.putValueInMap("key", "custom value 2");
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 4);
        startTime.set(Calendar.MINUTE, 20);
        startTime.set(Calendar.MONTH, mMonth-1);
        startTime.set(Calendar.YEAR, mYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 5);
        endTime.set(Calendar.MINUTE, 0);
        event = new WeekViewEvent<>(10, getEventTitle(startTime), startTime, endTime);
        event.setColor(mContext.getResources().getColor(R.color.event_color_03));
        event.putValueInMap("key", "custom value 3");
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 5);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, mMonth-1);
        startTime.set(Calendar.YEAR, mYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 2);
        endTime.set(Calendar.MONTH, mMonth - 1);
        event = new WeekViewEvent<>(2, getEventTitle(startTime), startTime, endTime);
        event.setColor(mContext.getResources().getColor(R.color.event_color_02));
        event.putValueInMap("key", "custom value 4");
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 5);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, mMonth-1);
        startTime.set(Calendar.YEAR, mYear);
        startTime.add(Calendar.DATE, 1);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        endTime.set(Calendar.MONTH, mMonth - 1);
        event = new WeekViewEvent<>(3, getEventTitle(startTime), startTime, endTime);
        event.setColor(mContext.getResources().getColor(R.color.event_color_03));
        event.putValueInMap("key", "custom value 5");
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 15);
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, mMonth-1);
        startTime.set(Calendar.YEAR, mYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent<>(4, getEventTitle(startTime), startTime, endTime);
        event.setColor(mContext.getResources().getColor(R.color.event_color_04));
        event.putValueInMap("key", "custom value 6");
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 1);
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, mMonth-1);
        startTime.set(Calendar.YEAR, mYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent<>(5, getEventTitle(startTime), startTime, endTime);
        event.setColor(mContext.getResources().getColor(R.color.event_color_01));
        event.putValueInMap("key", "custom value 7");
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, startTime.getActualMaximum(Calendar.DAY_OF_MONTH));
        startTime.set(Calendar.HOUR_OF_DAY, 15);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, mMonth-1);
        startTime.set(Calendar.YEAR, mYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent<>(5, getEventTitle(startTime), startTime, endTime);
        event.setColor(mContext.getResources().getColor(R.color.event_color_02));
        event.putValueInMap("key","custom value 8");
        events.add(event);

        /*
            Build the event rects in this background task using the EventListBuilder
         */
        EventListBuilder<String,String> builder = new EventListBuilder<>(events);

        return builder.getEventRects();
    }

    protected String getEventTitle(Calendar time) {
        return String.format("Event of %02d:%02d %s/%d", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), time.get(Calendar.MONTH)+1, time.get(Calendar.DAY_OF_MONTH));
    }
}
