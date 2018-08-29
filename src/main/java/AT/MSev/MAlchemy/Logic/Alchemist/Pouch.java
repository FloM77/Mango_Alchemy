package AT.MSev.MAlchemy.Logic.Alchemist;

import java.util.ArrayList;

public class Pouch {
    public ArrayList<Ingredient> Contents = new ArrayList<Ingredient>();

    public void Add(Ingredient ingredient)
    {
        Boolean added = false;
        for (Ingredient ing:
             Contents) {
            if(ing.Family == ingredient.Family)
            {
                ing.Amount += ingredient.Amount;
                added = true;
            }
        }

        if(!added)
        {
            Contents.add(ingredient);
        }
    }

    public Boolean Contains(ArrayList<Ingredient> ingredients)
    {
        return Contents.containsAll(ingredients);
    }

    public void Remove(Ingredient ingredient)
    {
        for (Ingredient ing:
             Contents) {
            if(ing.Family == ingredient.Family)
            {
                ing.Amount -= ingredient.Amount;
            }
        }
    }

    public int GetAmount(Ingredient.Ingredients family)
    {
        for (Ingredient ing:
             Contents) {
            if(ing.Family == family)
            {
                return ing.Amount;
            }
        }
        return 0;
    }
}
