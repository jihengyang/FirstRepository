package com.example.ji.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.animation.Animation;

import com.example.ji.view.MyView;

/**
 * Created by ji on 2016/6/29.
 */
public class JtcActivity extends Activity{
    private MyView myView;

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        if(bundle!=null&&bundle.getString("saveInstance")!=null){
            Log.e("saveInstance",bundle.getString("saveInstance"));
        }
        setContentView(R.layout.jtc);
    }

    private void initView(){
        myView = (MyView)findViewById(R.id.myView);
    }
    private void initDate(){

    }
    private void initListener(){
        myView.setAnimation(new Animation() {
        });
    }












    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK&&event.getRepeatCount() ==0){
            Intent intent = new Intent();
            intent.putExtra("haha","haha");
            setResult(1,intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("saveInstance","saveInstance");
        Log.e("kill","kill");
        super.onSaveInstanceState(outState);

    }
}
