import components.sequence.Sequence;

/**
 * Enhanced Interface.
 */
public interface Library extends Librarykernel {
    /**
     * Updates the finished status of the book with the given title. to removi g
     * the old value and re-adding with updated data — the Map pattern for
     * mutating a value in place.
     *
     * @param title
     *            the title (key) of the book to update
     * @param finished
     *            the new finished status
     * @requires title is a key in Library
     * @ensures the value stored under title now has finished = {@code finished}
     */
    void isDone(String title, boolean finished);

    /**
     * Returns a {@code Sequence} of all titles sorted alphabetically.
     *
     * @return new Sequence of titles in alphabetical order
     * @ensures result has the keys of Library
     */
    Sequence<String> sortedByTitle();

    /**
     * Returns a {@code Sequence} of all titles sorted by word count, first. T
     * es broken alphabetically by title.
     *
     * @return new Sequence of titles ordered by ascending word count
     * @ensures result contains exactly the keys of this Library
     */
    Sequence<String> sortedByWordCount();

}
