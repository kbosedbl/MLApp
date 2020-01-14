package com.example.machinelearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.igalata.bubblepicker.BubblePickerListener;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BubblePicker bubblePicker;
    int a=Color.parseColor("#FFFFFF");
    String name[]={"QR-Code Scanner","Text-Recognition"};
    int colors[]={Color.parseColor("#E70D24"),Color.parseColor("#180DE7")};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bubblePicker=findViewById(R.id.picker);
        ArrayList<PickerItem> arrayList=new ArrayList<>();
        for(int i=0;i<name.length;i++)
        {
            PickerItem item=new PickerItem();
            item.setTitle(name[i]);
            item.setColor(colors[i]);
            item.setTextColor(a);
            item.setTextSize(Float.valueOf("30.5"));
            arrayList.add(item);
        }
        bubblePicker.setItems(arrayList);
        bubblePicker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(@NotNull PickerItem item) {
                String str=item.getTitle();
                if(str.equals("Text-Recognition")) {
                    Intent intent = new Intent(MainActivity.this, TextRecognition.class);
                    startActivity(intent);
                }
                /*if(str.equals("Image-Labelling")) {
                    Intent intent = new Intent(MainActivity.this, FaceDetection.class);
                    startActivity(intent);
                }*/
                if(str.equals("QR-Code Scanner")) {
                    Intent intent = new Intent(MainActivity.this, BarCode.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onBubbleDeselected(@NotNull PickerItem item) {

            }
        });
    }
}
