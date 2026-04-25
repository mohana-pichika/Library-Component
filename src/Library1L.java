import components.map.Map;
import components.map.Map1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Kernel implemntation.
 *
 * @convention <pre>
 * rep is not null, all titles are unique, all values are valid
 * </pre>
 * @correspondence <pre>
 * this = (title (author, wordCount, finished))
 *
 * </pre>
 */
public class Library1L extends Librarysecondary {
    //BookValues object
    /**
     * BookValues object.
     */
    public final class BookValues {

        /**
         * The author of the book.
         *
         */
        private String author;

        /**
         * Total word count.
         */
        private int wordCount;

        /**
         * True if the book has been finished.
         *
         */
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
    public Library1L() {
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
    @Override
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
    @Override
    public BookValues remove(String title) {
        return this.rep.remove(title).value();
    }

    /**
     * Removes and returns an arbitrary (key, value) pair.
     *
     * @return an arbitrary Map.Pair
     */
    @Override
    public Map.Pair<String, BookValues> removeAny() {
        return this.rep.removeAny();
    }

    /**
     * Returns the BookValue for the given title without removing it.
     *
     * @param title
     *            the title to look up
     * @return the BookValue stored under title
     */
    @Override
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
    @Override
    public boolean hasTitle(String title) {
        return this.rep.hasKey(title);
    }

    /**
     * Returns the number of books in this Library.
     *
     * @return |this|
     */
    @Override
    public int size() {
        return this.rep.size();
    }

    /**
     * newInstance.
     *
     * @return new instance of Library1L
     */
    @Override
    public Library1L newInstance() {
        return new Library1L();
    }

    /**
     * empties Library.
     *
     * @param lib
     *            the Library to transfer from
     */
    public void transferFrom(Library1L lib) {
        this.rep.transferFrom(lib.rep);
    }

    /**
     * Resets this Library to the empty state.
     *
     */
    @Override
    public void clear() {
        this.rep.clear();
    }

    /**
     * main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        Library lib = new Library1L();
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
