package parcheesi.player;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button rollDice;
	private Button quitGame;
	public static int dice1 = 0;
	public static int dice2 = 0;
	public SoundPool soundpool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
	public int diceRolling;
	public int quitSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollDice = (Button)findViewById(R.id.buttonRoll);
		rollDice.setOnClickListener(this);
		quitGame = (Button)findViewById(R.id.buttonQuit);
		quitGame.setOnClickListener(this);
		
		diceRolling = soundpool.load(this, R.raw.diceroll, 1);
		quitSound = soundpool.load(this, R.raw.quitsound, 1);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public static void rollDice(){
    	dice1 = (int)(Math.random()*6);
    	dice2 = (int)(Math.random()*6);
    }
   


	@Override
	public void onClick(View v) {
		if(v == rollDice){
			soundpool.play(diceRolling, 1, 1, 0, 0, 1);
			rollDice();
		}
		else if(v == quitGame){
			soundpool.play(quitSound, 1, 1, 0, 0, 1);
			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Are You Sure You Want To Quit?");
            builder1.setCancelable(true);
            builder1.setPositiveButton("Yes I'm Sure",
                    new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    System.exit(0);
                }
            });
            builder1.setNegativeButton("No, Nevermind",
                    new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

            AlertDialog alert11 = builder1.create();
            alert11.show();
		}
		
	}
    
}
