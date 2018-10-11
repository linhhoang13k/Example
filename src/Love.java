package exercise15;

public class Love {

    public boolean willYou(boolean young, boolean beautiful, boolean loved) {
        boolean shouldBeLoved = young && beautiful;
        return shouldBeLoved != loved;
    }
}
