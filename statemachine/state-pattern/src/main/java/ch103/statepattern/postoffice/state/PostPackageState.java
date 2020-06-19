package ch103.statepattern.postoffice.state;

import ch103.statepattern.postoffice.context.PostPackage;

public interface PostPackageState {
    void next(PostPackage postPackage);

    void prev(PostPackage postPackage);

    void printStatus();
}
