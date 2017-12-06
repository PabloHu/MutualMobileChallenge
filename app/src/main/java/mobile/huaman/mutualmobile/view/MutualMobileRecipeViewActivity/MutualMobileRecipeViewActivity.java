package mobile.huaman.mutualmobile.view.MutualMobileRecipeViewActivity;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import mobile.huaman.mutualmobile.R;
import mobile.huaman.mutualmobile.model.modelrecipeapi.Recipe;
import mobile.huaman.mutualmobile.modelRecipeDisplay.ModelRecipeDisplay;

public class MutualMobileRecipeViewActivity extends AppCompatActivity {
    private static final String OBJECT_KEY = "Secret_Recipe";
    ImageView ivRecipeImage;
    TextView tvIngredients, tvSource,tvTitle,tvSourceURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutual_mobile_recipe_view);

        tvTitle =(TextView) findViewById(R.id.tvTitle);
        ivRecipeImage= (ImageView) findViewById(R.id.ivRecipeImage);
        tvIngredients =(TextView) findViewById(R.id.tvIngredients);
        tvSource =(TextView) findViewById(R.id.tvSource);
        tvSourceURL =(TextView) findViewById(R.id.tvSourceURL);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        ModelRecipeDisplay modelRecipeDisplay=  bundle.getParcelable(OBJECT_KEY);

        tvTitle.setText(modelRecipeDisplay.getTitle());
        Picasso.with(this)
                .load(modelRecipeDisplay.getRecipeImageUrl())
                //.error( R.drawable.opps )
                //  .placeholder( R.drawable.ditto_incomplete )
                .into(ivRecipeImage);

        String recipeDisplay = "";
      //  for (int i = 0; i < recipe.getIngredients().size(); i++) {
      //      recipeDisplay += recipe.getIngredients().get(i).getText().toString();
      //  }
        tvIngredients.setText(modelRecipeDisplay.getIngredients());
        tvSource.setText(modelRecipeDisplay.getSourceInfo());
        tvSourceURL.setText(modelRecipeDisplay.getUrl());
    }
}
