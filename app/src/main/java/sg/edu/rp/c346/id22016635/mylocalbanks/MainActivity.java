package sg.edu.rp.c346.id22016635.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS = findViewById(R.id.tv1);
        tvOCBC = findViewById(R.id.tv2);
        tvUOB = findViewById(R.id.tv3);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact");

        if (v == tvDBS) {
            wordClicked = "dbs";
        } else if (v == tvOCBC) {
            wordClicked = "ocbc";
        } else if (v == tvUOB) {
            wordClicked = "uob";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) {
                Intent intentDo = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intentDo);
            } else if (item.getItemId() == 1) {
                String num = "18001111111";
                Long phone = Long.parseLong(num) ;
                Intent intentDo = new Intent(Intent.ACTION_DIAL,Uri.parse("tel: "+ phone));
                startActivity(intentDo);
            }
        }else if(wordClicked.equalsIgnoreCase("ocbc")){
            if (item.getItemId() == 0) {
                Intent intentDo = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway.page"));
                startActivity(intentDo);
            } else if (item.getItemId() == 1) {
                String num = "18003633333";
                Long phone = Long.parseLong(num) ;
                Intent intentDo = new Intent(Intent.ACTION_DIAL,Uri.parse("tel: "+ phone));
                startActivity(intentDo);
            }
        }else if(wordClicked.equalsIgnoreCase("uob")){
            if (item.getItemId() == 0) {
                Intent intentDo = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg/personal/index.page"));
                startActivity(intentDo);

            } else if (item.getItemId() == 1) {
                String num = "18002222121";
                Long phone = Long.parseLong(num) ;
                Intent intentDo = new Intent(Intent.ACTION_DIAL,Uri.parse("tel: "+ phone));
                startActivity(intentDo);
            }
        }


        return super.onContextItemSelected(item); //pass menu item to the superclass implementation

    }
    


}






