package com.jard.testretrofit.restApi;

/**
 * Created by jarodrig on 01/06/2017.
 */

/**
 * Generar esta API
 * https://api.instagram.com/v1/users/{user_id}/media/recent/?access_token=ACCESS_TOKEN
 * https://api.instagram.com/v1/users/5518916073/media/recent/?access_token=5518916073.eb42f98.b2b27f4ef61a4b919f06c8d5187e58b1
 */
public final class RestApiConstant {
    public final static String ACCESS_TOKEN         = "5518916073.eb42f98.b2b27f4ef61a4b919f06c8d5187e58b1";
    public final static String ROOT_BASE            = "https://api.instagram.com/";
    public final static String VERSION              = "v1/";
    public final static String MEDIA_BASE           = "users/{user_id}/media/recent/";
    public final static String QUERY_BASE           = "?access_token=";
    public final static String ROOT_URL             = ROOT_BASE + VERSION;
    public final static String URL_MEDIA            = MEDIA_BASE + QUERY_BASE + ACCESS_TOKEN;
}
