package ch103.statepattern.postoffice;

import ch103.statepattern.postoffice.context.PostPackage;

/*
 * A Context class has an associated State which is going to change during program execution.
 * Our context is going to delegate the behavior to the state implementation
 */
public class Main {

    public static void main(String[] args) {

        final PostPackage pkg = new PostPackage();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();
    }
}
