package py.edu.drakefor.op2final;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by LUIS on 02/11/2016.
 */
public interface BatmanInteface {

    @GET("/?s=Batman")

    void getBatman(Callback<Result> callback);


}


