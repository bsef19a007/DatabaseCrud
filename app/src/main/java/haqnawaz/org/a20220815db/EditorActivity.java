package haqnawaz.org.a20220815db;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class EditorActivity extends AppCompatActivity {

    EditText studentName;
    EditText studentRollNumber;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switchIsActive;
    long id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edidor);
        id = getIntent().getExtras().getLong("id");
        String name = getIntent().getExtras().getString("name");
        String rollNo = getIntent().getExtras().getString("rollNo");
        studentName = findViewById(R.id.studentName);
        studentRollNumber = findViewById(R.id.rollNumber);
        switchIsActive = findViewById(R.id.switchStudent);
        studentName.setText(name);
        studentRollNumber.setText(rollNo);
        switchIsActive.isChecked();
    }

    public void editStudentDetails(View view){
        String stuName = studentName.getText().toString();
        String rollNumber = studentRollNumber.getText().toString();
        boolean switchStudent = switchIsActive.isChecked();
        MainActivity.databaseAdapter.updateStudentNew(id, stuName, rollNumber, switchStudent);
        startActivity(new Intent(EditorActivity.this, MainActivity.class));
        finish();
    }

    public void deleteContact(View view) {
        MainActivity.databaseAdapter.deleteStudentNew(id);
        startActivity(new Intent(EditorActivity.this, MainActivity.class));
        finish();
    }
}