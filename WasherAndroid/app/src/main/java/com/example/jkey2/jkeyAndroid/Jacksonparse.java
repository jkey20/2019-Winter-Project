package com.example.jkey2.jkeyAndroid;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jkey2.myapplication.R;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static android.widget.Toast.LENGTH_LONG;

public class Jacksonparse extends AppCompatActivity
{

    TextView timeText;
    String ParsetotalText;

    boolean Loopflag;
    Button timebt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jacksonparse);
        timebt = (Button) findViewById(R.id.timebt);
        timeText = (TextView) findViewById(R.id.timeText);
        final Toast LoopToast = Toast.makeText(this, "자동새로고침 완료", LENGTH_LONG);
        JacksonThread.start();
        Loopflag = true;
        final Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (Loopflag)
                {
                    JacksonThread.start();

                    try
                    {

                        ParsetotalText = JacksonThread.start();
                        timeText.setText(ParsetotalText);
                        //         restTimeText.setText();
                        LoopToast.show();
                        //mHandler.sendEmptyMessage(0);
                    } catch (Exception e)
                    {
                        timeText.setText("Loading Error");
                        break;
                    }
                }

            }
        });
        thread.start();
    }
}