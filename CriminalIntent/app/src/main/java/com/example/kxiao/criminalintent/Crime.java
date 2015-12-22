package com.example.kxiao.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by kexiao on 12/12/15.
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mResolved;


    public Crime() {
        mId = UUID.randomUUID();
        mTitle = "";
        mDate = new Date();

        mResolved = false;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean isResolved() {
        return mResolved;
    }

    public void setResolved(boolean resolved) {
        mResolved = resolved;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
