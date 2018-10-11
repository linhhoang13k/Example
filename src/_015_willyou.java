package Arcade_Core;

public class _015_willyou {
    boolean willYou(boolean young, boolean beautiful, boolean loved) {
        return
                (
                        (young && beautiful && !loved) ||
                                (loved && !young) ||
                                (loved && !beautiful)
                );
    }
}
