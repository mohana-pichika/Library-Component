import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * Abstract Class.
 */
public abstract class Librarysecondary implements Library {
    @Override
    public void isDone(String title, boolean finished) {
        BookValues old = this.value(title);
        this.remove(title);
        this.add(title, old.author(), old.wordCount(), finished);
    }

    @Override
    public Sequence<String> sortedByTitle() {
        Sequence<String> result = new Sequence1L<>();
        for (String title : this) {
            result.add(result.length(), title);
        }

        for (int i = 1; i < result.length(); i++) {
            String key = result.remove(i);
            int j = i - 1;
            while (j >= 0 && result.entry(j).compareTo(key) > 0) {
                j--;
            }
            result.add(j + 1, key);
        }
        return result;
    }

    @Override
    public Sequence<String> sortedByWordCount() {
        Sequence<String> result = this.sortedByTitle();
        for (int i = 1; i < result.length(); i++) {
            String key = result.remove(i);
            int keyWords = value(key).wordCount();
            int j = i - 1;
            while (j >= 0
                    && this.value(result.entry(j)).wordCount() > keyWords) {
                j--;
            }
            result.add(j + 1, key);
        }
        return result;
    }
}
