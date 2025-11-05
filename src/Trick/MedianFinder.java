package Trick;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.ceil;

class MedianFinder {

    int size;
    List<Integer> list = new ArrayList<>();

    public MedianFinder() {
        this.size = 0;
        this.list = new ArrayList<>();
    }

    public void addNum(int num) {
        size ++;
        list.add(num);
    }

    public double findMedian() {
        if (size % 2 == 0) {
            double median = (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
            return Math.round(median * 10) / 10.0; // 保留一位小数
        } else {
            return Math.round(list.get(size / 2) * 10) / 10.0; // 保留一位小数
        }
    }
}