package com.wzz.app_github_mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wzz.app_github_mvp.adapter.RepositoryAdapter;
import com.wzz.app_github_mvp.model.Repository;
import com.wzz.app_github_mvp.presenter.UserReposPresenterImpl;
import com.wzz.app_github_mvp.view.UserReposBaseView;

import java.util.List;

public class UserRepoActivity extends AppCompatActivity implements UserReposBaseView, View.OnClickListener {

    private Toolbar toolbar ;
    private EditText edit_text_username ;
    private ProgressBar progress ;
    private TextView text_info ;
    private RecyclerView recyclerView;
    private RepositoryAdapter adapter ;
    private ImageButton button_search ;

    UserReposPresenterImpl mPresenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_repo);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        edit_text_username = (EditText) findViewById(R.id.edit_text_username);
        progress = (ProgressBar) findViewById(R.id.progress);
        text_info = (TextView) findViewById(R.id.text_info);
        recyclerView = (RecyclerView) findViewById(R.id.repos_recycler_view);
        button_search = (ImageButton) findViewById(R.id.button_search);

        setSupportActionBar(toolbar);
        button_search.setOnClickListener(this);
        addTextListener();

        String username = getIntent().getStringExtra("username");
        edit_text_username.setText( username );

        mPresenter = new UserReposPresenterImpl();
        mPresenter.attach( this );

        mPresenter.loadSecondGithub("wanzz008");
    }


    private void addTextListener(){
        edit_text_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                button_search.setVisibility(s.length() > 0 ? View.VISIBLE : View.GONE);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }




    private void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edit_text_username.getWindowToken(),0) ;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();

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
    public void showRecyclerView(List<Repository> repositories) {
        progress.setVisibility(View.GONE);
        text_info.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        adapter = new RepositoryAdapter(this,repositories);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        hideSoftKeyboard() ;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_search :
                mPresenter.loadSecondGithub(edit_text_username.getText().toString());
                break ;
        }
    }
}
