package com.paytm;

import java.util.ArrayList;

public interface MovingAverageDeque<T extends Number> {
    /**
     * Add element to the underlying stream of Numbers and updates the current running sum for window of N. N is the
     * size of the window.
     *
     * @param element element of type Number
     */
    void addElement(T element);

    /**
     * Calculates the moving average for window size N and returns the calculated value.
     * if underlying stream is empty or window size is less than zero then this method returns 0.
     *
     * @return moving average
     */
    Double getMovingAverage();

    /**
     * Returns a copy of complete stream.
     *
     * @return list containing all the elements ever inserted into the stream
     */
    public ArrayList<T> getAllElements();
}
