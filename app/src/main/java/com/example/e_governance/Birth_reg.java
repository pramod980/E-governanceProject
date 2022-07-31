package com.example.e_governance;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Birth_reg extends AppCompatActivity {
    private Spinner spinner,spinner1;
    private Button button;
    private FirebaseAuth auth;
    private DatabaseReference Reference;
    private EditText Name,Fullname,Dob,Bplace,Cast,District,Vdc,Ward,Foreign,Gname,Gfullname,Fname,Ffullname,Mname,Mfullname;
    private Spinner Gender,Number;
    private String GenderSelected,NumberSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_reg);
        auth=FirebaseAuth.getInstance();
        Reference=FirebaseDatabase.getInstance().getReference("Birth_Record");

        button=findViewById(R.id.button);
        Name =findViewById(R.id.Name);
        Fullname=findViewById(R.id.Fullname);
        Dob=findViewById(R.id.Dob);
        Bplace=findViewById(R.id.Bplace);
        Gender=findViewById(R.id.Gender);
        Cast=findViewById(R.id.Cast);
        Number=findViewById(R.id.Number);
        District=findViewById(R.id.District);
        Vdc=findViewById(R.id.Vdc);
        Ward=findViewById(R.id.Ward);
        Foreign=findViewById(R.id.Foreign);
        Gname=findViewById(R.id.Gname);
        Gfullname=findViewById(R.id.Gfullname);
        Fname=findViewById(R.id.Fname);
        Ffullname=findViewById(R.id.Ffullname);
        Mname=findViewById(R.id.Mname);
        Mfullname=findViewById(R.id.Mfullname);


        spinner=findViewById(R.id.Gender);
        ArrayAdapter<String> myadapter= new ArrayAdapter<String>(Birth_reg.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.gender));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myadapter);
        Gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GenderSelected=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner1=findViewById(R.id.Number);
        ArrayAdapter<String> Badapter= new ArrayAdapter<String>(Birth_reg.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Born_child));
        Badapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(Badapter);
        Number.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                NumberSelected=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(auth.getCurrentUser()!=null)
              {
                  String name=Name.getText().toString();
                  String fullname=Fullname.getText().toString();
                  String dob=Dob.getText().toString();
                  String bplace=Bplace.getText().toString();
                  String cast=Cast.getText().toString();
                  String district=District.getText().toString();
                  String vdc=Vdc.getText().toString();
                  String ward=Ward.getText().toString();
                  String foreign=Foreign.getText().toString();
                  String gname=Gname.getText().toString();
                  String gfullname=Gfullname.getText().toString();
                  String fname=Fname.getText().toString();
                  String ffullname=Ffullname.getText().toString();
                  String mname=Mname.getText().toString();
                  String mfullname=Mfullname.getText().toString();
                  BirthRecord Br= new BirthRecord(name,fullname,dob,bplace,GenderSelected,cast,NumberSelected,district,vdc,ward,foreign,gname,gfullname,fname,ffullname,mname,mfullname);
                  Reference.child(auth.getCurrentUser().getUid()).setValue(Br).addOnCompleteListener(new OnCompleteListener<Void>() {
                      @Override
                      public void onComplete(@NonNull Task<Void> task) {
                          if(task.isSuccessful())
                          {
                              Toast.makeText(Birth_reg.this, "Data is recorded Successfully", Toast.LENGTH_SHORT).show();
                          }
                          else
                          {
                              Toast.makeText(Birth_reg.this, "Unsuccessful Attempt", Toast.LENGTH_SHORT).show();
                          }
                      }
                  });


              }
                Toast.makeText(Birth_reg.this, "Button is clicked successfully", Toast.LENGTH_SHORT).show();

            }
        });

    }
}