package com.jard.testretrofit.restApi.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.jard.testretrofit.pojo.Foto;
import com.jard.testretrofit.restApi.JsonKeys;
import com.jard.testretrofit.restApi.model.MediaResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * Created by jarodrig on 01/06/2017.
 */

public class MediaDeserializer implements JsonDeserializer<MediaResponse> {
    @Override
    public MediaResponse deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Gson gson = new Gson();
        MediaResponse mediaResponse = gson.fromJson(jsonElement, MediaResponse.class);
        JsonArray mediaResponseData = jsonElement.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_DATA);
        mediaResponse.setFotos(deserializerMediaJson(mediaResponseData));

        return  mediaResponse;
    }

    private ArrayList<Foto> deserializerMediaJson(JsonArray mediaResponseData){
        ArrayList<Foto> fotos= new ArrayList<>();
        for(int i = 0; i < mediaResponseData.size(); i++){
            JsonObject mediaJSon = mediaResponseData.get(i).getAsJsonObject();
            String nombre = "";
            int cuenta = 0;
            String urlFoto = "";
            String id = "";

            id = mediaJSon.get(JsonKeys.IMAGE_ID).getAsString();
            if (mediaJSon.get(JsonKeys.IMAGE_CAPTION_OBJECT).isJsonNull())
                nombre = "";
            else {
                JsonObject captionJSon = mediaJSon.get(JsonKeys.IMAGE_CAPTION_OBJECT).getAsJsonObject();
                nombre = captionJSon.get(JsonKeys.IMAGE_CAPTION_TEXT).getAsString();
            }
            JsonObject imageJSon = mediaJSon.get(JsonKeys.IMAGES_OBJECT).getAsJsonObject();
            JsonObject imageStd = imageJSon.get(JsonKeys.IMAGES_STDR_OBJECT).getAsJsonObject();
            urlFoto = imageStd.get(JsonKeys.IMAGES_URL).getAsString();
            JsonObject likeJSon = mediaJSon.get(JsonKeys.LIKE_OBJECT).getAsJsonObject();
            cuenta = likeJSon.get(JsonKeys.LIKE_COUNT).getAsInt();
            Foto foto = new Foto(id, nombre, cuenta, urlFoto);
            fotos.add(foto);
        }
        return fotos;
    }
}
