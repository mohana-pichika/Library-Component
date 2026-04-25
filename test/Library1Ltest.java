import components.list.List;
import components.list.List1L;
import components.list.List3;

/**
 * test.
 */
public class Library1Ltest extends LibraryTest {
    @Override
    protected final List<String> constructorTest() {
        return new List3<String>();
    }

    @Override
    protected final List<String> constructorRef() {
        return new List1L<String>();
    }
}
