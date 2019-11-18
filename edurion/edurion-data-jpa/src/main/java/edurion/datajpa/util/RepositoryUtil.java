package edurion.datajpa.util;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class RepositoryUtil {

    public static <T> Stream<T> toStream(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
