package jp.suntech.c22010.myapplication;

import static java.lang.String.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BCListener bcListener = new BCListener();
        findViewById(R.id.bt_calc).setOnClickListener(bcListener);
        findViewById(R.id.bt_clr).setOnClickListener(bcListener);
    }
    private class BCListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            EditText in_age = findViewById(R.id.et_age);
            EditText in_height = findViewById(R.id.et_height);
            EditText in_weight = findViewById(R.id.et_weight);
            TextView out_show_obesity = findViewById(R.id.tv_show_obesity);
            TextView out_obesity = findViewById(R.id.tv_obesity);
            TextView out_show_best_weight = findViewById(R.id.tv_show_best_weight);
            TextView out_best_weight = findViewById(R.id.tv_best_weight);

            int id = view.getId();

            if(id == R.id.bt_calc){



                //計算機能バグってます



                float height = Float.parseFloat(in_height.getText().toString());
                float weight = Float.parseFloat(in_weight.getText().toString());
                float bmi = weight * 10000 / height / height;
                float best_weight = weight * 22 / bmi;


                //判定を表示
                out_show_obesity.setText(R.string.tv_obesity);
                if(bmi < 18.5){
                    out_obesity.setText(R.string.tv_obesity_low);
                }
                else if(bmi < 25){
                    out_obesity.setText(R.string.tv_obesity_nom);
                }
                else if(bmi < 30){
                    out_obesity.setText(R.string.tv_obesity_1);
                }
                else if(bmi < 35){
                    out_obesity.setText(R.string.tv_obesity_2);
                }
                else if(bmi < 40){
                    out_obesity.setText(R.string.tv_obesity_3);
                }
                else{
                    out_obesity.setText(R.string.tv_obesity_4);
                }

                //適正体重を表示
                out_show_best_weight.setText(R.string.tv_best_weight);
                out_best_weight.setText(format("%.1f", valueOf(best_weight)));
            }
            else if(id == R.id.bt_clr){
                in_age.setText("");
                in_height.setText("");
                in_weight.setText("");
                out_show_obesity.setText("");
                out_obesity.setText("");
                out_show_best_weight.setText("");
                out_best_weight.setText("");
            }
        }
    }
}