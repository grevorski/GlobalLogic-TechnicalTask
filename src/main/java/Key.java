import java.util.Objects;

public class Key {
    private final String letters;
    private final int wordSize;

    public Key(String letters, int wordSize) {
        this.letters = letters;
        this.wordSize = wordSize;
    }

    public String getLetters() {
        return letters;
    }

    public int getWordSize() {
        return wordSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return getWordSize() == key.getWordSize() &&
                getLetters().equals(key.getLetters());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLetters(), getWordSize());
    }

    @Override
    public String toString() {
        return "(" + letters + ")"  + ", " + wordSize;
    }
}
