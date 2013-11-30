package com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.impl;

import java.util.ArrayList;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.healthcaresolutions.norgine.moviprepcolonoprep.R;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.UserNotification;
import com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.NotificationService;

public class NotificationServiceImpl implements NotificationService{

	private Context context;
	
	public NotificationServiceImpl(Context context)
	{
		this.context = context;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void notifyUser(UserNotification n) {	
			// NotificationManager vom System holen:
			NotificationManager mNotManager;
			mNotManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
	        
	        Notification mNotification;
	        mNotification = new Notification(
	               R.drawable.moviprep_5,              
	               n.getTitle(),                         // überschrift
	               n.getTime()      ); // uhrzeit wann die benachrichtigung gezeigt werden soll

	        // der ausführliche text
	        String MyNotifyTitle = n.getTitle();
	        String MyNotifiyText  = n.getDescribtion();
	        Intent MyIntent = new Intent( context.getApplicationContext(), n.getClassLink() );
	        MyIntent.putExtra("extendedTitle", MyNotifyTitle);
	        MyIntent.putExtra("extendedText" , MyNotifiyText);
	        PendingIntent StartIntent = PendingIntent.getActivity(  context.getApplicationContext(),
	                                                  0,
	                                                  MyIntent,
	                                                  0);

	        /* Set notification message */
	        mNotification.setLatestEventInfo(   context.getApplicationContext(),
	                                   MyNotifyTitle,
	                                   MyNotifiyText,
	                                   StartIntent);

	        mNotification.ledOnMS  = 200;    //Set led blink (Off in ms)
	        mNotification.ledOffMS = 200;    //Set led blink (Off in ms)
	        
	     
	        /* Sent Notification to notification bar */
	        mNotManager.notify(0, mNotification ); 
		}


	@Override
	public boolean addNotification(UserNotification n) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateNotification(UserNotification n) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<UserNotification> getAllNotifications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserNotification> getAllOpenNotifications() {
		// TODO Auto-generated method stub
		return null;
	}

}
