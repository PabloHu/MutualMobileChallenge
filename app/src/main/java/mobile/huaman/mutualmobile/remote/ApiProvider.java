package mobile.huaman.mutualmobile.remote;


import io.reactivex.Observable;
import mobile.huaman.mutualmobile.model.modelrecipeapi.RecipeResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pablo on 11/28/2017.
 */

public class ApiProvider {
    private static final String BASE_URL_GIPHY = "https://api.edamam.com/";

    public static Retrofit create() {


        //looging interceptor would log the request and response of the network call
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL_GIPHY)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /*
    public static Observable<PokemonEvolutionChainResponse> getPokemonObs(String pokemon) {
        Retrofit retrofit = create();
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService.getPokemonEvolutionChainResponse(pokemon);
    }
*/

    public static Observable<RecipeResponse> getRecipeResponse (String recipeSearch) {
        Retrofit retrofit = create();
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService.getRecipeResponse(recipeSearch, "e124706a", "581332a6fc9bf6939343b66770f38718");
    }
}
