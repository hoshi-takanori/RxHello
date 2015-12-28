package com.example.rxhello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_SUB = 1;

    private Button mPushMeButton;
    private TextView mTextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPushMeButton = (Button)findViewById(R.id.button_push_me);
        mTextResult = (TextView)findViewById(R.id.text_result);

        mPushMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPushMeClicked();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_SUB) {
            onPushMeResult(resultCode, data);
        }
    }

    private void onPushMeClicked() {
        Intent intent = new Intent(this, SubActivity.class);
        startActivityForResult(intent, REQUEST_SUB);
    }

    private void onPushMeResult(int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            String result = data.getStringExtra(SubActivity.BUNDLE_RESULT);
            mTextResult.setText("Result: " + result);
        }
    }
}
