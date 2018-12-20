package dsa.upc.edu.examendsa2;


import retrofit2.Call;

import retrofit2.http.GET;

import retrofit2.http.Path;

public interface DibaAPI {
    String BASE_URL = "https://do.diba.cat/api/dataset/municipis/format/json/pag-ini/";

    @GET("{tag}/pag-fi/{city}")
    Call<Cities> cities(@Path("tag") String tag, @Path("city") String city);


}
