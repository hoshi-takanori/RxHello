package com.example.rxhello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    public static final String BUNDLE_RESULT = "result";

    private EditText mEditInput;
    private Button mOkButton;
    private Button mCancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        mEditInput = (EditText)findViewById(R.id.edit_input);
        mOkButton = (Button)findViewById(R.id.button_ok);
        mCancelButton = (Button)findViewById(R.id.button_cancel);

        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOkClicked();
            }
        });

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCancelClicked();
            }
        });
    }

    private void onOkClicked() {
        Intent data = new Intent();
        data.putExtra(BUNDLE_RESULT, mEditInput.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }

    private void onCancelClicked() {
        setResult(RESULT_CANCELED);
        finish();
    }
}
