import components.map.Map;
import components.map.Map1L;
import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * javadoc.
 */
public final class Library {
    /**
     * Proof of Concept for Library.
     *
     * @author Mohana Pichika
     */

    //BookValues object
    private final class BookValues {

        /** The author of the book. */
        private String author;

        /** Total word count. */
        private int wordCount;

        /** True if the book has been finished. */
        private boolean finished;

        /**
         * something here.
         *
         * @param author
         * @param wordCount
         * @param finished
         */
        BookValues(String author, int wordCount, boolean finished) {
            this.author = author;
            this.wordCount = wordCount;
            this.finished = finished;
        }

        @Override
        public String toString() {
            return "author: " + this.author + ", words: " + this.wordCount
                    + ", finshed: " + this.finished;
        }

    }

    /**
     * rep.
     */
    private Map<String, BookValues> rep;

    /**
     * createnewrep.
     */
    private void createNewRep() {
        this.rep = new Map1L<>();
    }

    /**
     * No-argument constructor.
     */
    public Library() {
        this.createNewRep();
    }

    //Kernal Methods
    /**
     * Adds a book to this Library.
     *
     * @param title
     *            title (key)
     * @param author
     *            author of the book
     * @param wordCount
     *            total word count (>= 0)
     * @param finished
     *            true if the book has been read
     *
     */
    public void add(String title, String author, int wordCount,
            boolean finished) {
        this.rep.add(title, new BookValues(author, wordCount, finished));
    }

    /**
     * Removes the book with the given title and returns its value.
     *
     * @param title
     *            the title (key) to remove
     * @return the BookValue stored under title
     */
    public BookValues remove(String title) {
        return this.rep.remove(title).value();
    }

    /**
     * Removes and returns an arbitrary (key, value) pair.
     *
     * @return an arbitrary Map.Pair from the backing map
     */
    public Map.Pair<String, BookValues> removeAny() {
        return this.rep.removeAny();
    }

    /**
     * Returns the BookValue for the given title without removing it. *
     *
     * @param title
     *            the title to look up
     * @return the BookValue stored under title
     */
    public BookValues value(String title) {
        return this.rep.value(title);
    }

    /**
     * Reports whether the given title is a key in this Library.
     *
     * @param title
     *            the title to test
     * @return true iff title is a key in this Library
     */
    public boolean hasTitle(String title) {
        return this.rep.hasKey(title);
    }

    /**
     * Returns the number of books in this Library.
     *
     * @return |this|
     */
    public int size() {
        return this.rep.size();
    }

    //secondary methods

    /**
     * changes to done.
     *
     * @param title
     *            the title (key) of the book to update
     * @param finished
     *            the new finished status
     */
    public void isDone(String title, boolean finished) {
        BookValues old = this.remove(title);
        this.add(title, old.author, old.wordCount, finished);
    }

    /**
     * Returns a Sequence of all titles sorted alphabetically A to Z.
     *
     * @return new Sequence of titles in ascending alphabetical order
     */
    public Sequence<String> sortedByTitle() {
        Sequence<String> result = new Sequence1L<>();
        return result;
    }

    /**
     * main.
     *
     * @param args
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        Library lib = new Library();
        final int fiftyk = 50000;
        lib.add("Title 1", "Jane Doe", fiftyk, false);

        final int thirtyk = 30000;
        lib.add("Title 2", "John Doe", thirtyk, true);

        final int hunderedk = 100000;
        lib.add("Title 3", "Bob Ross", hunderedk, false);

        out.println("My Library");
        out.println(lib.toString());
        out.println("Total books: " + lib.size());
        out.println("Book 1 values");
        out.println(lib.value("Title 1"));
        out.println(lib.hasTitle("Title 2"));
        lib.isDone("Title 3", true);

        out.close();

    }

}
