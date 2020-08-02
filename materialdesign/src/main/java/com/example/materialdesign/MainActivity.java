package com.example.materialdesign;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.XXX)
    TextView XXX;
    @BindView(R.id.btn_start)
    Button btnStart;
    @BindView(R.id.btn_close)
    Button btnClose;
    @BindView(R.id.main)
    LinearLayout main;
    @BindView(R.id.left_mian)
    LinearLayout leftMian;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.right_main)
    LinearLayout rightMain;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @BindView(R.id.floatbtn)
    FloatingActionButton floatbtn;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.left_listview)
    ListView leftListview;
    @BindView(R.id.snackbar_container)
    CoordinatorLayout snackbarContainer;
    private boolean isopen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();


    }



    private void initView() {
        toolbar.setTitle("首页");
        toolbar.setSubtitle("副标题");
        toolbar.setNavigationIcon(R.drawable.announce_read);
        toolbar.setLogo(R.drawable.back_black);
        setSupportActionBar(toolbar);
        //Toobar与bangding
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.open, R.string.lcose);
        actionBarDrawerToggle.syncState();
        drawerlayout.setDrawerListener(actionBarDrawerToggle);
        floatbtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "00", Toast.LENGTH_SHORT).show();
                Snackbar.make(snackbarContainer,"这是一个snackbar", Snackbar.LENGTH_LONG).show();
            }
        });

//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @SuppressLint("WrongConstant")
//            @Override
//            public void onClick(View v) {
//                if(isopen){
//                    drawerlayout.closeDrawer(Gravity.START);
//                }else{
//                    drawerlayout.openDrawer(Gravity.START);
//                }
//
//                Toast.makeText(MainActivity.this, "编辑", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @OnClick(R.id.toolbar)
    public void onViewClicked() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_edit:
                Toast.makeText(this, "编辑", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("WrongConstant")
    @OnClick({R.id.XXX, R.id.toolbar, R.id.btn_start, R.id.btn_close, R.id.main, R.id.left_mian, R.id.btn_right, R.id.right_main})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.XXX:
                break;
            case R.id.toolbar:
                break;
            case R.id.btn_start:
                drawerlayout.openDrawer(Gravity.START);
                break;
            case R.id.btn_close:
                drawerlayout.openDrawer(Gravity.END);
                break;
            case R.id.main:
                break;
            case R.id.left_mian:
                break;
            case R.id.btn_right:
                break;
            case R.id.right_main:
                break;
        }
    }
}
