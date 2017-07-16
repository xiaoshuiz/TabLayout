package com.example.shuiz.tablayout;


        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;

        import fragment.Fragment1;
        import fragment.Fragment2;
        import fragment.Fragment3;
        import fragment.Fragment4;
        import ui.StatusBarUtils;
/**
 * Created by shuiz on 2017/7/11.
 */

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup navigationBar;
    private RadioButton btn1, btn2, btn3, btn4;
    private Fragment fragment1, fragment2, fragment3, fragment4;

    private Fragment mFragment;//当前显示的Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.main_fragment, fragment1).commit();
        mFragment = fragment1;

    }

    private void initViews() {
        navigationBar = (RadioGroup) findViewById(R.id.navigation_btn);
        btn1 = (RadioButton) findViewById(R.id.btn1);
        btn2 = (RadioButton) findViewById(R.id.btn2);
        btn3 = (RadioButton) findViewById(R.id.btn3);
        btn4 = (RadioButton) findViewById(R.id.btn4);
        navigationBar.setOnCheckedChangeListener(this);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        StatusBarUtils.setWindowStatusBarColor(MainActivity.this,R.color.colorAccent);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.btn1:
                btn1.setChecked(true);
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(false);
                switchFragment(fragment1);
                break;
            case R.id.btn2:
                btn1.setChecked(false);
                btn2.setChecked(true);
                btn3.setChecked(false);
                btn4.setChecked(false);
                switchFragment(fragment2);

                break;
            case R.id.btn3:
                btn1.setChecked(false);
                btn2.setChecked(false);
                btn3.setChecked(true);
                btn4.setChecked(false);
                switchFragment(fragment3);

                break;
            case R.id.btn4:
                btn1.setChecked(false);
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(true);
                switchFragment(fragment4);

                break;
        }
    }

    private void switchFragment(Fragment fragment) {
        //判断当前显示的Fragment是不是切换的Fragment
        if (mFragment != fragment) {
            //判断切换的Fragment是否已经添加过
            if (!fragment.isAdded()) {
                //如果没有，则先把当前的Fragment隐藏，把切换的Fragment添加上
                getSupportFragmentManager().beginTransaction().hide(mFragment)
                        .add(R.id.main_fragment, fragment).commit();
            } else {
                //如果已经添加过，则先把当前的Fragment隐藏，把切换的Fragment显示出来
                getSupportFragmentManager().beginTransaction().hide(mFragment).show(fragment).commit();
            }
            mFragment = fragment;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment1 == null && fragment instanceof Fragment1){
            fragment1 = fragment;
        } else if (fragment2 == null && fragment instanceof Fragment2){
            fragment2 = fragment;
        }else if (fragment3 == null && fragment instanceof Fragment3){
            fragment3 = fragment;
        }else if (fragment4 == null && fragment instanceof Fragment4){
            fragment4 = fragment;
        }
    }
}
