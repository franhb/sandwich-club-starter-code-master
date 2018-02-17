package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = new Sandwich();
        try {

/*


{
"name":{
	"mainName":"Ham and cheese sandwich",
	"alsoKnownAs":[]
	},
"placeOfOrigin":",
"description":"A ham and cheese
            sandwich is a common type of sandwich. It is made by putting cheese and sliced ham
            between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables
            like lettuce, tomato, onion or pickle slices can also be included. Various kinds of
            mustard and mayonnaise are also
            common.",
"image":"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG",
"ingredients":["Sliced          bread",	"Cheese",	"Ham"]}
 */

            JSONObject sandwichData = new JSONObject(json);
            JSONObject sandwichName = sandwichData.getJSONObject("name");
            sandwich.setMainName(sandwichName.getString("mainName"));
            JSONArray alsoKnownArray = sandwichName.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownList = new ArrayList<>(alsoKnownArray.length());
            for (int i = 0; i < alsoKnownArray.length(); i++) {
                alsoKnownList.add(alsoKnownArray.getString(i));
            }
            sandwich.setAlsoKnownAs(alsoKnownList);
            sandwich.setPlaceOfOrigin(sandwichData.getString("placeOfOrigin"));
            sandwich.setDescription(sandwichData.getString("description"));
            sandwich.setImage(sandwichData.getString("image"));

            JSONArray ingredientsArray = sandwichData.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>(ingredientsArray.length());
            for (int i = 0; i < ingredientsArray.length(); i++) {
                ingredientsList.add(ingredientsArray.getString(i));
            }
            sandwich.setIngredients(ingredientsList);

        } catch (JSONException e) {
            e.printStackTrace();
            sandwich = null;
        }
        return sandwich;

    }
}
