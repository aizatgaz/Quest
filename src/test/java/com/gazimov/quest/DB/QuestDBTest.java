package com.gazimov.quest.DB;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuestDBTest {

    @Test
    void testShouldReturnMaps() {
        Map<String, QuestDB.Pair> expectedQuests = new HashMap<>();
        expectedQuests.put("Ты потерял память. Принять вызов НЛО?", new QuestDB.Pair("Принять вызов", "Отклонить вызов"));
        expectedQuests.put("Ты отклонил вызов. Поражение", null);
        expectedQuests.put("Ты принял вызов. Поднимешься на мостик к капитану?", new QuestDB.Pair("Подняться на мостик", "Отказаться подняться на мостик"));
        expectedQuests.put("Ты не пошёл на переговоры. Поражение", null);
        expectedQuests.put("Ты поднялся на мостик. \"Ты кто?\"", new QuestDB.Pair("Рассказать правду о себе", "Солгать о себе"));
        expectedQuests.put("Тебя вернули домой. Победа", null);
        expectedQuests.put("Твою ложь разоблачили. Поражение", null);

        Map<String, String> expectedAnswers = new HashMap<>();
        expectedAnswers.put("Принять вызов", "Ты принял вызов. Поднимешься на мостик к капитану?");
        expectedAnswers.put("Отклонить вызов", "Ты отклонил вызов. Поражение");
        expectedAnswers.put("Подняться на мостик", "Ты поднялся на мостик. \"Ты кто?\"");
        expectedAnswers.put("Отказаться подняться на мостик", "Ты не пошёл на переговоры. Поражение");
        expectedAnswers.put("Рассказать правду о себе", "Тебя вернули домой. Победа");
        expectedAnswers.put("Солгать о себе", "Твою ложь разоблачили. Поражение");

        Map<String, String> expectedLongQuests = new HashMap<>();
        expectedLongQuests.put("Ты потерял память. Принять вызов НЛО?", "После недолгой прогулки, ты натолкнулся на НЛО, экипаж этого объекта, " +
                "почти было не отличить от человека, если бы у них не было трёх антенн на голове. Видимо они тебя заметили. Через " +
                "пару секунд, вооружённое существо позвало тебя к себе.");
        expectedLongQuests.put("Ты отклонил вызов. Поражение", "Развернувшись, ты побежал из-за всех сил, НО лазеры бластера смогли тебя догнать");
        expectedLongQuests.put("Ты принял вызов. Поднимешься на мостик к капитану?", "После того как тебя завели на корабль, тебе приказали " +
                "идти поговорить к капитану, но охрана отвлеклась и появился шанс ускользнуть в помещение по-типу кладовой.");
        expectedLongQuests.put("Ты не пошёл на переговоры. Поражение", "Охрана узнав, что ты сбежал, приказала найти тебя живым или мёртвым.");
        expectedLongQuests.put("Ты поднялся на мостик. \"Ты кто?\"", "Перед тобой стоит один из самых умных существ во вселенных и спрашивает, " +
                "кто ты и что ты забыл на его планете?");
        expectedLongQuests.put("Тебя вернули домой. Победа", "Ты рассказал, что ничего не помнишь и капитан умеющий читать мысли и " +
                "распознавать ложь вернул тебя домой.");
        expectedLongQuests.put("Твою ложь разоблачили. Поражение", "Ты соврал, что ты один из дефектных пришельцев без антенн, но " +
                "капитан знает, что такие долго не живут.");

        assertEquals(expectedQuests, new QuestDB().getQuests());
        assertEquals(expectedAnswers, new QuestDB().getAnswers());
        assertEquals(expectedLongQuests, new QuestDB().getLongQuests());
    }

    @Test
    void testShouldReturnPairStrings() {
        Map<String, QuestDB.Pair> expectedQuests = new HashMap<>();
        expectedQuests.put("Ты потерял память. Принять вызов НЛО?", new QuestDB.Pair("Принять вызов", "Отклонить вызов"));
        expectedQuests.put("Ты отклонил вызов. Поражение", null);
        expectedQuests.put("Ты принял вызов. Поднимешься на мостик к капитану?", new QuestDB.Pair("Подняться на мостик", "Отказаться подняться на мостик"));
        expectedQuests.put("Ты не пошёл на переговоры. Поражение", null);
        expectedQuests.put("Ты поднялся на мостик. \"Ты кто?\"", new QuestDB.Pair("Рассказать правду о себе", "Солгать о себе"));

        for (Map.Entry<String, QuestDB.Pair> entry : expectedQuests.entrySet()) {
            if (entry.getValue() != null) {
                assertEquals(expectedQuests.get(entry.getKey()).getString1(), new QuestDB().getQuests().get(entry.getKey()).getString1());
                assertEquals(expectedQuests.get(entry.getKey()).getString2(), new QuestDB().getQuests().get(entry.getKey()).getString2());
            }
        }


    }
}