package djurspelet;


public class Chicken extends Food {

    public Chicken(int weightinkgs) {
        super(weightinkgs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int getKGFoodPrice() {
        return 20;
    }
}
