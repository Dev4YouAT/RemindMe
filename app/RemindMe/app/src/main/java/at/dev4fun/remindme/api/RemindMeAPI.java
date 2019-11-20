package at.dev4fun.remindme.api;

import at.dev4fun.remindme.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RemindMeAPI {

    @FormUrlEncoded
    @POST("login")
    Call<User> makeLogin(@Field("username") String username, @Field("password") String password);

}
