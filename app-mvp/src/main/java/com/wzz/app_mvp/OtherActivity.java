package com.wzz.app_mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wzz.app_mvp.model.User;
import com.wzz.app_mvp.present.MainPresenterImpl;
import com.wzz.app_mvp.present.OtherPresenterImpl;
import com.wzz.app_mvp.view.OtherBaseView;

public class OtherActivity extends AppCompatActivity implements OtherBaseView{

    public  MainPresenterImpl presenter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OtherPresenterImpl presenter = new OtherPresenterImpl();
        presenter.attach( this );

        presenter.upload( new User( "test" , "123456" ));

    }


    @Override
    public void showProgress() {

    }

    @Override
    public void showToast(String msg) {

    }
}
