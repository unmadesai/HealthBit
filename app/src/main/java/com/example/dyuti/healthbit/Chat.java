package com.example.dyuti.healthbit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Chat extends AppCompatActivity {

    EditText ed1;
    TextView tv,tv1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        btn = (Button) findViewById(R.id.send);
        tv = (TextView) findViewById(R.id.show);
        tv1=(TextView)findViewById(R.id.show1);
        ed1 = (EditText) findViewById(R.id.ed1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = ed1.getText().toString();
                // tv.setText(data);
                String[][] chatBot = {
                        //standard greetings
                        {"hi", "hello", "hola", "ola", "howdy"},
                        {"hi", "hello", "hey"},
                        //question greetings
                        {"how are you", "how r you", "how r u", "how are u"},
                        {"good", "doing well"},
                        //yes
                        //{"yes"},
                        //{"no","NO","NO!!!!!!!"},
                        //who are you
                        {"who are you?", "who r u", "who are u"},
                        {"hi, i'm eliza", "hey, i'm eliza"},


                        //symptoms of heart attack
                        {"what happens during a heart attack", "how do i know if i have a heart attack", "heart attack symptoms",
                                "what are the symptoms of a heart attack", "heart attack", "symptoms of heart disease", "symptoms of heart attack"},
                        {"Symptoms of heart attack/heart disease are:\nChest Pain\nShortness of breath\nDizziness\nFatigue\nCold sweating\nNausea"},

                        //symptoms of low bp
                        {"what are symptoms of low bp", "symptoms of low blood pressure", "low blood pressure", "symptoms of low bp"},
                        {"Symptoms of low blood pressure are:\nDizziness\nFainting\nBlurred vision\nFatigue\nDepression\nThirst"},

                        //symptoms of diabetes
                        {"what happens during a diabetes", "how do i know if i have a diabetes", "diabetes symptoms",
                                "what are the symptoms of a diabetes", "diabetes", "symptoms of diabetes"},
                        {"Symptoms of diabetes are:\nFrequent Urination\nHunger\nBlurred vision\nFatigue\nIncreased Thirst"},

                        //symptoms of malaria
                        {"what happens during a malaria", "how do i know if i have a malaria", "malaria symptoms",
                                "what are the symptoms of a malaria", "malaria", "symptoms of malaria"},
                        {"Symptoms of malaria are:\nChills\nFever\nShivering\nFatigue\nHeadache\nNausea"},

                        //appointment
                        {"appointment", "book appointment","get appointment"},
                        {"Please contact 2938282716"},

                        //emergency
                        {"help","help emergency","emergency contact"},
                        {"Police: 100\nAmbulance: 108\n"},




                        //default
                        {"hello, how may i help you", "i didn't understand that", "i beg your pardon?", "can i help you?",
                                "(eliza is responding to your request)"},
                };

                data = data.trim();


                while (
                        data.charAt(data.length() - 1) == '!' ||
                                data.charAt(data.length() - 1) == '.' ||
                                data.charAt(data.length() - 1) == '?'
                        ) {
                    data = data.substring(0, data.length() - 1);
                }
                data = data.trim();
                byte response = 0;
			/*
			0:we're searching through chatBot[][] for matches
			1:we didn't find anything
			2:we did find something
			*/
                //-----check for matches----
                int j = 0;//which group we're checking
                while (response == 0) {
                    if (inArray(data.toLowerCase(), chatBot[j * 2])) {
                        response = 2;
                        int r = (int) Math.floor(Math.random() * chatBot[(j * 2) + 1].length);
                        tv.setText(chatBot[(j * 2) + 1][r]);
                    }
                    j++;
                    if (j * 2 == chatBot.length - 1 && response == 0) {
                        response = 1;
                    }
                }

                //-----default--------------
                if (response == 1) {
                    int r = (int) Math.floor(Math.random() * chatBot[chatBot.length - 1].length);
                    tv.setText(chatBot[chatBot.length - 1][r]);
                }
            }

            private boolean inArray(String s, String[] strings) {
                int flag=0;
                for (int i = 0; i < strings.length; i++) {
                    if (s.equals(strings[i])){
                        flag=1;
                        break;}
                }
                if(flag==1)
                    return true;
                else
                    return false;

            }
        });
    }
}
