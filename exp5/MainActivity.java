package com.example.ad_exp_5;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private Button btnPopup, btnOption, btnContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPopup = findViewById(R.id.btnPopup);
        btnOption = findViewById(R.id.btnOption);
        btnContext = findViewById(R.id.btnContext);
        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupDialog(v);
            }
        });
        btnOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionMenu(v);
            }
        });
        registerForContextMenu(btnContext); // This line registers the button for context menu
    }
    private void showPopupDialog(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.popup_dialog, null);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        Button btnClosePopup = dialogView.findViewById(R.id.btnClosePopup);
        btnClosePopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
    private void showOptionMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().inflate(R.menu.option_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new
                                                     PopupMenu.OnMenuItemClickListener() {
                                                         @Override
                                                         public boolean onMenuItemClick(MenuItem item) {
                                                             if (item.getItemId() == R.id.menu_item_1) {showToast("Option 1 selected");
                                                                 return true;
                                                             } else if (item.getItemId() == R.id.menu_item_2) {
                                                                 showToast("Option 2 selected");
                                                                 return true;
                                                             }
                                                             return false;
                                                         }
                                                     });
        popupMenu.show();
    }
    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v,
//                                    ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        getMenuInflater().inflate(R.menu.context_menu, menu);
//    }
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.context_item_1) {
            showToast("Context item 1 selected");
            return true;
        } else if (item.getItemId() == R.id.context_item_2) {
            showToast("Context item 2 selected");
            return true;
        }
        return super.onContextItemSelected(item);
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    



}