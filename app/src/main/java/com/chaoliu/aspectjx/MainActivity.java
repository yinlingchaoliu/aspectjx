package com.chaoliu.aspectjx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.chaoliu.mock.annotation.SingleClick;

import java.util.UUID;

import hugo.weaving.DebugLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        findViewById( R.id.button ).setOnClickListener( v->{
            getName("Jake","Wharton");
//            getName();
        } );
    }

    @SingleClick
    @DebugLog
    public String getName(String first, String last) {
        Toast.makeText( this,first + " "+last + UUID.randomUUID(),Toast.LENGTH_SHORT ).show();
        return first + " " + last;
    }

    @DebugLog
    @SingleClick
    public String getName() {
//        SystemClock.sleep(15); // Don't ever really do this!
        Toast.makeText( this,""+ UUID.randomUUID(),Toast.LENGTH_SHORT ).show();
        return "123";
    }

}
