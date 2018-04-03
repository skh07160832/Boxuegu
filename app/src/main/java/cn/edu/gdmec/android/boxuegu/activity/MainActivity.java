package cn.edu.gdmec.android.boxuegu.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.edu.gdmec.android.boxuegu.Fragment.CourseFragment;
import cn.edu.gdmec.android.boxuegu.Fragment.ExercisesFragment;
import cn.edu.gdmec.android.boxuegu.Fragment.MyinfoFragment;
import cn.edu.gdmec.android.boxuegu.R;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private RelativeLayout main_body;
    private TextView bottom_bar_text_course;
    private ImageView bottom_bar_image_course;
    private RelativeLayout bottom_bar_course_btn;
    private TextView bottom_bar_text_exercises;
    private ImageView bottom_bar_image_exercises;
    private RelativeLayout bottom_bar_exercises_btn;
    private TextView bottom_bar_text_myinfo;
    private ImageView bottom_bar_image_myinfo;
    private RelativeLayout bottom_bar_myinfo_btn;
    private LinearLayout main_bottom_bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivityForResult(intent, 1);
        setMain();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            boolean isLogin = data.getBooleanExtra("isLogin", false);
            String userName = data.getStringExtra("userName");
            if (isLogin) {
            }
        }
    }

    private void initView() {
        main_body = (RelativeLayout) findViewById(R.id.main_body);
        main_body.setOnClickListener(this);
        bottom_bar_text_course = (TextView) findViewById(R.id.bottom_bar_text_course);
        bottom_bar_image_course = (ImageView) findViewById(R.id.bottom_bar_image_course);
        bottom_bar_course_btn = (RelativeLayout) findViewById(R.id.bottom_bar_course_btn);
        bottom_bar_text_exercises = (TextView) findViewById(R.id.bottom_bar_text_exercises);
        bottom_bar_image_exercises = (ImageView) findViewById(R.id.bottom_bar_image_exercises);
        bottom_bar_exercises_btn = (RelativeLayout) findViewById(R.id.bottom_bar_exercises_btn);
        bottom_bar_text_myinfo = (TextView) findViewById(R.id.bottom_bar_text_myinfo);
        bottom_bar_image_myinfo = (ImageView) findViewById(R.id.bottom_bar_image_myinfo);
        bottom_bar_myinfo_btn = (RelativeLayout) findViewById(R.id.bottom_bar_myinfo_btn);
        main_bottom_bar = (LinearLayout) findViewById(R.id.main_bottom_bar);
        main_bottom_bar.setOnClickListener(this);

        bottom_bar_course_btn.setOnClickListener(this);
        bottom_bar_exercises_btn.setOnClickListener(this);
        bottom_bar_myinfo_btn.setOnClickListener(this);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.main_body,new CourseFragment());
    }

    private void setSelectStatus(int index) {
        switch (index) {
            case 0:
                bottom_bar_image_course.setImageResource(R.drawable.main_course_icon_selected);
                bottom_bar_text_course.setTextColor(Color.parseColor("#0097F7"));

                bottom_bar_image_exercises.setImageResource(R.drawable.main_exercises_icon);
                bottom_bar_text_exercises.setTextColor(Color.parseColor("#666666"));

                bottom_bar_image_myinfo.setImageResource(R.drawable.main_my_icon);
                bottom_bar_text_myinfo.setTextColor(Color.parseColor("#666666"));

                break;
            case 1:
                bottom_bar_image_exercises.setImageResource(R.drawable.main_exercises_icon_selected);
                bottom_bar_text_exercises.setTextColor(Color.parseColor("#0097F7"));

                bottom_bar_image_course.setImageResource(R.drawable.main_course_icon);
                bottom_bar_text_course.setTextColor(Color.parseColor("#666666"));

                bottom_bar_image_myinfo.setImageResource(R.drawable.main_my_icon);
                bottom_bar_text_myinfo.setTextColor(Color.parseColor("#666666"));

                break;
            case 2:
                bottom_bar_image_myinfo.setImageResource(R.drawable.main_my_icon_selected);
                bottom_bar_text_myinfo.setTextColor(Color.parseColor("#0097F7"));

                bottom_bar_image_exercises.setImageResource(R.drawable.main_exercises_icon);
                bottom_bar_text_exercises.setTextColor(Color.parseColor("#666666"));

                bottom_bar_image_course.setImageResource(R.drawable.main_course_icon);
                bottom_bar_text_course.setTextColor(Color.parseColor("#666666"));

                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bottom_bar_course_btn:
                getSupportFragmentManager().beginTransaction().add(R.id.main_body,new CourseFragment()).commit();
                setSelectStatus(0);
                break;
            case R.id.bottom_bar_exercises_btn:
                getSupportFragmentManager().beginTransaction().add(R.id.main_body,new ExercisesFragment()).commit();
                setSelectStatus(1);
                break;
            case R.id.bottom_bar_myinfo_btn:
                getSupportFragmentManager().beginTransaction().add(R.id.main_body,new MyinfoFragment()).commit();
                setSelectStatus(2);
                break;
        }
    }

    private void setMain(){
        this.getSupportFragmentManager().beginTransaction().add(R.id.main_body,new MyinfoFragment()).commit();
        setSelectStatus(2);
    }
}
