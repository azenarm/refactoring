package edu.sharif.pricePolicy;

public class PeakPricePolicy implements PricePolicy {

    public static final PeakPricePolicy INSTANCE = new PeakPricePolicy();

    @Override
    public int price(int energy) {
        return 1000 * energy;
    }
}
