package com.example.rxhello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_SUB = 1;

    @Bind(R.id.text_result)
    protected TextView mTextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_SUB) {
            onPushMeResult(resultCode, data);
        }
    }

    @OnClick(R.id.button_push_me)
    protected void onPushMeClicked() {
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
