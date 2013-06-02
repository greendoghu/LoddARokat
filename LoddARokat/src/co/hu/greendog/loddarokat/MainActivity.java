package co.hu.greendog.loddarokat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends Activity {
	String[] temp;
	int loves = 1;
	int[][] matrix = new int[216][5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn = (Button)findViewById(R.id.button1);
        matrix = reset();
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
		        TextView tw = (TextView)findViewById(R.id.textView1);
		        TextView tw2 = (TextView)findViewById(R.id.textView2);
		        EditText et = (EditText)findViewById(R.id.editText1);
		        TextView tw3 = (TextView)findViewById(R.id.textView3);
				String tempnum = et.getText().toString();
				int num1 = Integer.parseInt(tempnum.substring(0, 1));
				int num2 = Integer.parseInt(tempnum.substring(1, 2));
				int num3 = Integer.parseInt(tempnum.substring(2, 3));
				if(loves==5){
					matrix = reset();
					loves=1;
					tw.setText(loves+". lövés:");
					btn.setText(loves +". lövés");
					et.setText("");
					tw2.setText("");
					tw3.setText("");
				}
				else if(loves==1){
					for(int i=0;i<216;i++){
						if(matrix[i][1]==num1||matrix[i][1]==num2||matrix[i][1]==num3){
							matrix[i][0]=-1;
						}
					}
					loves++;
					tw.setText(loves+". lövés:");
					btn.setText(loves +". lövés");
					et.setText("");
				}
				else if(loves==2){
					for(int i=0;i<216;i++){
						if(matrix[i][2]==num1||matrix[i][2]==num2||matrix[i][2]==num3){
							matrix[i][0]=-1;
						}
					}
					loves++;
					tw.setText(loves+". lövés:");
					btn.setText(loves +". lövés");
					et.setText("");
				}
				else if(loves==3){
					for(int i=0;i<216;i++){
						if(matrix[i][3]==num1||matrix[i][3]==num2||matrix[i][3]==num3){
							matrix[i][0]=-1;
						}
					}
					loves++;
					tw.setText(loves+". lövés:");
					btn.setText(loves +". lövés");
					et.setText("");
				}
				else if(loves == 4){
					for(int i=0;i<216;i++){
						if(matrix[i][4]==num1||matrix[i][4]==num2||matrix[i][4]==num3){
							matrix[i][0]=-1;
						}
					}
					int tempwin=0;
					for(int i=0;i<216;i++){
							if(matrix[i][0]==0)tempwin++;
					}
					loves++;
					tw2.setText("Megmaardt rókák száma: "+tempwin);
					tw3.setText("LelŒtt rókák: "+(216-tempwin));
					btn.setText("Újra");  
				}
			}
		});
    }
    public int[][] reset(){
    	int[][] matrix = new int[216][5];
    	try {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(getAssets().open("matrix.txt"), "UTF-8")); 
            	for(int i=0;i<216;i++){
            		temp = reader.readLine().split(";");
            		matrix[i][0]=Integer.parseInt(temp[0]);
            		matrix[i][1]=Integer.parseInt(temp[1]);
            		matrix[i][2]=Integer.parseInt(temp[2]);
            		matrix[i][3]=Integer.parseInt(temp[3]);
            		matrix[i][4]=Integer.parseInt(temp[4]);
            	}

            reader.close();
        } catch (IOException e) {
        }
    	return matrix;
    }
    
}
