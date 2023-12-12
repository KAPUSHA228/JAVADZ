package com.example.demo;

import com.google.gson.*;

import java.lang.reflect.Type;

public class ClockAdapter implements JsonSerializer<Clock>, JsonDeserializer<Clock> {
    @Override
    public JsonElement serialize(Clock clock, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("hour", clock.toGet_Hour());
        jsonObject.addProperty("min", clock.toGet_Min());
        jsonObject.addProperty("cost", clock.toGet_Cost());
        jsonObject.addProperty("mark", clock.toGet_Mark());
        jsonObject.addProperty("id", clock.toGet_ID());
        return jsonObject;
    }

    @Override
    public Clock deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        int hour = jsonObject.get("hour").getAsInt();
        int min = jsonObject.get("min").getAsInt();
        int cost = jsonObject.get("cost").getAsInt();
        String mark = jsonObject.get("mark").getAsString();
        int id = jsonObject.get("ID").getAsInt();
        return new Clock( mark, cost, hour, min, id);
    }
}