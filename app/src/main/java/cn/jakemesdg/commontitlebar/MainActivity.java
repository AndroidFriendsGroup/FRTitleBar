package cn.jakemesdg.commontitlebar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import cn.share.jack.frtitlebar.FRTitleBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTitleBar();
    }

    private void initTitleBar() {
        FRTitleBar titleBar = new FRTitleBar.FRTiTitleBarBuilder(this)
                .setDefaultLeft()
                .setBackgroundColor(R.color.colorPrimary)
                .setTitleContent("首页")
                .setRightContent("右边")
                .setRightOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "点击了右边", Toast.LENGTH_SHORT).show();
                    }
                })
                .builder();
    }
}