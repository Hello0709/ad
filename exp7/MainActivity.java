package com.example.exp7;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;//handle data passed between activities
import com.denzcoskun.imageslider.ImageSlider;//main class for creating image slider
import com.denzcoskun.imageslider.constants.ScaleTypes;//options how to scale images within slider
import com.denzcoskun.imageslider.models.SlideModel;//singe image within slider
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    @Override // indicates that this method overrides a method from the parent class (AppCompatActivity).
    protected void onCreate(Bundle savedInstanceState) {//it is called when activity is first created
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageSlider slider=findViewById(R.id.slider1);//this line finds the view with the ID slider1 from the layout (presumably the image slider component). It stores the reference in the slider variable for further use.
        List<SlideModel> slideModelList=new ArrayList<>();//This line creates a new list object of type List<SlideModel>. It will be used to store the data for each image slide.
        slideModelList.add(new SlideModel(R.drawable.s1,"1",
                ScaleTypes.FIT));
        slideModelList.add(new SlideModel(R.drawable.s2,"2",
                ScaleTypes.FIT));// This specifies how the image should be scaled within the slider (FIT ensures the entire image is visible).
        slider.setImageList(slideModelList);

    }
}