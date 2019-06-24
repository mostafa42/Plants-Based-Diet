package com.example.asus.pbd_project2.Tips;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.asus.pbd_project2.R;

public class TipsActivity extends AppCompatActivity {
    // Array of strings...
    ListView simpleList;
    String countryList[] =
            {"1. Forget about willpower.\n" +
                    "No matter how much you want something, if you’re not sure why you’re making the change in the first place, you’ll likely fall off the wagon in a matter of weeks if not days.",
                    "2. Educate yourself (in moderation).\n" +
                            "\n" +
                            "If spending the entire weekend buried under the blankets with an entire season (or two) of Mad Men and some chocolate peanut butter cookies sounds like a good idea, binge watching documentaries addressing the big problems with our food system or environment might not.",
                    "3. Start simple and start small.\n" +
                            "\n" +
                            "Think baby steps here. Even though some of us get to run faster than others, we all learn how to walk first. So don’t rush into it.",
                    "4. Keep your health in mind.\n" +
                            "\n" +
                            "There are likely many different reasons you’ve decided to eliminate animal products from your diet. And hopefully one of them is to create a healthier version of yourself for the world and the ones you love.",
                    "5. Accept that you don’t know anything about food (yet).\n" +
                            "\n" +
                            "Proteins come from meat, milk is what your bones need, and fruits make you fat.",
                    "6. Forget it’s a diet.\n" +
                            "\n" +
                            "Diets are about calorie counting, scales, deprivation, and two to three weeks of suffering before you can go back to your cookie jar." ,
                    "7. Consider doing a cleanse.\n" +
                            "\n" +
                            "Preparing your body with a nourishing detoxification plan could be a real game-changer when it comes to transitioning. Not only will it make the shift smoother, but it will also enable your body to rid itself of old stagnant parasites and toxins and will improve overall digestion and assimilation." ,
                    "8. Don’t beat yourself up.\n" +
                            "\n" +
                            "You will make mistakes and you will eat foods you’ll probably feel bad about. If you buy the wrong product by error or want to indulge in a blue cheese platter, don’t scourge yourself. It doesn’t make you a bad person and it doesn’t make you a failure." ,
                    "9. Find support.\n" +
                            "\n" +
                            "Rest reassured: You are not alone. Whether it is online or offline, there are a gazillion groups of people out there who will be happy to help you, inspire you, and share their stories with you so you know what to expect and — most importantly — how to enjoy this new lifestyle!" ,
                    "NewZealand" ,
                    "NewZealand" ,
                    "NewZealand" ,};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        simpleList = (ListView)findViewById(R.id.simpleListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.tips_list, R.id.textView, countryList);

        simpleList.setAdapter(arrayAdapter);
    }
}
