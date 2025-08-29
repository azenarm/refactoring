package edu.sharif.pricePolicy;

public class StandardPricePolicy implements PricePolicy {

    public static final StandardPricePolicy INSTANCE = new StandardPricePolicy();

    @Override
    public int price(int energy) {
        return 500 * energy;
    }
}
