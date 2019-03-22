package com.wzz.app_mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wzz.app_mvp.model.User;
import com.wzz.app_mvp.present.MainPresenterImpl;
import com.wzz.app_mvp.view.MainBaseView;

/**
 * MVP:
 * 把UI逻辑抽象成View接口，把业务逻辑抽象成Presenter接口，model还是之前的model
 */
public class MainActivity extends AppCompatActivity implements MainBaseView{

    public  MainPresenterImpl presenter ;
    public EditText et1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenterImpl();
        presenter.attach( this );


        et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);


        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(new User( et1.getText().toString() , et2.getText().toString() ));
            }
        });
    }


    @Override
    public void loginSuccess(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
