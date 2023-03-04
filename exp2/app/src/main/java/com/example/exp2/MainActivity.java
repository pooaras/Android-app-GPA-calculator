package com.example.exp2;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Spinner e1,e2,e3,e4,e5,e6,e7,e8,e9,e10;
    int ip=0,ai=0,mc=0,cd=0,ds=0,ele=0,iplab=0,madlab=0,mini=0,pc=0;
    float gpa=0;
    Button bt;
    Spinner s;
    //Data for populating in Spinner
    String [] dept_array={"O","A+","A","B+","B","RW"};
    String name,reg,dept;
    int toc=0;
    public static int grade(String ch){
        int x=0;
        if (ch.equals("o")||ch.equals("O"))
            x= 10;
        else if(ch.equals("a+")||ch.equals("A+"))
            x= 9;
        else if(ch.equals("a")||ch.equals("A"))
            x= 8;
        else if(ch.equals("b+")||ch.equals("B+"))
            x= 7;
        else if(ch.equals("b")||ch.equals("B"))
            x= 6;
        else if(ch.equals("ra")||ch.equals("RA"))
            x= 0;
        else System.out.println("enter a valid grade!!!...");
        return x;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1= (Spinner) findViewById(R.id.ip);
        e2= (Spinner) findViewById(R.id.ai);
        e3= (Spinner) findViewById(R.id.mc);
        e4= (Spinner) findViewById(R.id.cd);
        e5= (Spinner) findViewById(R.id.ds);
        e6= (Spinner) findViewById(R.id.ele);
        e7= (Spinner) findViewById(R.id.ipl);
        e8= (Spinner) findViewById(R.id.madlab);
        e9= (Spinner) findViewById(R.id.mini);
        e10= (Spinner) findViewById(R.id.pc);

        bt= (Button) findViewById(R.id.button);
        //Creating Adapter for Spinner for adapting the data from array to Spinner
        ArrayAdapter adapter= new
                ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item,dept_array);
        //s.setAdapter(adapter);
        e1.setAdapter(adapter);
        e2.setAdapter(adapter);
        e3.setAdapter(adapter);
        e4.setAdapter(adapter);
        e5.setAdapter(adapter);
        e6.setAdapter(adapter);
        e7.setAdapter(adapter);
        e8.setAdapter(adapter);
        e9.setAdapter(adapter);
        e10.setAdapter(adapter);

        //Creating Listener for Button
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Getting the Values from Views(Edittext & Spinner)
//                name=e1.getText().toString();
//                reg=e2.getText().toString();
//                dept=s.getSelectedItem().toString();
                //Intent For Navigating to Second Activity
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                //For Passing the Values to Second Activity

                ip=grade(e1.getSelectedItem().toString());
                ai=grade(e2.getSelectedItem().toString());
                mc=grade(e3.getSelectedItem().toString());
                cd=grade(e4.getSelectedItem().toString());
                ds=grade(e5.getSelectedItem().toString());
                ele=grade(e6.getSelectedItem().toString());
                iplab=grade(e7.getSelectedItem().toString());
                madlab=grade(e8.getSelectedItem().toString());
                mini=grade(e9.getSelectedItem().toString());
                pc=grade(e10.getSelectedItem().toString());

                gpa=(float)((ip*3)+(ai*3)+(mc*3)+(cd*4)+(ds*3)+(ele*3)+(iplab*2)+(madlab*2)+(mini*1)+(pc*1))/25;

                String gp1=String.valueOf(gpa);
                i.putExtra("name_key","your gpa in semester 6");
                i.putExtra("reg_key",gp1);
                i.putExtra("dept_key", " ");
                startActivity(i);
                //dept=s.getSelectedItem().toString();
            }
        });
    }
}
