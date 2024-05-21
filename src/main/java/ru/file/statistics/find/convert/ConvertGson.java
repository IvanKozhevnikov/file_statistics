package ru.file.statistics.find.convert;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.file.statistics.find.model.FileStatistic;

public class ConvertGson {

    public void convertGson(FileStatistic responce) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(responce);
        System.out.println(json);
}

}
