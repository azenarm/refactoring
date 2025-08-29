package edu.sharif.pricePolicy;

public class GreenPricePolicy implements PricePolicy {

    public static final GreenPricePolicy INSTANCE = new GreenPricePolicy();

    @Override
    public int price(int energy) {
        return 300 * energy;
    }
}
