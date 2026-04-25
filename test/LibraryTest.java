import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;

/**
 * test file.
 *
 * use cases can inlcude making a perseonal libarary with books you have finshed
 * and books you wnat to read. You can organize them to see the longest book you
 * have read. For the future, you can add different sorts. Another use is for
 * libraians to organize libraries. This makes it easier to sort which books are
 * avialbe and maybe in the futre you can implemet a has author method to find
 * books by a certian author.
 *
 * Reflection: I have learned alot about data structures durign this project. I
 * spent a lot of time trying to visulaize how I would orgaize this data, and I
 * learned alot of the different implemntations I could do. Although I rushed
 * alot for this project, I have learned alot on coding, test cases, the
 * differnt layers to impment a component. I now have adeerper understandign on
 * the differnt classes and interfaces that make up data structures.
 */
public abstract class LibraryTest {

    /**
     * Invokes the appropriate {@code List} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new Library
     * @ensures constructorTest = (<>, <>)
     */
    protected abstract Library constructorTest();

    /**
     * Invokes the appropriate {@code List} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new list
     * @ensures constructorRef = (<>, <>)
     */
    protected abstract Library constructorRef();

    /**
     * Helper that populates a {@code Library} with entries of title
     *
     * @param lib
     *            the Library to instert titles
     * @param titles
     *            book titles (keys)
     * @param authors
     *            authors
     * @param wordCounts
     *            word counts
     * @param done
     *            finished
     * @updates lib
     * @requires titles.length == authors.length == wordCounts.length ==
     *           finishedFlags.length and all titles are distinct
     * @ensures lib contains exactly the given (title, author, wordCount,
     *          finished) entries
     */
    private void createFromArgsHelper(Library lib, String[] titles,
            String[] authors, int[] wordCounts, boolean[] done) {
        for (int i = 0; i < titles.length; i++) {
            lib.add(titles[i], authors[i], wordCounts[i], done[i]);
        }
    }

    /**
     * Creates and returns a {@code Library} of the implementation under test
     * type with the given entries.
     *
     * @param titles
     *            book titles (keys)
     * @param authors
     *            authors
     * @param wordCounts
     *            word counts
     * @param done
     *            finished statuc
     * @return the finshed Library
     * @requires titles.length == authors.length == wordCounts.length ==
     *           finishedFlags.length and all titles are distinct
     * @ensures createFromArgsTest contains exactly the given entries
     */
    protected final Library createFromArgsTest(String[] titles,
            String[] authors, int[] wordCounts, boolean[] done) {
        Library lib = this.constructorTest();
        this.createFromArgsHelper(lib, titles, authors, wordCounts, done);
        return lib;
    }

    /**
     * Creates and returns a {@code Library} of the reference implementation
     * type with the given entries.
     *
     * @param titles
     *            book titles (keys)
     * @param authors
     *            authors
     * @param wordCounts
     *            word counts
     * @param done
     *            finished flags
     * @return the finhsedd Library
     * @requires titles.length == authors.length == wordCounts.length ==
     *           finishedFlags.length and all titles are distinct
     * @ensures createFromArgsRef contains exactly the given entries
     */
    protected final Library createFromArgsRef(String[] titles, String[] authors,
            int[] wordCounts, boolean[] done) {
        Library lib = this.constructorRef();
        this.createFromArgsHelper(lib, titles, authors, wordCounts, done);
        return lib;
    }

    /**
     * Test empty.
     */
    @Test
    public final void testConstructor() {

        Library lib1 = this.constructorTest();
        Library lib2 = this.constructorRef();

        assertEquals(lib2, lib1);
    }

    /**
     * Test add.
     */
    @Test
    public final void testAddToEmptySize() {
        final int eighty = 80;
        Library lib1 = this.constructorTest();
        Library lib2 = this.createFromArgsRef(new String[] { "t1" },
                new String[] { "bob" }, new int[] { eighty },
                new boolean[] { true });
        /*
         * Call method under test
         */
        lib1.add("t1", "bob", eighty, true);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(lib2, lib1);
        assertEquals(1, lib1.size());
    }

