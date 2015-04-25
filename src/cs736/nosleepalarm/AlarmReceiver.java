package cs736.nosleepalarm;

import java.util.GregorianCalendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("Alarm", "Alarm Received");
		scheduleAlarm(context, intent);	
	}
	
	private void scheduleAlarm(Context context, Intent intentAlarm){
		int millis = 900;
		Long time = new GregorianCalendar().getTimeInMillis() + millis;
		AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP, time, PendingIntent.getBroadcast(context, 1, intentAlarm, 0));
		Log.d("Alarm", "Alarm Set!");
	}

}
