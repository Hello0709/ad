package com.example.ad_exp_8;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Button playBtn, pauseBtn, stopBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Initialize views
        playBtn = findViewById(R.id.Playbtn);
        pauseBtn = findViewById(R.id.Pausebtn);
        stopBtn = findViewById(R.id.Stopbtn);
// Set click listeners
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic();
            }
        });
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseMusic();
            }
        });
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMusic();
            }
        });
    }
    private void playMusic() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.sample_file);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopMusic();
                }
            });
        }
        mediaPlayer.start();
        playBtn.setEnabled(false);
        pauseBtn.setEnabled(true);
        stopBtn.setEnabled(true);
    }
    private void pauseMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            playBtn.setEnabled(true);
            pauseBtn.setEnabled(false);
            stopBtn.setEnabled(true);
        }
    }
    private void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            playBtn.setEnabled(true);
            pauseBtn.setEnabled(false);
            stopBtn.setEnabled(false);
        }
    }
}