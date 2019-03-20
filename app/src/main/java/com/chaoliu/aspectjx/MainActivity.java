package com.chaoliu.aspectjx;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import hugo.weaving.DebugLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        findViewById( R.id.button ).setOnClickListener( v->{
            getName("Jake","Wharton");
        } );
    }

    @DebugLog
    public String getName(String first, String last) {
//        SystemClock.sleep(15); // Don't ever really do this!
        Toast.makeText( this,first + " "+last,Toast.LENGTH_SHORT ).show();
        return first + " " + last;
    }

}
