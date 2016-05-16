package com.sgnatiuk.storage.filters;

/**
 * Created by sgnatiuk on 5/16/16.
 */
public abstract class YearFilter implements IFilter {

    private int lowValue;
    private int upValue;

    public int getLowValue() {
        return lowValue;
    }

    public void setLowValue(int lowValue) {
        this.lowValue = lowValue;
    }

    public int getHighValue() {
        return upValue;
    }

    public void setUpValue(int upValue) {
        this.upValue = upValue;
    }
}
