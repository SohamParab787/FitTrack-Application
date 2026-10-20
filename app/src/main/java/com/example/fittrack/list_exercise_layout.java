package com.example.fittrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class list_exercise_layout extends AppCompatActivity
{
    private short selectedDifficulty;
    private TextView difficulty_heading;
    private ListView listView;
    String title1[] = {"Push-ups",
            "Squats",
            "Plank",
            "Lunges",
            "Crunches",
            "Jumping Jacks",
            "Mountain Climbers",
            "Wall Sit",
            "Russian Twists",
            "Glute Bridge"};
    String info1[] = {"Start in a high plank position with your hands slightly wider than shoulder-width apart. Lower your body towards the ground by bending your elbows, keeping your back straight. Push back up to the starting position. Repeat for the desired number of repetitions.",
            "Stand with your feet shoulder-width apart. Lower your body by bending your knees and pushing your hips back, as if you're sitting back into a chair. Keep your chest up and your weight on your heels. Rise back up to the starting position. Repeat.",
            "Start in a push-up position with your hands directly under your shoulders. Lower your forearms to the ground, elbows at a 90-degree angle. Engage your core and maintain a straight line from your head to your heels. Hold this position for the desired duration.",
            "Stand with your feet hip-width apart. Take a step forward with your right foot, lowering your body until both knees are bent at a 90-degree angle. Push off your right foot to return to the starting position. Repeat with the left leg.",
            "Lie on your back with your knees bent and feet flat on the ground. Place your hands behind your head, elbows pointing out to the sides. Engage your core and lift your upper body towards your knees, using your abdominal muscles. Lower back down and repeat.",
            "Start with your feet together and arms by your sides. Jump your feet out wide while simultaneously raising your arms overhead. Quickly return to the starting position by jumping your feet back together and lowering your arms. Repeat.",
            "Begin in a high plank position with your hands under your shoulders. Bring your right knee towards your chest, then quickly switch legs, bringing the left knee in and the right leg back. Continue alternating legs in a running motion.",
            "Stand with your back against a wall and slide down until your knees are bent at a 90-degree angle. Keep your back against the wall and hold this position for the desired duration. Focus on engaging your leg muscles.",
            "Sit on the ground with your knees bent and feet flat on the floor. Lean back slightly, keeping your back straight. Lift your feet off the ground and balance on your sit bones. Twist your torso from side to side, touching the ground with your hands on each side.",
            "Lie on your back with your knees bent and feet flat on the ground, hip-width apart. Engage your glutes and lift your hips off the ground until your body forms a straight line from your knees to your shoulders. Lower your hips back down and repeat."};

    String title2[] = {    "Burpees",
            "Dumbbell Lunges",
            "Plank with Leg Lift",
            "Russian Twist with Medicine Ball",
            "Tricep Dips",
            "Mountain Climber with Twist",
            "Jumping Lunges",
            "Bicycle Crunches",
            "Shoulder Press",
            "Side Plank"};
    String info2[] = {  "Start in a standing position. Drop down into a squat position with your hands on the ground. Kick your feet back into a push-up position. Perform a push-up, then quickly return your feet to the squat position. Jump explosively into the air, reaching your arms overhead. Repeat.",
            "Hold a dumbbell in each hand. Take a step forward with your right foot, lowering your body until both knees are bent at a 90-degree angle. Push off your right foot to return to the starting position. Repeat with the left leg.",
            "Start in a high plank position. Lift one leg off the ground, keeping it straight and in line with your body. Hold for a few seconds, then lower the leg back down. Alternate legs and repeat.",
            "Sit on the ground with your knees bent and feet flat on the floor. Hold a medicine ball or weight with both hands. Lean back slightly, keeping your back straight. Twist your torso from side to side, touching the medicine ball or weight to the ground on each side.",
            "Sit on a chair or bench with your hands gripping the edge. Extend your legs out in front of you. Lower your body by bending your elbows, keeping your back close to the chair or bench. Push back up to the starting position. Repeat.",
            "Start in a high plank position. Bring your right knee towards your left elbow, twisting your torso. Return to the starting position and repeat with the left knee towards the right elbow. Continue alternating sides.",
            "Start in a lunge position with your right leg forward. Jump explosively into the air, switching the position of your legs mid-air. Land softly with your left leg forward. Repeat in a continuous jumping motion.",
            "Lie on your back with your knees bent and feet off the ground, shins parallel to the floor. Place your hands behind your head, elbows pointing out to the sides. Bring your right elbow towards your left knee while straightening your right leg. Repeat on the other side, cycling your legs in a pedaling motion.",
            "Hold dumbbells at shoulder level, palms facing forward. Press the dumbbells upward until your arms are fully extended overhead. Lower the dumbbells back down to the starting position. Repeat.",
            "Start in a side plank position with your elbow directly under your shoulder and feet stacked on top of each other. Keep your body in a straight line from head to toe. Hold this position for the desired duration, then switch sides."};

    String title3[] = {    "Plyometric Push-ups",
            "Barbell Squats",
            "Hanging Leg Raises",
            "Renegade Rows",
            "Single-Leg Romanian Deadlifts",
            "Handstand Push-ups",
            "Bulgarian Split Squats",
            "Toes to Bar",
            "Clean and Jerk",
            "Dragon Flags"};
    String info3[] = { "Start in a push-up position. Lower your body towards the ground and explosively push off the ground, allowing your hands to leave the floor. Clap your hands together before landing with control. Repeat.",
            "Place a barbell across your upper back, resting it on your shoulders. Stand with your feet shoulder-width apart. Lower your body by bending your knees and pushing your hips back, keeping your chest up. Rise back up to the starting position. Repeat.",
            "Hang from a pull-up bar with an overhand grip. Keeping your legs straight, lift them up towards your chest by engaging your core muscles. Slowly lower your legs back down. Repeat.",
            "Start in a push-up position with dumbbells in your hands. Perform a push-up, then row one dumbbell up towards your chest, keeping your core tight and back flat. Lower the dumbbell back down and repeat with the other arm. Alternate sides and repeat.",
            "Hold a dumbbell or kettlebell in one hand. Stand on one leg and hinge forward at the hips, extending your non-weight-bearing leg behind you for balance. Lower the weight towards the ground while keeping your back straight. Return to the starting position and repeat. Switch sides.",
            "Begin in a handstand position against a wall or with the support of a spotter. Lower your body towards the ground by bending your elbows, keeping your head and neck in line. Push back up to the starting position. Repeat.",
            "Stand in a split stance with one foot forward and the other foot elevated behind you on a bench or step. Lower your body by bending your front knee and lowering your back knee towards the ground. Push back up to the starting position. Repeat. Switch sides.",
            "Hang from a pull-up bar with an overhand grip. Engage your core and bring your toes up towards the bar by flexing your hips and contracting your abdominal muscles. Slowly lower your legs back down. Repeat.",
            "With a barbell or dumbbells, clean the weight up to your shoulders, then push it overhead in one fluid motion. Lower the weight back down to your shoulders, then drop into a partial squat and explosively press the weight overhead again. Repeat.",
            "Lie on a bench or mat, holding onto the edge with your hands for support. Raise your legs, torso, and hips off the bench, keeping your body straight. Slowly lower your body back down, maintaining control. Repeat."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_exercise_layout);

        listView = findViewById(R.id.listView);
        difficulty_heading = findViewById(R.id.difficulty_heading);

        Intent intent1 = getIntent();
        selectedDifficulty = intent1.getShortExtra("Selected button", (short) 0);
     //   Toast.makeText(this, "Selected button="+selectedDifficulty, Toast.LENGTH_SHORT).show();



        if (selectedDifficulty == 1){
            String difficulty = "Beginner level";
            difficulty_heading.setText(difficulty);
            CustomBaseAdapter CustomBaseAdapter = new CustomBaseAdapter(getApplicationContext(),title1,info1);
            listView.setAdapter(CustomBaseAdapter);
        }

        if (selectedDifficulty == 2){
            String difficulty = "Intermediate level";
            difficulty_heading.setText(difficulty);
            CustomBaseAdapter CustomBaseAdapter = new CustomBaseAdapter(getApplicationContext(),title2,info2);
            listView.setAdapter(CustomBaseAdapter);
        }

        if (selectedDifficulty == 3){
            String difficulty = "Advance level";
            difficulty_heading.setText(difficulty);
            CustomBaseAdapter CustomBaseAdapter = new CustomBaseAdapter(getApplicationContext(),title3,info3);
            listView.setAdapter(CustomBaseAdapter);
        }
    }
}
