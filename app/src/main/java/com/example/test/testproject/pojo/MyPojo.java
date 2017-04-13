package com.example.test.testproject.pojo;

/**
 * Created by Lenovo on 13-04-2017.
 */

public class MyPojo {

    String mName,mAge,mGrade;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAge() {
        return mAge;
    }

    public void setmAge(String mAge) {
        this.mAge = mAge;
    }

    public String getmGrade() {
        return mGrade;
    }

    public void setmGrade(String mGrade) {
        this.mGrade = mGrade;
    }

    @Override
    public String toString() {
        return "MyPojo{" +
                "mName='" + mName + '\'' +
                ", mAge='" + mAge + '\'' +
                ", mGrade='" + mGrade + '\'' +
                '}';
    }
}
