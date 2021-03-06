
package com.chenhao.sample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.third.lib.ThirdLibMain;
import com.third.lib2.ThirdLib2Main;

import app.lib.commonui.widget.TitleBar;
import app.lib.plugin.frame.PluginApi;
import app.lib.plugin.sdk.PluginMsgType;

/**
 * Created by chenhao on 17/1/10.
 */

public class PluginTestActivity extends FragmentActivity {
    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;

        int result1 = ThirdLibMain.add(2, 3);

        int result2 = ThirdLib2Main.minus(2, 3);

        setContentView(R.layout.activity_plugin_test);

        ((TitleBar) findViewById(R.id.title_bar)).setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.plugin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PluginApi.getInstance().sendMessage(mContext, "demo", PluginMsgType.LAUNCH,
                        new Bundle(), new PluginApi.SendMessageCallback());
            }
        });

    }
}
