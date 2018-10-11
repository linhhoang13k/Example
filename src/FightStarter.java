package kru.codefight;

import kru.codefight.controller.FightController;
import kru.codefight.core.FightOutcome;
import kru.codefight.fighter.Fighter;
import kru.codefight.fighter.FighterColor;
import kru.codefight.strategy.AbstractFighterStrategy;
import kru.codefight.strategy.examples.OneTwoStrategy;
import kru.codefight.strategy.examples.SimpleConditionalStrategy;

public class FightStarter {

  private static final AbstractFighterStrategy redStrategy = new OneTwoStrategy();
  private static final AbstractFighterStrategy blueStrategy = new SimpleConditionalStrategy();

  public static void main(String[] args) {
    Fighter redFighter = new Fighter(redStrategy, FighterColor.RED);
    Fighter blueFighter = new Fighter(blueStrategy, FighterColor.BLUE);

    FightController fightClub = new FightController();
    System.out.println("Fight started!");
    FightOutcome result = fightClub.resolveFight(redFighter, blueFighter);
    System.out.println("Fight ended!");
    System.out.println(result.toString());
  }
}
