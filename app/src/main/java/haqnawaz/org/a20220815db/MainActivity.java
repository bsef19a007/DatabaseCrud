package haqnawaz.org.a20220815db;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

//    DBHelper myDb;
//    buttonUpdate, buttonDelete,
    Button buttonAdd, buttonViewAll;
    EditText editName, editRollNumber;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switchIsActive;
    ListView listViewStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
//        buttonUpdate = findViewById(R.id.buttonUpdate);
//        buttonDelete = findViewById(R.id.buttonDelete);
        buttonViewAll = findViewById(R.id.buttonViewAll);
        editName = findViewById(R.id.editTextName);
        editRollNumber = findViewById(R.id.editTextRollNumber);
        switchIsActive = findViewById(R.id.switchStudent);
        listViewStudent = findViewById(R.id.listViewStudent);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            StudentModel studentModel;

            @Override
            public void onClick(View v) {
                try {
                    studentModel = new StudentModel(editName.getText().toString(), Integer.parseInt(editRollNumber.getText().toString()), switchIsActive.isChecked());
                    //Toast.makeText(MainActivity.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                dbHelper.addStudent(studentModel);
            }
        });


//        buttonUpdate.setOnClickListener(v -> {
//
//            boolean isUpdate = myDb.updateStudent(editName.getText().toString(),
//                    editRollNumber.getText().toString(), switchIsActive.isChecked());
//            if (isUpdate)
//                Toast.makeText(MainActivity.this, "Data Update", Toast.LENGTH_LONG).show();
//            else
//                Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
//        });
//
//
//        buttonDelete.setOnClickListener(v -> {
//            Integer deletedRows = myDb.deleteStudent(editRollNumber.getText().toString());
//            if(deletedRows > 0)
//                Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
//            else
//                Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
//        });

        buttonViewAll.setOnClickListener(v -> {
            DBHelper dbHelper = new DBHelper(MainActivity.this);
            List<StudentModel> list = dbHelper.getAllStudents();
            ArrayAdapter<StudentModel> arrayAdapter = new ArrayAdapter<>
                    (MainActivity.this, android.R.layout.simple_list_item_1, list);
            listViewStudent.setAdapter(arrayAdapter);

        });

    }
}