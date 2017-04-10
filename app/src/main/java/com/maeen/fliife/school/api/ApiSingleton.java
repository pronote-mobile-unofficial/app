package com.maeen.fliife.school.api;

import android.content.Context;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.concurrent.TimeUnit;

/**
 * @author fliife
 * @since 29/03/17
 */
public class ApiSingleton {
    private static ApiSingleton mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private ApiSingleton(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized ApiSingleton getInstance(Context context) {
        //Create instance if needed.
        if (mInstance == null) {
            mInstance = new ApiSingleton(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // Get application's context in order not to make tons of different instances
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        //Disable caching, since the data will change on each request
        req.setShouldCache(false);
        req.setRetryPolicy(new DefaultRetryPolicy((int) TimeUnit.SECONDS.toMillis(45), 0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //Add the request to queue
        getRequestQueue().add(req);
    }
}
