package com.bignerdranch.android.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.Date;

public class DatePickerActivity extends SingleFragmentActivity {
    private static final String EXTRA_DATE =
            "com.bignerdranch.android.criminalintent.date";
    public static Intent newIntent(Context packageContext, Date date) {
        Intent intent = new Intent(packageContext, DatePickerActivity.class);
        intent.putExtra(EXTRA_DATE, date);
        return intent;
    }


    @Override
    protected Fragment createFragment() {
        Intent intent = getIntent();
        Date date = (Date) intent.getSerializableExtra(EXTRA_DATE);
        return DatePickerFragment.newInstance(date);
    }
}
