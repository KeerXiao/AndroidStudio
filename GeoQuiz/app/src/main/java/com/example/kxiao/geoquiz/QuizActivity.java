package com.example.kxiao.geoquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private static final String TAG = QuizActivity.class.getName();
    public static final String KEY_INDEX = "index";

    private class GoToPreviousQuestionClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            mCurrentQuestionIndex = (mCurrentQuestionIndex - 1 + mQuestionBank.length)
                    % mQuestionBank.length;
            updateQuestion();
        }
    }

    private class GoToNextQuestionClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            mCurrentQuestionIndex = (mCurrentQuestionIndex + 1) % mQuestionBank.length;
            updateQuestion();
        }
    }

    private TextView mQuestionTextView;
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mPrevButton;
    private ImageButton mNextButton;

    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_oceans, Question.Answer.True),
            new Question(R.string.question_mideast, Question.Answer.False),
            new Question(R.string.question_africa, Question.Answer.False),
            new Question(R.string.question_americas, Question.Answer.True),
    };

    private int mCurrentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mCurrentQuestionIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }
        Log.d(TAG, "onCreate() called");
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setOnClickListener(new GoToNextQuestionClickListener());
        updateQuestion();
        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(Question.Answer.True);
            }
        });
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(Question.Answer.False);
            }
        });

        mPrevButton = (ImageButton) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new GoToPreviousQuestionClickListener());

        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new GoToNextQuestionClickListener());
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Saving current index :" + mCurrentQuestionIndex);
        savedInstanceState.putInt(KEY_INDEX, mCurrentQuestionIndex);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    private void checkAnswer(Question.Answer answer) {
        boolean correct = answer == mQuestionBank[mCurrentQuestionIndex].getAnswer();

        int toastResId;
        if (correct) {
            toastResId = R.string.correct_toast;
        } else {
            toastResId = R.string.incorrect_toast;
        }
        Toast.makeText(QuizActivity.this, toastResId, Toast.LENGTH_SHORT)
                .show();
    }

    private void updateQuestion() {
        mQuestionTextView.setText(mQuestionBank[mCurrentQuestionIndex].getTestResId());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
