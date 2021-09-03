package com.example.apppppp.ui.gallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apppppp.R;
import com.example.apppppp.ui.home.HomeFragment;

public class Details extends AppCompatActivity {
    TextView listView1, priceView1;
    String list_choice;
    Double price_et;
    Button button, button1;
    View view;
    public final String CHANNEL_ID = "001";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        button =(Button) findViewById(R.id.cahsapp);
        button1 = (Button) findViewById(R.id.paypal);
        listView1 =(TextView)findViewById(R.id.listView);
        priceView1=(TextView)findViewById(R.id.priceView);


        Bundle bundle = getIntent().getExtras();
        list_choice = bundle.getString("choices");
        price_et = bundle.getDouble("price");


        listView1.setText(list_choice);
        priceView1.setText(price_et.toString()+ " ETB");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_cashapp_web(view);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                    NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,"001", NotificationManager.IMPORTANCE_DEFAULT);
                    notificationChannel.setDescription("Order has been placed Successfully");

                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notificationManager.createNotificationChannel(notificationChannel);

                    Notification.Builder builder = new Notification.Builder(Details.this, CHANNEL_ID);
                    builder.setSmallIcon(R.drawable.doordashlogo)
                            .setContentTitle("DoorDash")
                            .setContentText("Order has been placed successfully, be on the lookout for our call!")
                            .setPriority(Notification.PRIORITY_DEFAULT)
//                            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
//                            .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                            .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                    ;
                    builder.setVibrate(new long []{1000, 1000});
                    builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
                    Intent notificationIntent = new Intent(Details.this, HomeFragment.class);
                    notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    NotificationManagerCompat  notificationManagerCompat = NotificationManagerCompat.from(Details.this);
                    notificationManager.notify(001, builder.build());

                }
                else{
open_notif();
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_paypal_web(view);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                    NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,"001", NotificationManager.IMPORTANCE_DEFAULT);
                    notificationChannel.setDescription("Order has been placed Successfully");

                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notificationManager.createNotificationChannel(notificationChannel);

                    Notification.Builder builder = new Notification.Builder(Details.this, CHANNEL_ID);
                    builder.setSmallIcon(R.drawable.doordashlogo)
                            .setContentTitle("DoorDash").setContentText("Order has been placed successfully, be on the lookout for our call!").setPriority(Notification.PRIORITY_MAX);

                    Intent notificationIntent = new Intent(Details.this, HomeFragment.class);
                    notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    NotificationManagerCompat  notificationManagerCompat = NotificationManagerCompat.from(Details.this);
                    notificationManager.notify(001, builder.build());

                }
                else{
                    open_notif();
                }

            }
        });
    }

    public void open_paypal_web(View view) {
        Intent intent = new Intent(this, paypal.class);
        startActivity(intent);
    }

    public void open_cashapp_web(View view) {
        Intent intent = new Intent(this, cashapp.class);
        startActivity(intent);
    }

    public void open_notif(){
        Intent intent = new Intent(this, Notification_View.class);
        startActivity(intent);
    }



}