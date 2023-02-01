package ua.com.illia;

import java.util.Collection;
import java.util.Set;

public class DictionaryInterface {
    Dictionary dictionary;

    public void start() {
        System.out.println("                ------------------------------------");
        System.out.println("----------------------DICTIONARY'S METHODS DEMO----------------------------");
        System.out.println("                ------------------------------------");
        createDictionary();
        updateDictionary();
        getSize();
        checkIsEmpty();
        keyExist();
        valueExists();
        getValue();
        getAllKeys();
        getAllValues();
        removeValue();
        clearDictionary();
    }

    public void createDictionary() {
        dictionary = new Dictionary();
        System.out.println("------PUT------");
        System.out.println("Number --- Auto");
        System.out.println();
        System.out.println("Pair 1 -----> AX3486IT --- Toyota Land Cruiser");
        System.out.println("Pair 2 -----> BA5478BO --- Skoda Fabia");
        System.out.println("Pair 3 -----> AA0000BP --- Lincoln");
        dictionary.put("AX3486IT", "Toyota Land Cruiser");
        dictionary.put("BA5478BO", "Skoda Fabia");
        dictionary.put("AA0000BP", "Lincoln");
        System.out.println();
        System.out.println("---PUT--- Result: " + dictionary.toString());
        System.out.println(".....................................................");
        System.out.println();
    }

    public void updateDictionary() {
        System.out.println("------UPDATE------");
        System.out.println("Current " + dictionary);
        System.out.println();
        System.out.println("Put -----> BI5578IA --- Daewoo Lanos");
        System.out.println("Put -----> AI7865EP --- Lada Kalina");
        System.out.println();
        dictionary.put("BI5578IA", "Daewoo Lanos");
        dictionary.put("AI7865EP", "Lada Kalina");
        System.out.println("---UPDATE--- Result: " + dictionary.toString());
        System.out.println(".....................................................");
        System.out.println();
    }

    public void checkIsEmpty() {
        System.out.println("------IS EMPTY------");
        System.out.println();
        Dictionary newEmptyDictionary = new Dictionary();
        System.out.println("Current Dictionary " + dictionary);
        System.out.println("Is Empty? -----> " + dictionary.isEmpty());
        System.out.println();
        System.out.println("Empty Dictionary -----> " + newEmptyDictionary);
        System.out.println("Is Empty? -----> " + newEmptyDictionary.isEmpty());
        System.out.println(".....................................................");
        System.out.println();
    }

    public void getSize() {
        System.out.println("------GET SIZE------");
        System.out.println();
        Dictionary newEmptyDictionary = new Dictionary();
        System.out.println("Current Dictionary size -----> " + dictionary.size());
        System.out.println("New Empty Dictionary size -----> " + newEmptyDictionary.size());
        System.out.println(".....................................................");
        System.out.println();
    }

    public void getAllKeys() {
        System.out.println("------GET ALL KEYS------");
        System.out.println();
        System.out.println("Current Dictionary -----> " + dictionary);
        Set set = dictionary.keySet();
        System.out.println();
        System.out.println("All Keys -----> " + set.toString());
        System.out.println(".....................................................");
        System.out.println();
    }

    public void getAllValues() {
        System.out.println("------GET ALL VALUES------");
        System.out.println();
        System.out.println("Current Dictionary -----> " + dictionary);
        Collection valuesAll = dictionary.values();
        System.out.println();
        System.out.println("All values: " + valuesAll.toString());
        System.out.println(".....................................................");
        System.out.println();
    }

    public void getValue() {
        System.out.println("------GET VALUE------");
        System.out.println();
        System.out.println("Current Dictionary -----> " + dictionary);
        System.out.println();
        String key = "AA0000BP";
        String value = (String) dictionary.get(key);
        System.out.println("Value by key '" + key + "' -----> " + value);
        System.out.println(".....................................................");
        System.out.println();
    }

    public void keyExist() {
        System.out.println("------CONTAINS KEY OR NOT------");
        System.out.println();
        System.out.println("Current Dictionary -----> " + dictionary);
        System.out.println();
        String keyContains = "AX3486IT";
        String keyWrong = "KROKOZIABRA";
        System.out.println("Exist key is -----> " + keyContains);
        System.out.println("Wrong key is -----> " + keyWrong);
        System.out.println();
        System.out.println("Is Exist Key real? -----> " + dictionary.containsKey(keyContains));
        System.out.println("Is Wrong Key real? -----> " + dictionary.containsKey(keyWrong));
        System.out.println(".....................................................");
        System.out.println();
    }

    public void valueExists() {
        System.out.println("------CONTAINS VALUE OR NOT------");
        System.out.println();
        System.out.println("Current Dictionary -----> " + dictionary);
        System.out.println();
        String valueContains = "Toyota Land Cruiser";
        String valueWrong = "KROKOZIABRA";
        System.out.println("Exist Value is -----> " + valueContains);
        System.out.println("Wrong Value is -----> " + valueWrong);
        System.out.println();
        System.out.println("Is Exist Value real? -----> " + dictionary.containsValue(valueContains));
        System.out.println("Is Wrong Value real? -----> " + dictionary.containsValue(valueWrong));
        System.out.println(".....................................................");
        System.out.println();
    }

    public void removeValue() {
        System.out.println("------REMOVE VALUE BY KEY------");
        System.out.println();
        System.out.println("Current Dictionary -----> " + dictionary);
        System.out.println();
        String key = "AI7865EP";
        System.out.println("Key for Remove -----> " + key);
        dictionary.remove(key);
        System.out.println();
        System.out.println("Dictionary Without Value by key '" + key + "' -----> " + dictionary);
        System.out.println(".....................................................");
        System.out.println();
    }

    public void clearDictionary() {
        System.out.println("------CLEAR ALL------");
        System.out.println();
        System.out.println("Current Dictionary -----> " + dictionary);
        System.out.println();
        dictionary.clear();
        System.out.println("Result -----> " + dictionary);
        System.out.println(".....................................................");
        System.out.println();
        System.out.println();
        System.out.println("===THANK YOU)))===THANK YOU)))===THANK YOU)))===THANK YOU)))===THANK YOU)))===THANK YOU)))===");
    }

}