    /**
     * Test add.
     */
    @Test
    public final void testAdd() {
        final int eighty = 80;
        final int five = 500000;
        final int six = 6000000;
        Library lib1 = this.constructorTest();
        Library lib2 = this.createFromArgsRef(new String[] { "t1", "t2", "t3" },
                new String[] { "bob", "rob", "job" },
                new int[] { eighty, five, six },
                new boolean[] { true, false, true, });

        lib1.add("t1", "bob", eighty, true);
        lib1.add("t2", "rob", five, false);
        lib1.add("t3", "job", six, true);

        assertEquals(lib2, lib1);
        assertEquals(1, lib1.size());
    }

    /**
     * Test size.
     */
    @Test
    public final void testSizeEmpty() {

        Library lib1 = this.constructorTest();
        Library lib2 = this.constructorRef();

        int size = lib1.size();

        assertEquals(0, size);
        assertEquals(lib2, lib1);
    }

    /**
     * Test size non empty.
     */
    @Test
    public final void testSize() {
        final int eighty = 80;
        final int five = 500000;
        final int six = 6000000;
        Library lib1 = this.constructorTest();
        Library lib2 = this.createFromArgsRef(new String[] { "t1", "t2", "t3" },
                new String[] { "bob", "rob", "job" },
                new int[] { eighty, five, six },
                new boolean[] { true, false, true, });

        lib1.add("t1", "bob", eighty, true);
        lib1.add("t2", "rob", five, false);
        lib1.add("t3", "job", six, true);

        int size = lib1.size();

        assertEquals(3, size);
        assertEquals(lib2, lib1);
    }

    /**
     * Test has title.
     */
    @Test
    public final void testHastitle() {
        final int eighty = 80;
        final int five = 500000;
        final int six = 6000000;
        Library lib1 = this.constructorTest();
        Library lib2 = this.createFromArgsRef(new String[] { "t1", "t2", "t3" },
                new String[] { "bob", "rob", "job" },
                new int[] { eighty, five, six },
                new boolean[] { true, false, true, });

        lib1.add("t1", "bob", eighty, true);
        lib1.add("t2", "rob", five, false);
        lib1.add("t3", "job", six, true);

        boolean result = lib1.hasTitle("t1");

        boolean result2 = lib2.hasTitle("t1");
        assertEquals(result, result2);
        assertTrue(result);
    }

    /**
     * Test hasTitle.
     */
    @Test
    public final void testHasTitleEmpty() {

        Library lib1 = this.constructorTest();
        Library lib2 = this.constructorRef();

        boolean result = lib1.hasTitle("bon");

        assertFalse(result);
        assertEquals(lib2, lib1);
    }

    /**
     * Test value.
     */
    @Test
    public final void testValue() {
        final int eighty = 80;
        final int five = 500000;
        final int six = 6000000;
        Library lib1 = this.constructorTest();
        Library lib2 = this.createFromArgsRef(new String[] { "t1", "t2", "t3" },
                new String[] { "bob", "rob", "job" },
                new int[] { eighty, five, six },
                new boolean[] { true, false, true, });

        lib1.add("t1", "bob", eighty, true);
        lib1.add("t2", "rob", five, false);
        lib1.add("t3", "job", six, true);

        String author = lib1.value("t1").author;

        assertEquals("bob", author);
        assertEquals(lib2, lib1);
    }

    /**
     * Test wordcount.
     */
    @Test
    public final void testwordCount() {
        final int eighty = 80;
        final int five = 500000;
        final int six = 6000000;
        Library lib1 = this.constructorTest();
        Library lib2 = this.createFromArgsRef(new String[] { "t1", "t2", "t3" },
                new String[] { "bob", "rob", "job" },
                new int[] { eighty, five, six },
                new boolean[] { true, false, true, });

        lib1.add("t1", "bob", eighty, true);
        lib1.add("t2", "rob", five, false);
        lib1.add("t3", "job", six, true);

        String author = lib1.value("t1").wordCOunt;

        assertEquals(eighty, author);
        assertEquals(lib2, lib1);
    }

