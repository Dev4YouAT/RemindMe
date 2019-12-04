package at.dev4fun.remindme.api;

import at.dev4fun.remindme.models.Reminder;
import at.dev4fun.remindme.models.User;
import at.dev4fun.remindme.reponses.BaseReponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RemindMeAPI {

    @GET("reminders")
    Call<Reminder[]> getReminders(@Query("id") String userID);

    @FormUrlEncoded
    @POST("login")
    Call<User> makeLogin(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<BaseReponse> makeRegistration(@Field("username") String username, @Field("password") String password);
}
