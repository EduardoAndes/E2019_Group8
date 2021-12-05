package com.example.mainactivity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.v4.app.NotificationCompat;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNotify = (Button)findViewById(R.id.btnShow);
        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder mBuilder
                        = new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.ic_notification_foreground)
                        .setContentTitle("Tutlane Send New Message").setContentText("Hi, Welcome to tutlane tutorial site");
// Set the intent to fire when the user taps on notification.
    Intent resultIntent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, resultIntent, 0);
                mBuilder.setContentIntent(pendingIntent);
// Sets an ID for the notification
                int mNotificationId = 001;
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// It will display the notification in notification bar
                notificationManager.notify(mNotificationId,mBuilder.build());
            }
        });
    }
}