    /**
     * Test finshed.
     */
    @Test
    public final void testDone() {
        final int eighty = 80;
        final int five = 500000;
        final int six = 6000000;
        Library lib1 = this.constructorTest();
        Library lib2 = this.createFromArgsRef(new String[] { "t1", "t2", "t3" },
                new String[] { "bob", "rob", "job" },
                new int[] { eighty, five, six },
                new boolean[] { true, false, true, });

        lib1.add("t1", "bob", eighty, true);
        lib1.add("t2", "rob", five, false);
        lib1.add("t3", "job", six, true);

        String author = lib1.value("t1").finished();

        assertTrue(finished);
        assertEquals(lib2, lib1);
    }

    /**
     * Test remove.
     */
    @Test
    public final void testRemove() {
        final int eighty = 80;
        final int five = 500000;
        final int six = 6000000;
        Library lib1 = this.constructorTest();
        Library lib2 = this.createFromArgsRef(new String[] { "t1", "t2", "t3" },
                new String[] { "bob", "rob", "job" },
                new int[] { eighty, five, six },
                new boolean[] { true, false, true, });

        lib1.add("t1", "bob", eighty, true);
        lib1.add("t2", "rob", five, false);
        lib1.add("t3", "job", six, true);

        Library1L.BookValues bv = lib1.remove("t1");

        assertEquals("bob", bv.author);
        assertEquals(eighty, bv.wordCount);
        assertTrue(bv.finished);
        assertEquals(lib2, lib1);
    }

    /**
     * Test remove any.
     */
    @Test
    public final void testRemoveany() {
        final int eighty = 80;
        final int five = 500000;
        final int six = 6000000;
        Library lib1 = this.constructorTest();
        Library lib2 = this.createFromArgsRef(new String[] { "t1", "t2", "t3" },
                new String[] { "bob", "rob", "job" },
                new int[] { eighty, five, six },
                new boolean[] { true, false, true, });

        lib1.add("t1", "bob", eighty, true);
        lib1.add("t2", "rob", five, false);
        lib1.add("t3", "job", six, true);

        Library1L.BookValues bv = lib1.removeAny();

        int size = lib1.size();

        assertEquals(2, size);
    }

    /**
     * Test isDone.
     */
    @Test
    public final void testisDone() {
        final int eighty = 80;
        final int five = 500000;
        final int six = 6000000;
        Library lib1 = this.constructorTest();
        Library lib2 = this.createFromArgsRef(new String[] { "t1", "t2", "t3" },
                new String[] { "bob", "rob", "job" },
                new int[] { eighty, five, six },
                new boolean[] { false, false, true, });

        lib1.add("t1", "bob", eighty, true);
        lib1.add("t2", "rob", five, false);
        lib1.add("t3", "job", six, true);
        lib1.isDone("t1", false);

        int size = lib1.size();

        assertEquals(2, size);
    }

    /**
     * Test sorted by title.
     */
    @Test
    public final void testsortedTtiles() {
        final int eighty = 80;
        final int five = 500000;
        final int six = 6000000;
        Library lib1 = this.constructorTest();
        Library lib2 = this.createFromArgsRef(new String[] { "t1", "t2", "t3" },
                new String[] { "bob", "rob", "job" },
                new int[] { eighty, five, six },
                new boolean[] { false, false, true, });

        lib1.add("t1", "bob", eighty, true);
        lib1.add("t2", "rob", five, false);
        lib1.add("t3", "job", six, true);
        lib1.isDone("t1", false);

        Sequence<String> sorted = lib1.sortedByTitle();

        assertEquals("t1", sorted.entry(0));
        assertEquals("t2", sorted.entry(1));
        assertEquals("t3", sorted.entry(2));
        assertEquals(lib2, lib1);
    }

    /**
     * Test sorted by wordcount.
     */
    @Test
    public final void testsortedWC() {
        final int eighty = 80;
        final int five = 500000;
        final int six = 6000000;
        Library lib1 = this.constructorTest();
        Library lib2 = this.createFromArgsRef(new String[] { "t1", "t2", "t3" },
                new String[] { "bob", "rob", "job" },
                new int[] { eighty, five, six },
                new boolean[] { false, false, true, });

        lib1.add("t1", "bob", eighty, true);
        lib1.add("t2", "rob", five, false);
        lib1.add("t3", "job", six, true);
        lib1.isDone("t1", false);

        Sequence<String> sorted = lib1.sortedByWordCount();

        assertEquals("t2", sorted.entry(0));
        assertEquals(lib2, lib1);
    }

}
