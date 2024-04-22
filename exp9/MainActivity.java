package com.example.ad_exp_9;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME = "example.txt";// Declares a constant string variable holding the filename used for saving/loading data ("example.txt").
    EditText mEditText;// Declares a member variable mEditText to store a reference to the EditText view from the layout (where users input text).
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//Calls the parent class's onCreate method for its initial setup.
        setContentView(R.layout.activity_main);//Sets the layout file (activity_main.xml) for the activity's UI.
        mEditText = findViewById(R.id.edit_text);// Finds the EditText view with the ID edit_text from the layout and stores its reference in mEditText for easier access.
    }
    public void Save(View view) {
        String text = mEditText.getText().toString();//Gets the current text entered by the user in the mEditText and converts it to a String.
        FileOutputStream fos = null;// Declares a variable fos to hold a reference to a FileOutputStream object (used for writing data to a file). It's initialized to null.
        try {
            fos=openFileOutput(FILE_NAME,MODE_PRIVATE);//Opens a file output stream for the FILE_NAME with private mode (accessible only to this app). Stores the stream reference in fos.
            fos.write(text.getBytes());//Writes the user's text (converted to bytes) to the opened file.
            mEditText.getText().clear();//Clears the EditText content after saving.
            Toast.makeText(this,"Saved to "+getFilesDir()+"/"+FILE_NAME,Toast.LENGTH_SHORT).show();// Displays a Toast message indicating successful saving with the file location.
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            if(fos != null)
            {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public void Load(View view) {
        FileInputStream fis = null;//Declares a variable fis to hold a reference to a FileInputStream object (used for reading data from a file). It's initialized to null.
        try {
            fis = openFileInput(FILE_NAME);// Opens a file input stream for the file named FILE_NAME (defined as "example.txt"). If the file doesn't exist, this line throws a FileNotFoundException. The stream reference is stored in fis.
            InputStreamReader isr = new InputStreamReader(fis);//Creates an `InputStreamReader` object. This is necessary because `FileInputStream` deals with bytes, while we want to read characters (text).
            BufferedReader br = new BufferedReader(isr);// Creates a `BufferedReader` object. This provides a more efficient way to read text from the `InputStreamReader` by reading lines at a time.
            StringBuilder sb = new StringBuilder(); //Creates a `StringBuilder` object. This is used to efficiently build the complete text string as we read lines from the file.
            String text;//Declares a String variable `text` to temporarily store each line read from the file.
            while((text=br.readLine())!=null){//This loop continues as long as there are lines to be read from the file.Reads a single line of text from the file using the `BufferedReader` and stores it in the `text` variable. If there are no more lines, `readLine` returns null.
                sb.append(text).append("\n");//Appends the read line (`text`) to the `StringBuilder` object (`sb`). It also appends a newline character (`\n`) to ensure proper line breaks in the final text.
            }
            mEditText.setText(sb.toString());//Once the loop finishes reading all lines, the `sb.toString()` method converts the `StringBuilder` object to a String containing the entire loaded text. This String is then set as the text content of the EditText view (`mEditText`) using `setText`.
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}