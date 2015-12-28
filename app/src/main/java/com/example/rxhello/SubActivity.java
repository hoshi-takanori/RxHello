package com.example.rxhello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SubActivity extends AppCompatActivity {

    public static final String BUNDLE_RESULT = "result";

    @Bind(R.id.edit_input)
    protected EditText mEditInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_ok)
    protected void onOkClicked() {
        Intent data = new Intent();
        data.putExtra(BUNDLE_RESULT, mEditInput.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }

    @OnClick(R.id.button_cancel)
    protected void onCancelClicked() {
        setResult(RESULT_CANCELED);
        finish();
    }
}
