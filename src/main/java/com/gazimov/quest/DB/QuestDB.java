package com.gazimov.quest.DB;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class QuestDB {
    private final Map<String, Pair> quests = new HashMap<>();
    private final Map<String, String> answers = new HashMap<>();
    private final Map<String, String> longQuests = new HashMap<>();


    {
        quests.put("Ты потерял память. Принять вызов НЛО?", new Pair("Принять вызов", "Отклонить вызов"));
        quests.put("Ты отклонил вызов. Поражение", null);
        quests.put("Ты принял вызов. Поднимешься на мостик к капитану?", new Pair("Подняться на мостик", "Отказаться подняться на мостик"));
        quests.put("Ты не пошёл на переговоры. Поражение", null);
        quests.put("Ты поднялся на мостик. \"Ты кто?\"", new Pair("Рассказать правду о себе", "Солгать о себе"));
        quests.put("Тебя вернули домой. Победа", null);
        quests.put("Твою ложь разоблачили. Поражение", null);


        answers.put("Принять вызов", "Ты принял вызов. Поднимешься на мостик к капитану?");
        answers.put("Отклонить вызов", "Ты отклонил вызов. Поражение");
        answers.put("Подняться на мостик", "Ты поднялся на мостик. \"Ты кто?\"");
        answers.put("Отказаться подняться на мостик", "Ты не пошёл на переговоры. Поражение");
        answers.put("Рассказать правду о себе", "Тебя вернули домой. Победа");
        answers.put("Солгать о себе", "Твою ложь разоблачили. Поражение");

        longQuests.put("Ты потерял память. Принять вызов НЛО?", "После недолгой прогулки, ты натолкнулся на НЛО, экипаж этого объекта, " +
                "почти было не отличить от человека, если бы у них не было трёх антенн на голове. Видимо они тебя заметили. Через " +
                "пару секунд, вооружённое существо позвало тебя к себе.");
        longQuests.put("Ты отклонил вызов. Поражение", "Развернувшись, ты побежал из-за всех сил, НО лазеры бластера смогли тебя догнать");
        longQuests.put("Ты принял вызов. Поднимешься на мостик к капитану?", "После того как тебя завели на корабль, тебе приказали " +
                "идти поговорить к капитану, но охрана отвлеклась и появился шанс ускользнуть в помещение по-типу кладовой.");
        longQuests.put("Ты не пошёл на переговоры. Поражение", "Охрана узнав, что ты сбежал, приказала найти тебя живым или мёртвым.");
        longQuests.put("Ты поднялся на мостик. \"Ты кто?\"", "Перед тобой стоит один из самых умных существ во вселенных и спрашивает, " +
                "кто ты и что ты забыл на его планете?");
        longQuests.put("Тебя вернули домой. Победа", "Ты рассказал, что ничего не помнишь и капитан умеющий читать мысли и " +
                "распознавать ложь вернул тебя домой.");
        longQuests.put("Твою ложь разоблачили. Поражение", "Ты соврал, что ты один из дефектных пришельцев без антенн, но " +
                "капитан знает, что такие долго не живут.");
    }

    public static class Pair {
        private final String string1;
        private final String string2;

        public Pair(String string1, String string2) {
            this.string1 = string1;
            this.string2 = string2;
        }

        public String getString1() {
            return string1;
        }

        public String getString2() {
            return string2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair pair)) return false;
            return Objects.equals(string1, pair.string1) && Objects.equals(string2, pair.string2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(string1, string2);
        }
    }

    @Override
    public String toString() {
        return "QuestDB{" +
                "quests=" + quests +
                ", answers=" + answers +
                '}';
    }

    public Map<String, Pair> getQuests() {
        return quests;
    }

    public Map<String, String> getAnswers() {
        return answers;
    }

    public Map<String, String> getLongQuests() {
        return longQuests;
    }
}
