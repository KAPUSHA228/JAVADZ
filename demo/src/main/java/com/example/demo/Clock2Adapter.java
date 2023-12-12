package com.example.demo;

import com.google.gson.*;

import java.lang.reflect.Type;

public class Clock2Adapter implements JsonSerializer<Clock2>, JsonDeserializer<Clock2> {
    @Override
    public JsonElement serialize(Clock2 clock, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("hour", clock.toGet_Hour());
        jsonObject.addProperty("min", clock.toGet_Min());
        jsonObject.addProperty("sec", clock.toGet_Sec());
        jsonObject.addProperty("cost", clock.toGet_Cost());
        jsonObject.addProperty("mark", clock.toGet_Mark());
        jsonObject.addProperty("ID", clock.toGet_ID());
        return jsonObject;
    }

    @Override
    public Clock2 deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        int hour = jsonObject.get("hour").getAsInt();
        int min = jsonObject.get("min").getAsInt();
        int sec = jsonObject.get("sec").getAsInt();
        int cost = jsonObject.get("cost").getAsInt();
        String mark = jsonObject.get("mark").getAsString();
        int id = jsonObject.get("ID").getAsInt();
        return new Clock2(mark, cost,hour, min, sec,id);
    }
}