package com.wzz.app_github_mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wzz.app_github_mvp.adapter.RepoListAdapter;
import com.wzz.app_github_mvp.model.Repo;
import com.wzz.app_github_mvp.presenter.MainPresenterImpl;
import com.wzz.app_github_mvp.view.MainBaseView;

import java.util.List;

/**
 * 第一个界面的接口访问
 */
public class MainActivity extends AppCompatActivity implements MainBaseView {

    private MainPresenterImpl mPresenter;


    private Toolbar toolbar ;
    private RecyclerView recyclerView;
    private TextView text_description ;
    private ProgressBar progress ;
    private TextView text_info ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        text_description = (TextView) findViewById(R.id.text_description);
        progress = (ProgressBar) findViewById(R.id.progress);
        text_info = (TextView) findViewById(R.id.text_info);

        setSupportActionBar(toolbar);
        text_description.setText("GitHub Java");


        mPresenter = new MainPresenterImpl();
        mPresenter.attach( this );

        mPresenter.loadGithub();
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
        text_info.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage() {
        progress.setVisibility(View.GONE);
        text_info.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showRecyclerView(List<Repo> repos) {
        progress.setVisibility(View.GONE);
        text_info.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        RepoListAdapter adapter = new RepoListAdapter(this,repos) ;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }
}
