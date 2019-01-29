package info.example.com.finddevicedensity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final double LDPI_VALUE = 0.75;
    private static final double MDPI_VALUE = 1.0;
    private static final double HDPI_VALUE = 1.5;
    private static final double XHDPI_VALUE = 2.0;
    private static final double XXHDPI_VALUE = 3.0;
    private static final double XXXHDPI_VALUE = 4.0;
    private static final String LDPI = "LDPI";
    private static final String MDPI = "MDPI";
    private static final String HDPI = "HDPI";
    private static final String XHDPI = "XHDPI";
    private static final String XXHDPI = "XXHDPI";
    private static final String XXXHDPI = "XXXHDPI";
    private static final String NOT_FOUND = "Not found";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        // Finish the activity on click of close
        findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView densityText = findViewById(R.id.tv_density);
        densityText.setText("This device density is : " + getDensityByDpi());
    }

    /**
     * Find density by using density variable from displayMetrics
     *
     * @return
     */
    private String getDensity() {
        double density = getResources().getDisplayMetrics().density;

        Log.d("FindDensity", "density is " + density);

        if (density == LDPI_VALUE) {
            return LDPI;
        } else if (density == MDPI_VALUE) {
            return MDPI;
        } else if (density == HDPI_VALUE) {
            return HDPI;
        } else if (density == XHDPI_VALUE) {
            return XHDPI;
        } else if (density == XXHDPI_VALUE) {
            return XXHDPI;
        } else if (density == XXXHDPI_VALUE) {
            return XXXHDPI;
        }
        return NOT_FOUND;
    }

    /**
     * Find density by using dpi
     *
     * @return
     */
    private String getDensityByDpi() {
        switch (getResources().getDisplayMetrics().densityDpi) {
            case DisplayMetrics.DENSITY_LOW:
                return LDPI;
            case DisplayMetrics.DENSITY_MEDIUM:
                return MDPI;
            case DisplayMetrics.DENSITY_HIGH:
                return HDPI;
            case DisplayMetrics.DENSITY_260:
            case DisplayMetrics.DENSITY_280:
            case DisplayMetrics.DENSITY_300:
            case DisplayMetrics.DENSITY_XHIGH:
                return XHDPI;
            case DisplayMetrics.DENSITY_340:
            case DisplayMetrics.DENSITY_360:
            case DisplayMetrics.DENSITY_400:
            case DisplayMetrics.DENSITY_420:
            case DisplayMetrics.DENSITY_440:
            case DisplayMetrics.DENSITY_XXHIGH:
                return XXHDPI;
            case DisplayMetrics.DENSITY_560:
            case DisplayMetrics.DENSITY_XXXHIGH:
                return XXXHDPI;
            default:
                return NOT_FOUND;
        }
    }
}
