package ch103.statepattern.postoffice.state;

import ch103.statepattern.postoffice.context.PostPackage;

public class OrderedState implements PostPackageState {
    @Override
    public void next(final PostPackage postPackage) {
        postPackage.setState(new DeliveredState());
    }

    @Override
    public void prev(final PostPackage postPackage) {
        System.out.println("The package is in its root state.");
    }

    @Override
    public void printStatus() {
        System.out.println("Package ordered, not delivered to the office yet.");
    }
}
