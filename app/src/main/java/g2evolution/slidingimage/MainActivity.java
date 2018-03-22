package g2evolution.slidingimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageSliderFragment fragment4 = new ImageSliderFragment();


        android.support.v4.app.FragmentTransaction fragmentTransaction4 =
                getSupportFragmentManager().beginTransaction();

        fragmentTransaction4.replace(R.id.fragment_container, fragment4);

        fragmentTransaction4.commit();

    }
}
