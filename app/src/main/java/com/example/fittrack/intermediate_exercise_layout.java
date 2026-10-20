package com.example.fittrack;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class intermediate_exercise_layout extends AppCompatActivity {

    private VideoView videoView;
    private TextView workoutNameTextView;
    private TextView workoutCountTextView;
    private TextView timerTextView;
    //   private TextView timemode_display;
    private Button startPauseButton;
    private Button resetButton;
    private CountDownTimer workoutTimer;
    private boolean isWorkoutTime = true;
    private int workoutCount = 0;
    private int totalWorkouts = 10; // Replace with the total number of workouts
    private long workoutTimeMillis = 30000; // 30 seconds in milliseconds
    private long breakTimeMillis = 10000; // 10 seconds in milliseconds
    private int breakcount = 0;
    private int workoutstagecount ;
    private String[] workoutnames = {"High stepping","Jumping jacks ","Pushup","Leg raise","Lunges","Abductor stretch","Mountain climber","Side leg raise","Sleep cycling","Leg raise"};
    private String[] workoutcount = {"5","10","16","18","10","8","10","8","6","7"};
    private MediaPlayer mediaPlayer;
    private TextView difficulty_heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intermediate_exercise_layout);

        videoView = findViewById(R.id.videoView);
        workoutNameTextView = findViewById(R.id.workoutNameTextView);
        workoutCountTextView = findViewById(R.id.workoutCountTextView);
        timerTextView = findViewById(R.id.timerTextView);
        startPauseButton = findViewById(R.id.startPauseButton);
        resetButton = findViewById(R.id.resetButton);
        difficulty_heading = findViewById(R.id.difficulty_heading);
        //timemode_display = findViewById(R.id.timemode_display);

        Intent intent1 = getIntent();
        short selectedDifficulty = intent1.getShortExtra("Selected button", (short) 0);


        if (selectedDifficulty == 1){
            String difficulty = "Beginner level";
            difficulty_heading.setText(difficulty);
        }else if (selectedDifficulty == 2){
            String difficulty = "Intermediate level";
            difficulty_heading.setText(difficulty);
        }else if (selectedDifficulty == 3){
            String difficulty = "Advance level";
            difficulty_heading.setText(difficulty);
        }

        videoView.setVisibility(View.INVISIBLE);
        workoutNameTextView.setVisibility(View.INVISIBLE);
        mediaPlayer = mediaPlayer.create(this,R.raw.pushup_sound);

        startPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.setVisibility(View.VISIBLE);
                workoutNameTextView.setVisibility(View.VISIBLE);
                workoutstagecount=0;
                if (workoutTimer == null) {
                    startWorkout();
                } else {
                    pauseWorkout();
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetWorkout();
            }
        });

        playVideo(R.raw.pushup_og); // Replace with the resource ID of the first workout video
    }



    private void startWorkout() {
        if (isWorkoutTime) {
            startWorkoutTimer();
        } else {
            startBreakTimer();
            workoutNameTextView.setText("Break time");
        }
        startPauseButton.setText("Pause");
    }

    private void startWorkoutTimer() {
        workoutCountTextView.setVisibility(View.VISIBLE);
        if (workoutstagecount == 0){
            workoutNameTextView.setText(workoutnames[workoutstagecount]);
            workoutCountTextView.setText(workoutcount[workoutstagecount]);
        }
        else if (workoutstagecount>0 && workoutstagecount<10){
            workoutNameTextView.setText(workoutnames[workoutstagecount]);
            workoutCountTextView.setText(workoutcount[workoutstagecount]);
        }

        switch (workoutstagecount)
        {
            case 0:  playVideo(R.raw.high_stepping);
                mediaPlayer = mediaPlayer.create(this,R.raw.high_stepping_sound);
                mediaPlayer.start();
                break;
            case 1:  playVideo(R.raw.jumpingjacks);
                mediaPlayer = mediaPlayer.create(this,R.raw.jumping_jack_sound);
                mediaPlayer.start();
                break;
            case 2:  playVideo(R.raw.pushup_og);
                mediaPlayer = mediaPlayer.create(this,R.raw.pushup_sound);
                mediaPlayer.start();
                break;
            case 3:  playVideo(R.raw.leg_raise_og);
                mediaPlayer = mediaPlayer.create(this,R.raw.leg_raisesound);
                mediaPlayer.start();
                break;
            case 4:  playVideo(R.raw.lunges_og);
                mediaPlayer = mediaPlayer.create(this,R.raw.lunges_sound);
                mediaPlayer.start();
                break;
            case 5:  playVideo(R.raw.abductor_strech_og);
                mediaPlayer = mediaPlayer.create(this,R.raw.abductor_stretch_sound);
                mediaPlayer.start();
                break;

            case 6:  playVideo(R.raw.mountain_climber);
                mediaPlayer = mediaPlayer.create(this,R.raw.mountain_climber_sound);
                mediaPlayer.start();
                break;
            case 7:  playVideo(R.raw.side_legraise);
                mediaPlayer = mediaPlayer.create(this,R.raw.side_legraise_sound);
                mediaPlayer.start();
                break;
            case 8:  playVideo(R.raw.sleep_cycling);
                mediaPlayer = mediaPlayer.create(this,R.raw.sleep_cycling_sound);
                mediaPlayer.start();
                break;
            case 9:  playVideo(R.raw.leg_raise_og);
                mediaPlayer = mediaPlayer.create(this,R.raw.leg_raisesound);
                mediaPlayer.start();
                break;
        }

        //timemode_display.setText("Workout time");
        workoutTimer = new CountDownTimer(workoutTimeMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimerText(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                isWorkoutTime = false;
                timerTextView.setText("Break Time: 10 sec");
                workoutTimer = null;
                workoutstagecount++;
                startWorkout();
            }
        }.start();
    }

    private void startBreakTimer() {
        workoutCountTextView.setVisibility(View.INVISIBLE);
        breakcount++;
        playVideo(R.raw.break_videoog);
        mediaPlayer = mediaPlayer.create(this,R.raw.break_soundog);
        mediaPlayer.start();
        //timemode_display.setText("Break time");

        workoutTimer = new CountDownTimer(breakTimeMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimerText(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                isWorkoutTime = true;
                timerTextView.setText("Workout Time: 30 sec");
                workoutTimer = null;
                startWorkout();
            }
        }.start();
    }

    private void updateTimerText(long millis) {
        int seconds = (int) (millis / 1000) % 60;
        timerTextView.setText(String.format("%02d sec", seconds));
    }

    private void pauseWorkout() {
        if (workoutTimer != null) {
            workoutTimer.cancel();
            workoutTimer = null;
            startPauseButton.setText("Resume");
        }
    }

    private void resetWorkout() {
        if (workoutTimer != null) {
            workoutTimer.cancel();
            workoutTimer = null;
        }
        isWorkoutTime = true;
        workoutCount = 0;

        workoutCountTextView.setText("  ");
        timerTextView.setText("30 sec");
        startPauseButton.setText("Start");
        workoutCountTextView.setVisibility(View.VISIBLE);
        startPauseButton.setEnabled(true);
        workoutstagecount = 0; // Reset the workout stage count
        playVideo(R.raw.pushup_og); // Replace with the resource ID of the first workout video
    }


    private void playVideo(int videoResource) {
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + videoResource);
        videoView.setVideoURI(videoUri);
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.start(); // Loop the video
            }
        });
    }
}
