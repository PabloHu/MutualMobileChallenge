package mobile.huaman.mutualmobile.remote;



import io.reactivex.Observable;
import mobile.huaman.mutualmobile.model.modelrecipeapi.RecipeResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Pablo on 11/28/2017.
 */

public interface ApiService {

    //@GET("evolution-chain/{id}")
    // Observable<PokemonEvolutionChainResponse> getPokemonEvolutionChainResponse(@Path("id")String pokemon);

   // @GET("pokemon/?limit=801&offset=0")
   // Observable<PokemonListResponse> getPokemonListResponse();

    //@GET("pokemon/?limit=356&offset=0")
    //Observable<PokemonListResponse> getPokemonListResponse();


 //   @GET("search?q={recipeSearch}&app_id=e124706a&app_key=581332a6fc9bf6939343b66770f38718")
 //   Observable<RecipeResponse> getRecipeResponse(@Path("recipeSearch")String recipeSearch);


    @GET("search?")
    Observable<RecipeResponse> getRecipeResponse(
            @Query("q") String search, @Query("app_id") String app_id, @Query("app_key") String app_key);

    //@GET("v1/gifs/random?")
    //Observable<RecipeResponse> getRecipeResponse(
     //       @Query("api_key") String key, @Query("tag") String tag, @Query("rating") String rating);
}
