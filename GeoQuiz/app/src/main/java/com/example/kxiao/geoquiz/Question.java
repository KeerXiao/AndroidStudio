package com.example.kxiao.geoquiz;

/**
 * Created by kxiao on 11/7/15.
 */
public class Question {

    public static enum Answer{
        True,
        False,
    }

    private int mTestResId;
    private Answer mAnswer;

    public Question(int testResId, Answer answer) {
        this.mTestResId = testResId;
        this.mAnswer = answer;
    }


    public int getTestResId() {
        return mTestResId;
    }

    public void setTestResId(int testResId) {
        mTestResId = testResId;
    }

    public Answer getAnswer() {
        return mAnswer;
    }

    public void setAnswer(Answer answer) {
        mAnswer = answer;
    }

}
