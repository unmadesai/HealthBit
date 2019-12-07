package com.example.dyuti.healthbit;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Dietplan extends AppCompatActivity {


    Button date;
    Button time;
    TextView tdate;
    TextView ttime;
  TimePicker txt2;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydiet);

        date=(Button)findViewById(R.id.date);
        time=(Button)findViewById(R.id.time);
        final Calendar c=Calendar.getInstance();
        tdate=(TextView)findViewById(R.id.tdate);
        ttime=(TextView)findViewById(R.id.ttime);
         txt2=(TimePicker)findViewById(R.id.timePicker1);
         tdate.setText((CharSequence) txt2);
        date.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        int myear=c.get(Calendar.YEAR);
                                        int mMonth=c.get(Calendar.MONTH);
                                        int mDate=c.get(Calendar.DAY_OF_MONTH);

                                        DatePickerDialog dpd=new DatePickerDialog(Dietplan.this, new DatePickerDialog.OnDateSetListener(){
                                            @Override
                                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                                tdate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "-" + year);

                                            }
                                        }
                                                ,myear,mMonth,mDate);
                                        dpd.show();
                                    }
                                }

        );
        time.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                int mhour=c.get(Calendar.HOUR);
                int Min=c.get(Calendar.MINUTE);
                TimePickerDialog tpd=new TimePickerDialog(Dietplan.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        ttime.setText(hourOfDay+"hrs. "+minute);
                    }
                }, mhour, Min, false);
                tpd.show();
            }
        });
    }

}
