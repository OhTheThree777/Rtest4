package cn.edu.imnu.ciec.rtest4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {//Bundel 保存的一些状态 可以用来传递数据
        if (savedInstanceState!=null){
            String tempData=savedInstanceState.getString("data");

        }
        Log.i(TAG, "onCreate: create RHM");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startDialogActivity= (Button) findViewById(R.id.start_dialog_actibity);
        Button startNormalActivity= (Button) findViewById(R.id.start_normal_activity);


        startNormalActivity.setOnClickListener(this);
        startDialogActivity.setOnClickListener(this);
        /*
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        在上面引入接口之后就可以用20 21 行来进行监听绑定
        在下面进行分辨
        */
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_normal_activity:

                Intent intent1=new Intent(MainActivity.this,NormalActivity.class);
                startActivity(intent1);
                break;
            case R.id.start_dialog_actibity:

                Intent intent2=new Intent(MainActivity.this,DialogActivity.class);
                startActivity(intent2);
                break;
        }
    }

    /*
        Activity 提供了这个回调方法，接个方法可以保证活动在被回收前一定会被调用
        就可以保存数据

     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        String tempData="Test bundle";
        outState.putString("data",tempData);

    }

    @Override
    protected void onStart() {

        super.onStart();
        Log.i(TAG, "onStart: Start RHM");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: Resume RHM");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: Pause RHM");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: Stop RHM");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: Destroy RHM");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: Restart RHM");
    }
}
