package com.example.dyuti.healthbit;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Docbot extends Activity {
    AutoCompleteTextView autoCompleteTextView;
    EditText e1, e3, e4, e5;
    EditText e2;
    Button b;
    Spinner s;
    //CheckBox cb1;
    ImageView img;
    // CheckBox cb2,cb3;
    RadioButton rb1, rb2;
    RadioGroup rg, rg2;
    Button date;
    Button time;
    TextView tdate;
    TextView ttime;
    //String hobbies="";
    String[] arr = {"MUMBAI", "CHENNAI", "BANGLORE", "JAIPUR", "NEW DELHI", "SURAT"};
    private int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docbot);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.city);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, arr);
        autoCompleteTextView.setAdapter(adapter);

        getUiComponents();
        setUiComponents();


    }

    public void getUiComponents() {
        e1 = (EditText) findViewById(R.id.fName);
        e2 = (EditText) findViewById(R.id.lName);
        e3 = (EditText) findViewById(R.id.con);
        e4 = (EditText) findViewById(R.id.age);
        e5 = (EditText) findViewById(R.id.add);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.city);
        b = (Button) findViewById(R.id.sub);
        rg = (RadioGroup) findViewById(R.id.radioGroup1);
        rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        // cb1=(CheckBox)findViewById(R.id.checkbox1);
        // cb2=(CheckBox)findViewById(R.id.checkbox2);
        // cb3=(CheckBox)findViewById(R.id.checkbox3);
        img = (ImageView) findViewById(R.id.img);
        s = (Spinner) findViewById(R.id.state);

        date=(Button)findViewById(R.id.date);

        time=(Button)findViewById(R.id.time);

        final Calendar c = Calendar.getInstance();
        tdate=(TextView)findViewById(R.id.tdate);

        ttime=(TextView)findViewById(R.id.ttime);


    }

    public void setUiComponents() {
        try {
            date.setOnClickListener(new View.OnClickListener()

                                    {
                                        @Override
                                        public void onClick(View v) {
                                            int myear = c.get(Calendar.YEAR);
                                            int mMonth = c.get(Calendar.MONTH);
                                            int mDate = c.get(Calendar.DAY_OF_MONTH);

                                            DatePickerDialog dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                                                @Override
                                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                                    tdate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "-" + year);

                                                }
                                            }
                                                    , myear, mMonth, mDate);
                                            dpd.show();
                                        }
                                    }

            );

            time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int mhour = c.get(Calendar.HOUR);
                    int Min = c.get(Calendar.MINUTE);
                    TimePickerDialog tpd = new TimePickerDialog(Docbot.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            ttime.setText(hourOfDay + "hrs. " + minute);
                        }
                    }, mhour, Min, false);
                    tpd.show();
                }
            });
        }catch(Exception e){

        }

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String log;
                    int selected = rg.getCheckedRadioButtonId();
                    rb1 = (RadioButton) findViewById(selected);
                    int select = rg2.getCheckedRadioButtonId();
                    rb2 = (RadioButton) findViewById(select);
                    Intent i = new Intent(Docbot.this, Logo.class);
                    i.putExtra("fName", e1.getText().toString());
                    i.putExtra("lName", e2.getText().toString());
                    i.putExtra("con", e3.getText().toString());
                    i.putExtra("age", e4.getText().toString());
                    i.putExtra("add", e5.getText().toString());
                    i.putExtra("autoCompleteTextView1", autoCompleteTextView.getText().toString());

                    i.putExtra("gender", rb1.getText().toString());
                    i.putExtra("occupation", rb2.getText().toString());
                    int flag = 0;
                    //validation
                    if (e1.getText().toString().length() == 0) {
                        e1.setError("Required");
                        flag = 1;
                    } else if (e2.getText().toString().length() == 0) {
                        e2.setError("Required");
                        flag = 1;
                    }
                    if (e3.getText().toString().length() < 10) {
                        e3.setError("Required");
                        flag = 1;
                    }
                    if (e4.getText().toString().length() == 0) {
                        e4.setError("Required");
                        flag = 1;
                    }
                    if (e5.getText().toString().length() == 0) {
                        e5.setError("Required");
                        flag = 1;
                    }
                    if (autoCompleteTextView.getText().toString().length() == 0) {
                        autoCompleteTextView.setError("Required");
                        flag = 1;
                    }
                    if (flag == 1)
                        Toast.makeText(Docbot.this, "Please fill all the details", Toast.LENGTH_LONG).show();
                    else {
                        Toast.makeText(Docbot.this, "Succesfully done", Toast.LENGTH_SHORT).show();
                    }

                }


            });
        } catch (Exception e) {
            Toast.makeText(this, "All fields should be filled", Toast.LENGTH_LONG).show();
        }
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent();
// Show only images, no videos or anything else
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
// Always show the chooser (if there are multiple options available)

                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);

            }
        });


        List<String> categories = new ArrayList<String>();
        categories.add("Maharastra");
        categories.add("Andra pradesh");
        categories.add("TamilNadu");
        categories.add("Rajasthan");
        categories.add("Gujurat");
        categories.add("Delhi");
        categories.add("Karnataka");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        s.setAdapter(dataAdapter);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) findViewById(R.id.img);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




}

