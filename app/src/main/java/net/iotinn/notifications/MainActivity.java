package net.iotinn.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // 1 - Notification Channel
    // 2 - Notification Builder
    // 3 - Notificatin Manager

    // TODO 1
    // the constants for creating notofocation channel
    private static final String CHANNEL_ID = "iotinn";
    private static final String CHANNEL_NAME = "iotinn messaging";
    private static final String CHANNEL_DESC = "iotinn messaging service";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 6 we create a notification channel
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        // TODO 5 we call the notification function
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNotification();
            }
        });
    }

    // TODO 2 this function will display notification on notification bar
    private void displayNotification(){
        // TODO 3 we create notification builder
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_gift_box)
                .setContentTitle("Notificaiton Title")
                .setContentText("This is notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // TODO 4 we create notification manager
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);

        notificationManagerCompat.notify(1,mBuilder.build());


    }
}
