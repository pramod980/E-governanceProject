package com.example.e_governance;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Marriage_reg extends AppCompatActivity {
    private Button button;
    private EditText Mtype,Mdate,Mdistrict,Mvdc,Mward,Bname,Bfullname,Bdob,Bdistrict,Bvdc,Bward,GName,GFULLname,Gdob,Gdistrict,Gvdc,Gward;
    private FirebaseAuth auth;
    private DatabaseReference Reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marriage_reg);

        auth=FirebaseAuth.getInstance();
        Reference= FirebaseDatabase.getInstance().getReference("Birth_Record");


        button=findViewById(R.id.button);
        Mtype=findViewById(R.id.Mtype);
        Mdate=findViewById(R.id.Mdate);
        Mdistrict=findViewById(R.id.Mdistrict);
        Mvdc=findViewById(R.id.Mvdc);
        Mward=findViewById(R.id.Mward);
        Bname=findViewById(R.id.Bname);
        Bfullname=findViewById(R.id.Bfullname);
        Bdob=findViewById(R.id.Bdob);
        Bdistrict=findViewById(R.id.Bdistrict);
        Bvdc=findViewById(R.id.Bvdc);
        Bward=findViewById(R.id.Bward);
        GName=findViewById(R.id.GName);
        GFULLname=findViewById(R.id.GFULLname);
        Gdob=findViewById(R.id.Gdob);
        Gdistrict=findViewById(R.id.Gdistrict);
        Gvdc=findViewById(R.id.Gvdc);
        Gward=findViewById(R.id.Gward);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(auth.getCurrentUser()!=null)
                {
                    String mtype=Mtype.getText().toString();
                    String mdate=Mdate.getText().toString();
                    String mdistrict=Mdistrict.getText().toString();
                    String mvdc=Mvdc.getText().toString();
                    String mward=Mward.getText().toString();
                    String bname=Bname.getText().toString();
                    String bfullname=Bfullname.getText().toString();
                    String bdob=Bdob.getText().toString();
                    String bdistrict=Bdistrict.getText().toString();
                    String bvdc=Bvdc.getText().toString();
                    String bward=Bward.getText().toString();
                    String gname=GName.getText().toString();
                    String gfullname=GFULLname.getText().toString();
                    String gdob=Gdob.getText().toString();
                    String gdistrict=Gdistrict.getText().toString();
                    String gvdc=Gvdc.getText().toString();
                    String gward=Gward.getText().toString();
                    MarriageRegistration MR=new MarriageRegistration(mtype,mdate,mdistrict,mvdc,mward,bname,bfullname,bdob,bdistrict,bvdc,bward,gname,gfullname,gdob,gdistrict,gvdc,gward);
                    Reference.child(auth.getCurrentUser().getUid()).setValue(MR).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(Marriage_reg.this, "Data recorded successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(Marriage_reg.this, "Data is not recorded", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                }
                Toast.makeText(Marriage_reg.this, "Clicked Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}