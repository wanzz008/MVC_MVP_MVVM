package com.wzz.mvvm;

import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2019/3/4.
 */
public class User {

//    public String username ;
//    public String pwd ;

    /**
        <data>
        <variable name="user" type="com.wzz.mvvm.User"/>
        </data>
     */

    /**
     * 视图绑定，要用ObservableField  通过set()设置值，get()获取值
     * 使用：android:text="@{user.username}"
     */
    public ObservableField<String> username = new ObservableField<>() ;

    public ObservableField<String> newName = new ObservableField<>() ;

    /**
     * 设置点击事件  方法名和xml中的保持一致.
     * 使用： android:onClick="@{user.myClick}"
     * @param view
     */
    public void myClick(View view){
        Log.d("wzz-----" , username.get() ) ;
    }



//    @BindingAdapter({"newName"})
//    public static void setNewName(TextView textView , ObservableField<String> name ){
//        textView.setText( name.get() );
//    }
}
