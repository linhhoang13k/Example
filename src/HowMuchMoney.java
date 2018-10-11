package com.sleepsoft.tests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agermenos on 6/7/16.
 */
public class HowMuchMoney {
    double amount =0;
    float[] coins;
    int pointer=0;
    List<String> description;

    public HowMuchMoney(double v, float[] floats) {
        this.amount = v;
        this.coins = floats;
        pointer = floats.length;
        description = new ArrayList<>(pointer);
    }

    public void getCoins(){
        description.add((int)(amount/coins[coins.length-pointer]) + " of currency " + coins[coins.length-pointer]);
        amount=amount%(coins[coins.length-pointer]);
        if (--pointer > 0) getCoins();
        else return;
    }

    public static void main(String args[]) {
        HowMuchMoney howMuchMoney = new HowMuchMoney(3257.29, new float[]{20, 10, 5, 1, .25f, .10f, .5f, .01f});
        howMuchMoney.getCoins();
        howMuchMoney.description.stream().forEach(coin ->{
            System.out.println(coin);
        });
    }
}
