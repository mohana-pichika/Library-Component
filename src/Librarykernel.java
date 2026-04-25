import components.standard.Standard;

/**
 * Kernal Interface.
 */
public interface Librarykernel extends Standard<Library> {
    /**
     * Adds a book to this Library.
     *
     * @param title
     *            the unique title (key)
     * @param author
     *            the author of the book
     * @param wordCount
     *            total word count
     * @param finished
     *            true if the book has been read
     * @requires title is not already a key in this Library
     * @ensures this = #this {(title, (author, wordCount, finished))}
     */
    void add(String title, String author, int wordCount, boolean finished);

    /**
     * Removes the book with the given title and returns its value.
     *
     * @param title
     *            the title (key) to remove
     * @return the {@code BookValues} that was stored under {@code title}
     * @requires title is a key in this Library
     * @ensures this in Library and remove = the value that was stored under
     *          title
     */
    BookValues remove(String title);

    /**
     * Removes and returns an arbitrary (title, value) pair from this Library.
     *
     * @return a object with the removed title and its {@code BookValue}
     * @requires size() > 0
     * @ensures the returned pair was in #this and this = #this retuned pair
     */
    BookValues removeAny();

    /**
     * Returns the value (author, wordCount, finished) for the given title
     * without removing it.
     *
     * @param title
     *            the title (key) to look up
     * @return the {@code BookValue} stored under {@code title}
     * @requires title is a key in this Library
     * @ensures value = the BookValue stored under title
     */
    BookValues value(String title);

    /**
     * Reports whether the given title is a key in this Library.
     *
     * @param title
     *            the title to test
     * @return true if title is a key in this Library
     * @ensures hasTitle = title in Library
     */
    boolean hasTitle(String title);

    /**
     * Returns the number of books in this Library.
     *
     * @return |this|
     * @ensures size = number of titles in this Library
     */
    int size();

}
