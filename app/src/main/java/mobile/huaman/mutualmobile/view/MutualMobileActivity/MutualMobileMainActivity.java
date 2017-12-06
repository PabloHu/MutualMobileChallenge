package mobile.huaman.mutualmobile.view.MutualMobileActivity;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;

import java.util.List;

import mobile.huaman.mutualmobile.CustomAdapter;
import mobile.huaman.mutualmobile.R;
import mobile.huaman.mutualmobile.model.modelrecipeapi.Recipe;
import mobile.huaman.mutualmobile.model.modelrecipeapi.RecipeResponse;

public class MutualMobileMainActivity extends AppCompatActivity implements  MutualMobileContract.View{
    GridView gridView;
    SearchView svSearchRecipe;
    private static final String TAG ="MainActivity" ;
    MutualMobilePresenter mutualMobilePresenter = new MutualMobilePresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mutualMobilePresenter.attachView(this);


        svSearchRecipe = (SearchView) findViewById(R.id.svSearchRecipe);



        // svSearchRecipe.setLayoutParams(new ActionBar.LayoutParams(Gravity.RIGHT));
        svSearchRecipe.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                mutualMobilePresenter.getRecipeList(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });


     //   mutualMobilePresenter.getRecipeList("Chicken Satay");
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void updateRecipeList(List<Recipe> recipeList) {
        String[] numbers = new String[recipeList.size()];
        for (int i = 0; i < recipeList.size(); i++) {
            numbers[i]=recipeList.get(i).getImage();
        }
        gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(new CustomAdapter(this, recipeList));
        /*
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
            }
        });
        */



        Log.d(TAG, "updateRecipeList: "+recipeList.size());

        for (int i = 0; i < recipeList.size(); i++) {
            Log.d(TAG, "updateRecipeList: "+recipeList.get(i).getLabel());
            Log.d(TAG, "updateRecipeList: "+recipeList.get(i).getSource());
            Log.d(TAG, "updateRecipeList: "+recipeList.get(i).getImage());
            for (int j = 0; j < recipeList.get(i).getIngredients().size(); j++) {
                Log.d(TAG, "updateRecipeList: "+recipeList.get(i).getIngredients().get(j).getText());
            }
        }

    }

    @Override
    public void updateTest(String something) {

        Log.d(TAG, "updateTest: "+something);
    }
}
