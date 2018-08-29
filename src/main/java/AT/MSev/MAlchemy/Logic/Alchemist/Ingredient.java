package AT.MSev.MAlchemy.Logic.Alchemist;

public class Ingredient {
    public enum Ingredients { Silverberry }
    public Ingredients Family;
    public int Amount;

    public Ingredient(Ingredients family, int amount)
    {
        Family = family;
        Amount = amount;
    }
}
