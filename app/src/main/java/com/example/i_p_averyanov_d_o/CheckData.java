package com.example.i_p_averyanov_d_o;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.i_p_averyanov_d_o.present.activities.HomeActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CheckData
{
    public  static Map<String,String> getAuthorizationHeader()
    {
        Map<String,String> auth = new HashMap<String,String>();
        auth.put("Authorization", "Token " + User.getCurrentUser().getToken());
        return  auth;
    }
    public static boolean checkMail(String mail) {
       return mail.matches("[a-z0-9]+@[a-z0-9]+.[a-z]{1,3}");
        }

        public static void makeMessage(String message, Context context) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Ошибка");
            builder.setMessage(message);
            builder.show();
//            new AlertDialog.Builder(context)
//                    .setTitle("Ошибка")
//                    .setMessage(message)
//                    .show();
        }
        public static void authConfirmed(final Activity activity, String email, String password )
        {
            final JSONObject data = new JSONObject();
            final JSONObject userdata = new JSONObject();

            try {
                data.put(User.EMAIL, email);
                data.put(User.PASSWORD, password);

              //  data.put("user", userdata);



            } catch (JSONException e) {
                e.printStackTrace();
            }


            JsonObjectRequest logonRequest = new JsonObjectRequest(Request.Method.POST,
                    URLs.LOGIN, data, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) { Log.d("Response", response.toString());
                    try {
                        JSONObject userObj = response.getJSONObject("user");
                        User.getCurrentUser().setToken(userObj.getString("token"));
                        User.getCurrentUser().setId(userObj.getString(User.ID));

                        Intent intent = new Intent(activity, HomeActivity.class);
                        loadedBasketId(activity.getApplicationContext());
//                        intent.putExtra(User.EMAIL, email);
                        activity.startActivity(intent);
                        activity.finish();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    makeMessage(error.getMessage(), activity);
                }
            });

//            AppData.getInstance(activity).queue.add(logonRequest);
            Volley.newRequestQueue(activity).add(logonRequest);
        }

    private static  void loadedBasketId(Context context) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URLs.BASKET_USER, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response.length() > 0) {
                    try {
                        JSONObject basket = response.getJSONObject(0);
                        User.getCurrentUser().basketId = basket.getString("_id");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return CheckData.getAuthorizationHeader();
            }
        };
        AppData.getInstance(context).queue.add(jsonArrayRequest);

    }

    public static String returnStringPrice(double price) {
       return price+"₽";
    }
//    public  static  void openMovie(Activity activity, String movieId)
//    {
//        Intent movie = new Intent(activity, MovieScreen.class);
//        movie.putExtra(MovieItem.MOVIE_ID,movieId);
//        activity.startActivity(movie);
//    }
}

//
//        public  static  void openMovie(Activity activity, String movieId)
//        {
//            Intent movie = new Intent(activity, HomeActivity.class);
//            movie.putExtra(MovieItem.MOVIE_ID,movieId);
//            activity.startActivity(movie);
//        }

