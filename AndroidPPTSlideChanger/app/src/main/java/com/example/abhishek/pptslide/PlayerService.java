package com.example.abhishek.pptslide;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.StrictMode;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PlayerService extends Service {
    private MediaSessionCompat mediaSession;

    @Override
    public void onCreate() {



        super.onCreate();
        mediaSession = new MediaSessionCompat(this, "PlayerService");
        mediaSession.setFlags(MediaSessionCompat.FLAG_HANDLES_MEDIA_BUTTONS |
                MediaSessionCompat.FLAG_HANDLES_TRANSPORT_CONTROLS);
        mediaSession.setPlaybackState(new PlaybackStateCompat.Builder()
                .setState(PlaybackStateCompat.STATE_PLAYING, 0, 0) //you simulate a player which plays something.
                .build());

        //this will only work on Lollipop and up, see https://code.google.com/p/android/issues/detail?id=224134
        VolumeProviderCompat myVolumeProvider =
                new VolumeProviderCompat(VolumeProviderCompat.VOLUME_CONTROL_RELATIVE, /*max volume*/100, /*initial volume level*/50) {
                    @Override
                    public void onAdjustVolume(int direction) {
                /*
                -1 -- volume down
                1 -- volume up
                0 -- volume button released
                 */

                        OkHttpClient client = new OkHttpClient();
                        if(direction == -1)
                        {
                            Request request = new Request.Builder()
                                    .url("http://13.232.144.194/ppt/changecode.php?code=1")
                                    .build();

                            try
                            {

                                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                                StrictMode.setThreadPolicy(policy);


                                Response response = client.newCall(request).execute();
                            }
                            catch(IOException e)
                            {
                                Log.e("MYAPP", "exception", e);
                            }
                        }

                        if(direction == 1)
                        {
                            Request request = new Request.Builder()
                                    .url("http://13.232.144.194/ppt/changecode.php?code=0")
                                    .build();

                            try
                            {

                                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                                StrictMode.setThreadPolicy(policy);


                                Response response = client.newCall(request).execute();
                            }
                            catch(IOException e)
                            {
                                Log.e("MYAPP", "exception", e);
                            }
                        }



                    }
                };

        mediaSession.setPlaybackToRemote(myVolumeProvider);
        mediaSession.setActive(true);
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaSession.release();
    }
}
